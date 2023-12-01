package top.yooonn.explore.springkafkaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

/**
 * @author yooonn
 */
@SpringBootApplication
public class SpringKafkaConsumerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringKafkaConsumerApplication.class, args);
        Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);

    }
}
