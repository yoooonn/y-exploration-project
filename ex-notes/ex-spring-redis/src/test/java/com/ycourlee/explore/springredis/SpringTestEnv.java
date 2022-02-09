package com.ycourlee.explore.springredis;

import com.ycourlee.root.mocks.UnitTestResource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author yongjiang
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SpringTestEnv extends UnitTestResource {

    @Autowired
    protected StringRedisTemplate redisTemplate;

    @BeforeEach
    void beforeEach() {
        String pong = redisTemplate.execute(new DefaultRedisScript<>("return redis.call('ping');", String.class), Collections.emptyList());
        assertTrue("pong".equalsIgnoreCase(pong));
    }

    protected String executeScript(String script, List<String> keys, List<Object> args) {
        return redisTemplate.execute(new DefaultRedisScript<>(script, String.class), keys, args);
    }
}
