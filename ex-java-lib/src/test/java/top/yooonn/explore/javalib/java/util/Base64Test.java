package top.yooonn.explore.javalib.java.util;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author yooonn
 * @date 2021.10.26
 */
public class Base64Test {

    private static final Logger log = LoggerFactory.getLogger(Base64Test.class);

    @Test
    void main2Test() {
        byte[] decode = Base64.getEncoder().encode("哈哈".getBytes(StandardCharsets.UTF_8));
        log.info("new String(decode): {}", new String(decode));
    }

    @Test
    void mainTest() {
        byte[] decode = Base64.getDecoder().decode("5ZOI5ZOI");
        log.info("new String(decode): {}", new String(decode));
    }
}
