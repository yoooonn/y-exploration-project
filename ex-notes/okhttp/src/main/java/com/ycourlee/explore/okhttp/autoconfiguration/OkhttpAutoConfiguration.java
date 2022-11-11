package com.ycourlee.explore.okhttp.autoconfiguration;

import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.logging.HttpLoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

/**
 * @author yooonn
 * @date 2021.07.30
 */
@Configuration
@EnableConfigurationProperties(OkhttpProperties.class)
public class OkhttpAutoConfiguration {

    private static final Logger log = LoggerFactory.getLogger(OkhttpAutoConfiguration.class);

    @Autowired
    OkhttpProperties okhttpProperties;

    @Bean
    public OkHttpClient okHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
        return new Builder()
                .addNetworkInterceptor(httpLoggingInterceptor)
                .callTimeout(Duration.ofSeconds(30))
                .build();
    }

    @Bean
    public HttpLoggingInterceptor httpLoggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(s -> log.info(okhttpProperties.getLogPrefix(), s));
        loggingInterceptor.setLevel(okhttpProperties.getLevel());
        return loggingInterceptor;
    }
}
