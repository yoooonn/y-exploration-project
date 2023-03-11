package com.ycourlee.explore.notes.bootweb.configuration;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.ycourlee.explore.notes.bootweb.context.DataSourceBeanPostProcessor;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yooonn
 * @date 2022.10.29
 */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(SqlInitRunnerConfiguration.class)
@AutoConfigureBefore({DataSourceAutoConfiguration.class, DruidDataSourceAutoConfigure.class})
public class DatasourceInitAutoConfiguration {

    @Bean
    public DataSourceBeanPostProcessor dataSourceBeanPostProcessor(SqlInitRunnerConfiguration configuration) {
        return new DataSourceBeanPostProcessor(configuration);
    }
}
