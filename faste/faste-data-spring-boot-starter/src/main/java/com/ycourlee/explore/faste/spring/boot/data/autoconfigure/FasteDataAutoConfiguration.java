package com.ycourlee.explore.faste.spring.boot.data.autoconfigure;

import com.ycourlee.explore.faste.spring.boot.data.configuration.DataSourceBeanPostProcessor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yooonn
 * @date 2023.02.01
 */
@Configuration(proxyBeanMethods = false)
@EnableAutoConfiguration
@EnableConfigurationProperties(FasteDataConfiguration.class)
public class FasteDataAutoConfiguration {

    @Bean
    public DataSourceBeanPostProcessor dataSourceBeanPostProcessor(FasteDataConfiguration configuration) {
        return new DataSourceBeanPostProcessor(configuration);
    }
}
