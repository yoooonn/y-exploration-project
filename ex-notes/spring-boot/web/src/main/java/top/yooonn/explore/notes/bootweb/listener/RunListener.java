package top.yooonn.explore.notes.bootweb.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author yooonn
 * @date 2022.02.09
 */
public class RunListener implements SpringApplicationRunListener, DisposableBean {

    private static final Logger log = LoggerFactory.getLogger(RunListener.class);

    private SpringApplication application;

    public RunListener(SpringApplication application, String[] args) {
        this.application = application;
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        log.info("\"started\": {}", "started");
    }

    @Override
    public void starting() {
        log.info("\"starting\": {}", "starting");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        log.info("\"environment prepared\": {}", "environment prepared");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        log.info("\"context prepared\": {}", "context prepared");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        log.info("\"context loaded\": {}", "context loaded");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        log.info("\"running\": {}", "running");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        log.info("\"failed\": {}", "failed");
    }

    @Override
    public void destroy() throws Exception {
        log.info("\"destroy\": {}", "destroy");
    }
}
