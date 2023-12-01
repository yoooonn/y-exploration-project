package top.yooonn.explore.faste.spring.boot.data.configuration;

import top.yooonn.explore.faste.spring.boot.data.autoconfigure.FasteDataConfiguration;
import top.yooonn.explore.faste.spring.boot.data.utils.Templates;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DatabaseDriver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author yooonn
 * @date 2022.10.29
 */
public class DataSourceBeanPostProcessor implements InstantiationAwareBeanPostProcessor, ApplicationContextAware {

    private static final Logger log = LoggerFactory.getLogger(DataSourceBeanPostProcessor.class);

    private final FasteDataConfiguration configuration;
    private       ApplicationContext     applicationContext;

    public DataSourceBeanPostProcessor(FasteDataConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public Object postProcessAfterInitialization(@NonNull Object bean, @NonNull String beanName) throws BeansException {
        if (configuration.getDb().isWhenStart() && bean instanceof DataSourceProperties) {
            DataSourceProperties properties = (DataSourceProperties) bean;
            String url = properties.getUrl();
            String username = properties.getUsername();
            String password = properties.getPassword();
            Connection connection = null;
            ScriptRunner scriptRunner = null;
            try {
                connection = DriverManager.getConnection(removePossibleDatabaseName(url), username, password);
                scriptRunner = new ScriptRunner(connection);
                scriptRunner.setAutoCommit(false);
                scriptRunner.setLogWriter(null);
                scriptRunner.setSendFullScript(false);
                scriptRunner.setStopOnError(false);
                Resource[] resources;
                resources = applicationContext.getResources(configuration.getDb().getScriptLocation());
                scriptRunner.runScript(new InputStreamReader(resources[0].getInputStream()));
            } catch (SQLException | IOException e) {
                throw new RuntimeException("execute sql script failed", e);
            } finally {
                Templates.closeQuietlyIfNotNull(connection);
            }
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    private String removePossibleDatabaseName(String url) {
        return url;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private interface UrlDatabaseNameFinder {

        DatabaseDriver type();

        String databaseName();

        String databaseLessUrl();
    }

    static class H2UrlDatabaseNameFinder implements UrlDatabaseNameFinder {

        private final String url;

        H2UrlDatabaseNameFinder(String url) {
            if (!url.startsWith("jdbc:h2:mem:") || url.length() == "jdbc:h2:mem:".length()) {
                // <a href="http://h2database.com/html/features.html#database_url" />
                throw new UnsupportedOperationException("Only support In-Memory(named) now");
            }
            this.url = url;
        }

        @Override
        public DatabaseDriver type() {
            return null;
        }

        @Override
        public String databaseName() {
            return null;
        }

        @Override
        public String databaseLessUrl() {
            return null;
        }
    }

    static class MysqlUrlDatabaseNameFinder implements UrlDatabaseNameFinder {

        private final String url;
        private       String databaseName;
        private       String databaseLessUrl;

        MysqlUrlDatabaseNameFinder(String url) {
            this.url = url;
        }

        @Override
        public DatabaseDriver type() {
            return DatabaseDriver.MYSQL;
        }

        @Override
        @Nullable
        public String databaseName() {
            if (databaseName != null) {
                return databaseName;
            }
            Pair<Integer, Integer> p = databaseNamePosition();
            if (p == null) {
                return url;
            }
            // l + 1 to r is database name
            return (databaseName = url.substring(p.getLeft(), p.getRight()));
        }

        public String databaseLessUrl() {
            if (databaseLessUrl != null) {
                return databaseLessUrl;
            }
            Pair<Integer, Integer> p = databaseNamePosition();
            if (p == null) {
                return url;
            }
            // l + 1 to r is database name, remove it
            return (databaseLessUrl = (url.substring(0, p.getLeft()) + url.substring(p.getRight())));
        }

        /**
         * @return null or [l, r)
         */
        private Pair<Integer, Integer> databaseNamePosition() {
            int l = url.lastIndexOf('/');
            if (l == -1) {
                throw new IllegalArgumentException("Bad url");
            }
            if (url.charAt(l - 1) == '/') {
                return null;
            }
            int r = url.length();
            int questionMark = url.lastIndexOf('?');
            if (questionMark != -1) {
                r = questionMark;
            }
            return ImmutablePair.of(l + 1, r);
        }
    }
}
