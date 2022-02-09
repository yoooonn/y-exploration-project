package com.ycourlee.explore.bootprocess;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.SneakyThrows;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * @author jiangyong
 */
@MapperScan("com.ycourlee.explore.basic.dao")
@SpringBootApplication
public class BootProcessApplication {

    private static final Logger log = LoggerFactory.getLogger(BootProcessApplication.class);

    private static final String DDL = "classpath*:META-INF/init-sql-20210314.sql";

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(BootProcessApplication.class, args);
        ApplicationInfoExpose.beans(applicationContext);
        ApplicationInfoExpose.systemEnvironment(applicationContext.getEnvironment());
        ApplicationInfoExpose.systemProperty(applicationContext.getEnvironment());
        ApplicationInfoExpose.applicationConversionService(applicationContext.getBeanFactory());
        initDatabaseByScript(applicationContext);
    }

    @SneakyThrows
    public static void initDatabaseByScript(ApplicationContext context) {
        Connection connection = context.getBean(DataSource.class).getConnection();
        ScriptRunner scriptRunner = new ScriptRunner(connection);
        scriptRunner.setLogWriter(null);
        Resource[] resources = context.getResources(DDL);
        scriptRunner.runScript(new InputStreamReader(resources[0].getInputStream()));
        scriptRunner.closeConnection();
        connection.close();
    }

    static class ApplicationInfoExpose {

        static void applicationConversionService(ConfigurableBeanFactory beanFactory) {
            ConversionService conversionService = beanFactory.getConversionService();
            Assert.notNull(conversionService);
            conversionService.canConvert(Date.class, LocalDateTime.class);
        }

        static void beans(ConfigurableApplicationContext applicationContext) {
            // Spring 容器管理的所有bean的name
            String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
            Arrays.stream(beanDefinitionNames).sorted().forEach(beanName -> log.debug("{}", beanName));
        }

        static void systemEnvironment(ConfigurableEnvironment environment) {
            // getSystemEnvironment()返回的是系统环境变量，比如PATH、GIT_HOME、JAVA_HOME等
            Map<String, Object> systemEnvironment = environment.getSystemEnvironment();
            log.debug("JSON.toJSONString(systemEnvironment) = {}", System.lineSeparator() + JSON.toJSONString(systemEnvironment, SerializerFeature.PrettyFormat, SerializerFeature.MapSortField));
        }

        static void systemProperty(ConfigurableEnvironment environment) {
            // getSystemProperties()返回的有进程ID信息、系统及内核信息、jvm相关的属性、用户相关的属性、tomcat相关的属性、
            Map<String, Object> systemProperties = environment.getSystemProperties();
            log.debug("JSON.toJSONString(systemProperties) = {}", System.lineSeparator() + JSON.toJSONString(systemProperties, SerializerFeature.PrettyFormat, SerializerFeature.MapSortField));
        }
    }
}
