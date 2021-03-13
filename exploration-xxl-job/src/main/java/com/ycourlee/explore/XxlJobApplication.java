package com.ycourlee.explore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author yongjiang
 * @date 2021.01.23
 */
@EnableScheduling
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class XxlJobApplication {

    public static void main(String[] args) {
        SpringApplication.run(XxlJobApplication.class, args);
    }
}
