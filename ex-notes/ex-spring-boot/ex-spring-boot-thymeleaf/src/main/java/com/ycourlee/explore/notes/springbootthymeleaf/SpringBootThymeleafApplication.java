package com.ycourlee.explore.notes.springbootthymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author yooonn
 */
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class
})
public class SpringBootThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootThymeleafApplication.class, args);
    }
}
