package com.ycourlee.explore.okhttp.configuration;

import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.logging.HttpLoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yongjiang
 * @date 2021.07.30
 */
@Configuration
public class OkhttpConfiguration {

    private static final Logger log = LoggerFactory.getLogger(OkhttpConfiguration.class);

    @Bean
    public OkHttpClient okHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
        return new Builder()
                .addNetworkInterceptor(httpLoggingInterceptor)
                .build();
    }

    @Bean
    public HttpLoggingInterceptor httpLoggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(s -> log.info("okhttp: {}", s));
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return loggingInterceptor;
    }
}
