package com.ycourlee.explore.notes.nacos.provider.listener.annotationbased;

import com.ycourlee.tranquil.redisson.WaitLockTimeoutException;
import com.ycourlee.tranquil.redisson.annotation.Lockable;
import lombok.SneakyThrows;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.InputStreamReader;
import java.sql.Connection;

/**
 * @author yooonn
 * @date 2022.02.09
 */
@Component
public class SpringNativeEventListener implements DisposableBean {

    private static final Logger log = LoggerFactory.getLogger(SpringNativeEventListener.class);
    private static final String DDL = "classpath*:META-INF/init-sql-20221030.sql";

    @EventListener
    public void applicationStartedEventListener(ApplicationStartedEvent event) {
        ConfigurableApplicationContext context = event.getApplicationContext();
        try {
            com.ycourlee.explore.notes.nacos.provider.context.ApplicationContext.get().getBean(getClass()).restoreDatabaseByScript(context);
            log.info("restore database success!");
        } catch (WaitLockTimeoutException ignored) {}
    }

    @SneakyThrows
    @Lockable(keys = "ex-notes:ex-spring-cloud:ex-nacos-service:init:db", leaseTime = -1)
    public void restoreDatabaseByScript(ApplicationContext context) {
        Connection connection = ((DataSource) context.getBean("dataSource")).getConnection();
        ScriptRunner scriptRunner = new ScriptRunner(connection);
        scriptRunner.setLogWriter(null);
        Resource[] resources = context.getResources(DDL);
        scriptRunner.runScript(new InputStreamReader(resources[0].getInputStream()));
        scriptRunner.closeConnection();
        connection.close();
    }

    @EventListener
    public void applicationContextRefreshedListener(ContextRefreshedEvent event) {
        log.info("context refreshed");
    }

    @Override
    public void destroy() throws Exception {
        log.info("destroyed");
    }
}
