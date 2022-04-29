package com.ycourlee.explore.notes.elk.listener;

import com.ycourlee.explore.notes.elk.ElkApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.EventListener;

/**
 * @author yongjiang
 * @date 2022.03.07
 */
public class SpringNativeEventListener implements DisposableBean {

    private static final Logger log = LoggerFactory.getLogger(SpringNativeEventListener.class);
    private static final String DDL = "classpath*:META-INF/init-sql-20210314.sql";

    @EventListener
    public void applicationStartedEventListener(ApplicationStartedEvent event) {
        ConfigurableApplicationContext context = event.getApplicationContext();
        ElkApplication.InfoExposer.beans(context);
        ElkApplication.InfoExposer.systemEnvironment(context.getEnvironment());
        ElkApplication.InfoExposer.systemProperty(context.getEnvironment());
    }

    @Override
    public void destroy() throws Exception {
        log.info("destroying");
        // restoreDatabaseByScript(com.ycourlee.explore.bootprocess.context.ApplicationContext.get());
        log.info("database restored");
        log.info("destroyed");
    }
}
