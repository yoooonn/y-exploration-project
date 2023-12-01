package top.yooonn.explore.notes.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ExEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExEurekaServerApplication.class, args);
    }

}
