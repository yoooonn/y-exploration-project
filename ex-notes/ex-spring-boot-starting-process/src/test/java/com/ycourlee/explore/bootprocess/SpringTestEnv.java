package com.ycourlee.explore.bootprocess;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationContextException;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author yongjiang
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTestEnv implements ApplicationContextAware {

    protected MockMvc mvc;

    protected ConfigurableApplicationContext applicationContext;

    protected ConfigurableEnvironment environment;

    protected ConfigurableBeanFactory beanFactory;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (applicationContext instanceof ConfigurableApplicationContext) {
            this.applicationContext = (ConfigurableApplicationContext) applicationContext;
            this.environment = this.applicationContext.getEnvironment();
            this.beanFactory = this.applicationContext.getBeanFactory();
        } else {
            throw new ApplicationContextException("");
        }
    }
}
