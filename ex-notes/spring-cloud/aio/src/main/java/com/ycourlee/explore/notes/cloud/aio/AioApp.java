package com.ycourlee.explore.notes.cloud.aio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

/**
 * @author yongjiang
 * @date 2022.11.15
 */
@SpringBootApplication
public class AioApp {

    private static final Logger log = LoggerFactory.getLogger(AioApp.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AioApp.class, args);
        while (context != null) {
            Arrays.stream(context.getBeanDefinitionNames()).sorted()
                    .forEach(log::debug);
            context = ((ConfigurableApplicationContext) context.getParent());
        }
    }
}
