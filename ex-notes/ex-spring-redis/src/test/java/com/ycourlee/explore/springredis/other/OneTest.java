package com.ycourlee.explore.springredis.other;

import com.ycourlee.explore.springredis.SpringTestEnv;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Arrays;

/**
 * @author yongjiang
 */
public class OneTest extends SpringTestEnv {

    private static final Logger log = LoggerFactory.getLogger(OneTest.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void countExistingKeysTest() {
        Long keys = redisTemplate.countExistingKeys(Arrays.asList("hello", "world"));
        log.info("keys: {}", keys);
    }

    @Test
    public void getTest() {
        String jy = redisTemplate.opsForValue().get("jy");
        System.out.println("redisTemplate.opsForValue().get(\"hello\") = " + jy);
    }

    @Test
    public void get2Test() {
        String hasdf = (String) redisTemplate.opsForHash().get("hasdf", "12");

        System.out.println("hasdf = " + hasdf);

        Object a = null;

        String b = (String) a;

        System.out.println("b = " + b);

    }

    @Test
    public void hsetTest() {
        redisTemplate.opsForHash().delete("hello:world", "345");
    }


    @Test
    public void incrTest() {
        System.out.println("redisTemplate.opsForValue().increment(\"hello\", 1) = " + redisTemplate.opsForValue().increment("hello", 1));
    }
}