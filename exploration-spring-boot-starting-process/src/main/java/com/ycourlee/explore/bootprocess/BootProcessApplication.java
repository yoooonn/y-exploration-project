package com.ycourlee.explore.bootprocess;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Arrays;
import java.util.Map;

/**
 * @author jiangyong
 */
@SpringBootApplication
public class BootProcessApplication {

    private static final Logger log = LoggerFactory.getLogger(BootProcessApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(BootProcessApplication.class, args);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        log.info("beanDefinitionNames = {}", Arrays.toString(beanDefinitionNames));
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        Map<String, Object> systemEnvironment = environment.getSystemEnvironment();
        log.info("JSON.toJSONString(systemEnvironment) = {}", JSON.toJSONString(systemEnvironment));
        Map<String, Object> systemProperties = environment.getSystemProperties();
        log.info("JSON.toJSONString(systemProperties) = {}", JSON.toJSONString(systemProperties));
    }
}
