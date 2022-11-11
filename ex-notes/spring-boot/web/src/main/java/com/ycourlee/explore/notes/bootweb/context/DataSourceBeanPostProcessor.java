package com.ycourlee.explore.notes.bootweb.context;

import com.ycourlee.explore.notes.bootweb.configuration.SqlInitRunnerConfiguration;
import com.ycourlee.explore.notes.bootweb.utils.Templates;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;
import org.springframework.lang.NonNull;

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

    private final SqlInitRunnerConfiguration configuration;
    private       ApplicationContext         applicationContext;

    public DataSourceBeanPostProcessor(SqlInitRunnerConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public Object postProcessAfterInitialization(@NonNull Object bean, @NonNull String beanName) throws BeansException {
        if (configuration.isWhenStart() && bean instanceof DataSourceProperties) {
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
                resources = applicationContext.getResources(configuration.getScriptLocation());
                scriptRunner.runScript(new InputStreamReader(resources[0].getInputStream()));
            } catch (SQLException | IOException e) {
                throw new RuntimeException("execute sql script failed", e);
            } finally {
                Templates.runIfNotNull(scriptRunner, ScriptRunner::closeConnection);
                Templates.closeQuietlyIfNotNull(connection);
            }
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    private String removePossibleDatabaseName(String url) {
        int l = url.lastIndexOf('/');
        if (l == -1) {
            return url;
        }
        if (url.charAt(l - 1) == '/') {
            return url;
        }
        int r = url.length();
        int questionMark = url.lastIndexOf('?');
        if (questionMark != -1) {
            r = questionMark;
        }
        // l to r is database name, remove it
        return url.substring(0, l) + url.substring(r);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
