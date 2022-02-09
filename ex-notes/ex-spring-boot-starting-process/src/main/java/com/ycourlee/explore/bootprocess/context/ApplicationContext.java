package com.ycourlee.explore.bootprocess.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * @author yongjiang
 * @date 2022.01.14
 */
@Component
public class ApplicationContext implements ApplicationContextAware {

    private static final Logger log = LoggerFactory.getLogger(ApplicationContext.class);

    private static org.springframework.context.ApplicationContext applicationContext;

    public static org.springframework.context.ApplicationContext get() {
        return applicationContext;
    }

    @Override
    public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext) throws BeansException {
        log.info("\"set application context\": {}", "set application context");
        ApplicationContext.applicationContext = applicationContext;
    }

    public static void publishEvent(ApplicationEvent applicationEvent) {
        applicationContext.publishEvent(applicationEvent);
    }
}