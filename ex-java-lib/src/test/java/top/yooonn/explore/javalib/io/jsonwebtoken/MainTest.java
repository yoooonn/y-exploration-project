package top.yooonn.explore.javalib.io.jsonwebtoken;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

/**
 * @author yooonn
 * @date 2021.09.14
 */
public class MainTest {

    private static final Logger log = LoggerFactory.getLogger(MainTest.class);

    @Test
    void mainTest() {
        String hello = Jwts.builder()
                .setPayload("hello").signWith(SignatureAlgorithm.HS256, "owinegoiqwhegiwegfowinegoiqwhegiwegfowinegoiqwhegiwegf".getBytes(StandardCharsets.UTF_8))
                .compact();
        log.info("hello: {}", hello);
    }
}
