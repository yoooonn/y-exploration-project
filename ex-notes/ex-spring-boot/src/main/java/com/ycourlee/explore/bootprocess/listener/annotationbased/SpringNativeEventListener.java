package com.ycourlee.explore.bootprocess.listener.annotationbased;

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
 * @author yongjiang
 * @date 2022.02.09
 */
@Component
public class SpringNativeEventListener implements DisposableBean {

    private static final Logger log = LoggerFactory.getLogger(SpringNativeEventListener.class);
    private static final String DDL = "classpath*:META-INF/init-sql-20210314.sql";

    @EventListener
    public void applicationStartedEventListener(ApplicationStartedEvent event) {
        log.info("\"started\": {}", "started");
        ConfigurableApplicationContext context = event.getApplicationContext();
        // BootProcessApplication.InfoExposer.beans(context);
        // BootProcessApplication.InfoExposer.systemEnvironment(context.getEnvironment());
        // BootProcessApplication.InfoExposer.systemProperty(context.getEnvironment());
        // BootProcessApplication.InfoExposer.applicationConversionService(context.getBeanFactory());
        restoreDatabaseByScript(context);
    }

    @EventListener
    public void applicationContextRefreshedListener(ContextRefreshedEvent event) {
        log.info("\"context refreshed\": {}", "context refreshed");
    }

    @SneakyThrows
    public static void restoreDatabaseByScript(ApplicationContext context) {
        Connection connection = ((DataSource) context.getBean("dataSource")).getConnection();
        ScriptRunner scriptRunner = new ScriptRunner(connection);
        scriptRunner.setLogWriter(null);
        Resource[] resources = context.getResources(DDL);
        scriptRunner.runScript(new InputStreamReader(resources[0].getInputStream()));
        scriptRunner.closeConnection();
        connection.close();
    }

    @Override
    public void destroy() throws Exception {
        log.info("destroying");
        // restoreDatabaseByScript(com.ycourlee.explore.bootprocess.context.ApplicationContext.get());
        log.info("database restored");
        log.info("destroyed");
    }
}
