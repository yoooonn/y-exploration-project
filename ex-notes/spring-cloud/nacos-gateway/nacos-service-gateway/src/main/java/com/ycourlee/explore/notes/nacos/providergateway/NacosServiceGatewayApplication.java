package com.ycourlee.explore.notes.nacos.providergateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yooonn
 * @date 2022.04.29
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosServiceGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosServiceGatewayApplication.class, args);
    }
}
