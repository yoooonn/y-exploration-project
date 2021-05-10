package com.ycourlee.explore.springredis.other;

import com.ycourlee.explore.springredis.SpringTestEnv;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author yongjiang
 */
public class OneTest extends SpringTestEnv {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void getTest() {
        String jy = redisTemplate.opsForValue().get("jy");
        System.out.println("redisTemplate.opsForValue().get(\"hello\") = " + jy);
    }

    @Test
    public void incrTest() {
        System.out.println("redisTemplate.opsForValue().increment(\"hello\", 1) = " + redisTemplate.opsForValue().increment("hello", 1));
    }
}
