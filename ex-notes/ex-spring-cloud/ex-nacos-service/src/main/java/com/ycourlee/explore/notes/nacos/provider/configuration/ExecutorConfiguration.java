package com.ycourlee.explore.notes.nacos.provider.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author yongjiang
 * @date 2022.03.25
 */
@Configuration
public class ExecutorConfiguration {

    @Bean("forEventListeners")
    public Executor executorForAsyncEventListener() {
        return new ThreadPoolExecutor(2, 8,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());
    }
}
