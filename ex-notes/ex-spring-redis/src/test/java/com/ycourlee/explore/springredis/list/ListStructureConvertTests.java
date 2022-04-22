package com.ycourlee.explore.springredis.list;

import com.ycourlee.explore.springredis.SpringTestEnv;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author yooonn
 * @date 2022.04.21
 */
public class ListStructureConvertTests extends SpringTestEnv {

    private static final Logger log = LoggerFactory.getLogger(ListStructureConvertTests.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void mainTest() {
        List<String> ints = new ArrayList<>();
        for (int i = 100; i < 2000; i++) {
            ints.add(UUID.randomUUID().toString());
        }
        String targetKey = "this:is:list:key";
        stringRedisTemplate.opsForList().leftPushAll(targetKey, ints);
        DataType type = stringRedisTemplate.type(targetKey);

        log.info("type: {}", type);
    }
}
