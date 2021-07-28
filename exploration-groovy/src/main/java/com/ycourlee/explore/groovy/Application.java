package com.ycourlee.explore.groovy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author jiangyong
 */
@SpringBootApplication(scanBasePackages = "com.ycourlee.explore")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
