package com.ycourlee.explore.springredis.other;

import com.ycourlee.explore.springredis.SpringTestEnv;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Collections;

/**
 * @author yongjiang
 * @date 2021.08.05
 */
public class LeftPushAllTest extends SpringTestEnv {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void leftPushAllTest() {
        redisTemplate.opsForList().leftPushAll("an:list", Collections.emptyList());
    }
}
