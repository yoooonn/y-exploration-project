package top.yooonn.explore.java8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

/**
 * @author yooonn
 * @date 2021.09.15
 */
@SpringBootApplication
public class Application {

    // private JwtHelper

    public static void main(String[] args) {
        String[] beanDefinitionNames = SpringApplication.run(Application.class, args).getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).sorted().forEach(System.out::println);

        String[] split = "&123".split("&");
        System.out.println("split.length = " + split.length);
    }
}
