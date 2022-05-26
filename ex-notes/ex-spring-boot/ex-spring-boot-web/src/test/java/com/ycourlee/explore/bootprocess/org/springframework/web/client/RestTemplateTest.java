package com.ycourlee.explore.notes.bootweb.org.springframework.web.client;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpHeaders;
import org.assertj.core.util.Maps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yooonn
 * @date 2021.10.22
 */
public class RestTemplateTest {

    private static final Logger log = LoggerFactory.getLogger(RestTemplateTest.class);

    private final RestTemplate restTemplate = new RestTemplate();

    @Test
    void postForEntityTest() {
        Map<String, Object> obj = new HashMap<>();
        obj.put("params", Maps.newHashMap("hello", "world"));
        LinkedMultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.put(HttpHeaders.CONTENT_TYPE, Collections.singletonList("application/json"));
        ResponseEntity<String> response = restTemplate.postForEntity(
                "http://localhost:8000/generic/ping",
                new HttpEntity<>(JSON.toJSONString(obj), headers)
                , String.class);
        String body = response.getBody();
        log.info("body: {}", body);
    }

    @Test
    void getForEntityTest() {
        Assertions.assertThrows(Exception.class, () -> {
            ResponseEntity<String> response = restTemplate.getForEntity(
                    "http://localhost:8000/generic/ping"
                    , String.class);
            String body = response.getBody();
            log.info("body: {}", body);
        });
    }
}
