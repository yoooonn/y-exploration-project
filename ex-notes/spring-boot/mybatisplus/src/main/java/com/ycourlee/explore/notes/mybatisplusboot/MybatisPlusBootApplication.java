package com.ycourlee.explore.notes.mybatisplusboot;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author yooonn
 */
@SpringBootApplication
@MapperScan(basePackages = "com.ycourlee.explore.notes.mybatisplusboot.mapper")
public class MybatisPlusBootApplication {

    private static final Logger log = LoggerFactory.getLogger(MybatisPlusBootApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MybatisPlusBootApplication.class, args);
        log.info("\"run\": {}", "run");
    }
}
