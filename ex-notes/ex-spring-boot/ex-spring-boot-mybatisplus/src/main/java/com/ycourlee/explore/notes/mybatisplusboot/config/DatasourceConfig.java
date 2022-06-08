package com.ycourlee.explore.notes.mybatisplusboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DelegatingDataSource;

import javax.sql.DataSource;

/**
 * @author yongjiang
 * @date 2022.06.02
 */
@Configuration
public class DatasourceConfig {

    // @Bean
    // public DataSource dataSource() {
    //     return new DelegatingDataSource();
    // }
}
