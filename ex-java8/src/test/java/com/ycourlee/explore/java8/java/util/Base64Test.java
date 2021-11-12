package com.ycourlee.explore.java8.java.util;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author yongjiang
 */
public class Base64Test {

    private static final Logger log = LoggerFactory.getLogger(Base64Test.class);

    @Test
    public void urlEncoderTest() {
        byte[] encode = Base64.getUrlEncoder()
                .encode("/api/v1/ycourlee@qq.com/2".getBytes(StandardCharsets.UTF_8));
        System.out.println("new String(encode) = " + new String(encode));
        log.info("Base64.getUrlEncoder().encode(\"/api/v1/ycourlee@qq.com/2\".getBytes(StandardCharsets.UTF_8)) = {}", encode);
    }
}
