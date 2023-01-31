package com.ycourlee.explore.notes.cloud.aio.configuration.logging;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import javax.servlet.Filter;

/**
 * @author yooonn
 * @date 2023.01.29
 */
@Configuration
public class LoggingConfiguration {

    @Bean
    @Order(Ordered.LOWEST_PRECEDENCE)
    public Filter globalLoggingFilter() {
        return new LoggingFilter();
    }
}
