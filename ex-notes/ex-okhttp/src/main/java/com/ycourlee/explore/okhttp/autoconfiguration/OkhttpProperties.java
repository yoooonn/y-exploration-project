package com.ycourlee.explore.okhttp.autoconfiguration;

import lombok.Getter;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author yongjiang
 * @date 2021.08.23
 */
@Getter
@ConfigurationProperties(prefix = "okhttp")
public class OkhttpProperties {

    private static final String LOG_ARGS_MARKER = "{}";

    private HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.HEADERS;

    private String logPrefix = "";

    private Integer callTimeout = 30;

    public void setLevel(HttpLoggingInterceptor.Level level) {
        this.level = level;
    }

    public void setLogPrefix(String logPrefix) {
        if (logPrefix != null && !logPrefix.isEmpty() && !logPrefix.contains(LOG_ARGS_MARKER)) {
            this.logPrefix = logPrefix + ": " + LOG_ARGS_MARKER;
        }
    }

    public void setCallTimeout(Integer callTimeout) {
        this.callTimeout = callTimeout;
    }
}
