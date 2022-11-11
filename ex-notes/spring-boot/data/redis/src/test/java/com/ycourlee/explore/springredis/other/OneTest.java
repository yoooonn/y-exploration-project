package com.ycourlee.explore.springredis.other;

import com.ycourlee.explore.springredis.RedisRelatesApplicationTests;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Arrays;

/**
 * @author yooonn
 */
public class OneTest extends RedisRelatesApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(OneTest.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    void countExistingKeysTest() {
        Long keys = redisTemplate.countExistingKeys(Arrays.asList("hello", "world"));
        log.info("keys: {}", keys);
    }

    @Test
    void getTest() {
        String jy = redisTemplate.opsForValue().get("jy");
        System.out.println("redisTemplate.opsForValue().get(\"hello\") = " + jy);
    }

    @Test
    void get2Test() {
        String hasdf = (String) redisTemplate.opsForHash().get("hasdf", "12");

        System.out.println("hasdf = " + hasdf);

        Object a = null;

        String b = (String) a;

        System.out.println("b = " + b);

    }

    @Test
    void hsetTest() {
        redisTemplate.opsForHash().delete("hello:world", "345");
    }


    @Test
    void incrTest() {
        System.out.println("redisTemplate.opsForValue().increment(\"hello\", 1) = " + redisTemplate.opsForValue().increment("hello", 1));
    }
}
