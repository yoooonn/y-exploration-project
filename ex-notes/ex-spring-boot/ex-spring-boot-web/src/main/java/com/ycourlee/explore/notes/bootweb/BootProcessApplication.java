package com.ycourlee.explore.notes.bootweb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * @author jiangyong
 */
@EnableAsync
@EnableAspectJAutoProxy(exposeProxy = true)
@MapperScan("com.ycourlee.explore.basic.dao")
@SpringBootApplication
public class BootProcessApplication {

    private static final Logger log = LoggerFactory.getLogger(BootProcessApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(BootProcessApplication.class, args);
        // InfoExposer.beans(applicationContext);
        log.info("SpringApplication run method executed");
    }

    public static class InfoExposer {

        public static void applicationConversionService(ConfigurableBeanFactory beanFactory) {
            ConversionService conversionService = beanFactory.getConversionService();
            Assert.notNull(conversionService);
            conversionService.canConvert(Date.class, LocalDateTime.class);
        }

        public static void beans(ConfigurableApplicationContext applicationContext) {
            // Spring 容器管理的所有bean的name
            String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
            Arrays.stream(beanDefinitionNames).sorted().forEach(beanName -> log.debug("bean: {}", beanName));
        }

        public static void systemEnvironment(ConfigurableEnvironment environment) {
            // getSystemEnvironment()返回的是系统环境变量，比如PATH、GIT_HOME、JAVA_HOME等
            Map<String, Object> systemEnvironment = environment.getSystemEnvironment();
            log.debug("JSON.toJSONString(systemEnvironment) = {}", System.lineSeparator() + JSON.toJSONString(systemEnvironment, SerializerFeature.PrettyFormat, SerializerFeature.MapSortField));
        }

        public static void systemProperty(ConfigurableEnvironment environment) {
            // getSystemProperties()返回的有进程ID信息、系统及内核信息、jvm相关的属性、用户相关的属性、tomcat相关的属性、
            Map<String, Object> systemProperties = environment.getSystemProperties();
            log.debug("JSON.toJSONString(systemProperties) = {}", System.lineSeparator() + JSON.toJSONString(systemProperties, SerializerFeature.PrettyFormat, SerializerFeature.MapSortField));
        }
    }
}
