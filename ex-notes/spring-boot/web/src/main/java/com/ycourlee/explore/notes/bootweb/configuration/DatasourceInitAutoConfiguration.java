package com.ycourlee.explore.notes.bootweb.configuration;

import com.ycourlee.explore.notes.bootweb.context.DataSourceBeanPostProcessor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yooonn
 * @date 2022.10.29
 */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(SqlInitRunnerConfiguration.class)
public class DatasourceInitAutoConfiguration {

    @Bean
    public DataSourceBeanPostProcessor dataSourceBeanPostProcessor(SqlInitRunnerConfiguration configuration) {
        return new DataSourceBeanPostProcessor(configuration);
    }
}
