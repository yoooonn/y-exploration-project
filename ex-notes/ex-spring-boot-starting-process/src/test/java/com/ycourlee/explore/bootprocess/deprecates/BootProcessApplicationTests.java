package com.ycourlee.explore.bootprocess.deprecates;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationContextException;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

import static org.assertj.core.api.BDDAssertions.then;

/**
 * 使用TestRestTemplate，并在本地随机端口启动服务的方式进行测试的流程
 *
 * @author yongjiang
 */
// @RunWith(SpringRunner.class)
// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// @EnableAspectJAutoProxy(exposeProxy = true)
// @ComponentScan("com.ycourlee.explore.bootprocess")
public class BootProcessApplicationTests implements ApplicationContextAware {

    private static final Logger log = LoggerFactory.getLogger(BootProcessApplicationTests.class);
    // @LocalServerPort
    protected int port;
    // @Autowired
    protected TestRestTemplate testRestTemplate;

    protected String prefix;

    protected ConfigurableApplicationContext applicationContext;

    protected ConfigurableEnvironment environment;

    protected ConfigurableBeanFactory beanFactory;

    @PostConstruct
    void dealPrefix() {
        prefix = "http://localhost:" + this.port;
    }

    @Before
    public void shouldReturn200WhenSendingRequestToManagementEndpoint() throws Exception {
        @SuppressWarnings("rawtypes")
        ResponseEntity<Map> entity = this.testRestTemplate.getForEntity(
                this.prefix + "/actuator", Map.class);
        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        log.info("ping: {}", "pong");
    }

    protected Date toDate(LocalDateTime dateTime) {
        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    protected static LocalDateTime toLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (applicationContext instanceof ConfigurableApplicationContext) {
            this.applicationContext = (ConfigurableApplicationContext) applicationContext;
            this.environment = this.applicationContext.getEnvironment();
            this.beanFactory = this.applicationContext.getBeanFactory();
        } else {
            throw new ApplicationContextException("");
        }
    }
}
