package com.ycourlee.explore.springredis.other;

import com.ycourlee.explore.springredis.SpringTestEnv;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.RedisSystemException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author yongjiang
 * @date 2022.02.23
 */
public class PipelineTest extends SpringTestEnv {

    private static final Logger log = LoggerFactory.getLogger(PipelineTest.class);

    @Test
    void main3Test() {
        // executeScript("return redis.call('zrange', KEYS[1], )")
    }

    @Test
    void main2Test() {
        List<String> keys = Arrays.asList("asdf", "thisone");

        redisTemplate.executePipelined((RedisCallback<Object>) connection -> {
            connection.openPipeline();

            connection.set("asdf".getBytes(StandardCharsets.UTF_8), "asdf".getBytes(StandardCharsets.UTF_8));

            connection.zIncrBy("thisone".getBytes(StandardCharsets.UTF_8), 12.0, "hello".getBytes(StandardCharsets.UTF_8));

            byte[][] keyBytes = new byte[keys.size()][];
            int index = 0;
            for (String key : keys) {
                keyBytes[index++] = key.getBytes(StandardCharsets.UTF_8);
            }
            connection.del(keyBytes);

            connection.closePipeline();
            return null;
        });
    }

    @Test
    void mainTest() {
        redisTemplate.opsForValue().set("iscar:stock:online:110:132:20220224:08.00~09.00", "1");
        redisTemplate.opsForValue().set("iscar:stock:online:110:320:20220223:19.00~20.00", "1");
        redisTemplate.opsForValue().set("iscar:stock:online:110:132:20220224:15.00~16.00", "1");
        Set<String> keys = redisTemplate.keys("iscar:stock:online:*:*:*:*.00~*.00");
        assert keys != null;
        for (String key : keys) {
            redisTemplate.delete(key);
        }
    }

    @Test
    void lua1Test() {
        assertThrows(RedisSystemException.class, () -> {
            String script = "return redis.call('zpopmin', KEYS[1], ARGV[1])";
            String result = executeScript(script, Arrays.asList("hello"), "asdf");
            log.info("result: {}", result);
        });
    }
}
