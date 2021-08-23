package com.ycourlee.explore.okhttp.other;

import com.ycourlee.explore.okhttp.OkhttpApplicationTests;
import com.ycourlee.explore.okhttp.configuration.OkhttpConfiguration;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.io.IOException;

/**
 * @author yongjiang
 * @date 2021.07.30
 */
public class MainTest extends OkhttpApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(MainTest.class);

    @Autowired
    private OkHttpClient okHttpClient;

    @Test
    public void mainTest() throws IOException {
        Request request = new Request.Builder().url("https://www.baidu.com").build();

        Response response = okHttpClient.newCall(request).execute();
        log.info("response: {}", response);
    }
}
