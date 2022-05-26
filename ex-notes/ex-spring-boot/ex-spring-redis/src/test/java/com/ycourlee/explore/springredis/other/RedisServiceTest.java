package com.ycourlee.explore.springredis.other;

import com.ycourlee.explore.springredis.RedisAboutApplicationTests;
import com.ycourlee.explore.springredis.service.RedisService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

/**
 * @author yooonn
 * @date 2022.02.21
 */
public class RedisServiceTest extends RedisAboutApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(RedisServiceTest.class);

    @Autowired
    private RedisService redisService;

    @Test
    void main2Test() {
        List<String> keys = Arrays.asList("38950677, iscar:stock:online:73:553:20220222:06.00~07.00, iscar:stock:online:73:553:20220222:05.00~06.00, iscar:stock:online:73:553:20220222:07.00~08.00, iscar:stock:online:73:553:20220222:08.00~09.00, iscar:stock:online:73:553:20220222:09.00~10.00, iscar:stock:online:553:73:20220222:05.00~06.00, iscar:stock:online:553:73:20220222:06.00~07.00, iscar:stock:online:553:73:20220222:07.00~08.00, iscar:stock:online:789:73:20220222:05.00~06.00, iscar:stock:online:789:73:20220222:05.00~06.00, iscar:stock:online:789:73:20220222:06.00~07.00, iscar:stock:online:789:73:20220222:07.00~08.00, iscar:stock:online:789:73:20220222:08.00~09.00, iscar:stock:online:789:73:20220222:09.00~10.00, iscar:stock:online:789:73:20220222:07.00~08.00, iscar:stock:online:789:73:20220222:08.00~09.00, iscar:stock:online:786:73:20220222:05.00~06.00, iscar:stock:online:786:73:20220222:05.00~06.00, iscar:stock:online:786:73:20220222:06.00~07.00, iscar:stock:online:786:73:20220222:07.00~08.00, iscar:stock:online:786:73:20220222:08.00~09.00, iscar:stock:online:786:73:20220222:09.00~10.00, iscar:stock:online:786:73:20220222:07.00~08.00, iscar:stock:online:786:73:20220222:08.00~09.00, iscar:stock:online:73:786:20220222:05.00~06.00, iscar:stock:online:73:786:20220222:06.00~07.00, iscar:stock:online:73:786:20220222:07.00~08.00, iscar:stock:online:73:786:20220222:08.00~09.00, iscar:stock:online:73:786:20220222:09.00~10.00, iscar:stock:online:73:789:20220222:05.00~06.00, iscar:stock:online:73:789:20220222:06.00~07.00, iscar:stock:online:73:789:20220222:07.00~08.00, iscar:stock:online:73:789:20220222:08.00~09.00, iscar:stock:online:73:789:20220222:09.00~10.00".split(", "));
        log.info("keys.size(): {}", keys.size());
    }

    @Test
    void mainTest() {
        // Set<ZSetOperations.TypedTuple<String>> hello = redisService.zPopMin("hello", 1);
        List<String> keys = Arrays.asList("38950677, iscar:stock:online:73:553:20220222:06.00~07.00, iscar:stock:online:73:553:20220222:05.00~06.00, iscar:stock:online:73:553:20220222:07.00~08.00, iscar:stock:online:73:553:20220222:08.00~09.00, iscar:stock:online:73:553:20220222:09.00~10.00, iscar:stock:online:553:73:20220222:05.00~06.00, iscar:stock:online:553:73:20220222:06.00~07.00, iscar:stock:online:553:73:20220222:07.00~08.00, iscar:stock:online:789:73:20220222:05.00~06.00, iscar:stock:online:789:73:20220222:05.00~06.00, iscar:stock:online:789:73:20220222:06.00~07.00, iscar:stock:online:789:73:20220222:07.00~08.00, iscar:stock:online:789:73:20220222:08.00~09.00, iscar:stock:online:789:73:20220222:09.00~10.00, iscar:stock:online:789:73:20220222:07.00~08.00, iscar:stock:online:789:73:20220222:08.00~09.00, iscar:stock:online:786:73:20220222:05.00~06.00, iscar:stock:online:786:73:20220222:05.00~06.00, iscar:stock:online:786:73:20220222:06.00~07.00, iscar:stock:online:786:73:20220222:07.00~08.00, iscar:stock:online:786:73:20220222:08.00~09.00, iscar:stock:online:786:73:20220222:09.00~10.00, iscar:stock:online:786:73:20220222:07.00~08.00, iscar:stock:online:786:73:20220222:08.00~09.00, iscar:stock:online:73:786:20220222:05.00~06.00, iscar:stock:online:73:786:20220222:06.00~07.00, iscar:stock:online:73:786:20220222:07.00~08.00, iscar:stock:online:73:786:20220222:08.00~09.00, iscar:stock:online:73:786:20220222:09.00~10.00, iscar:stock:online:73:789:20220222:05.00~06.00, iscar:stock:online:73:789:20220222:06.00~07.00, iscar:stock:online:73:789:20220222:07.00~08.00, iscar:stock:online:73:789:20220222:08.00~09.00, iscar:stock:online:73:789:20220222:09.00~10.00".split(", "));
        log.info("keys.size(): {}", keys.size());
        Object script = redisService.executeScript("local score = redis.call('zScore', KEYS[2], KEYS[1]); local retCode = 0;if score + ARGV[1] < 0 then retCode = -1 else retCode = redis.call('zIncrBy', KEYS[2], ARGV[1], KEYS[1]) end;redis.call('zIncrBy', KEYS[3], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[4], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[5], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[6], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[7], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[8], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[9], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[10], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[11], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[12], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[13], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[14], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[15], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[16], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[17], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[18], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[19], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[20], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[21], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[22], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[23], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[24], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[25], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[26], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[27], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[28], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[29], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[30], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[31], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[32], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[33], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[34], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[35], ARGV[2], KEYS[1]);return retCode;"
                , keys
                , "1", "4");
        log.info("script.getClass(): {}", script.getClass());
        log.info("script: {}", script);
    }
}
