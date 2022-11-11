package com.ycourlee.explore.springredis.manual;

import com.ycourlee.explore.springredis.RedisRelatesApplicationTests;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.ReturnType;
import org.springframework.data.redis.core.RedisConnectionUtils;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;

import java.nio.charset.StandardCharsets;
import java.util.Collections;

/**
 * @author yooonn
 * @date 2022.04.01
 */
public class ZsetOperationTests extends RedisRelatesApplicationTests {

    public static final String Z_ADD_ORDER_NODE =
            "redis.call('zRem', KEYS[1], ARGV[2]); " +
                    "redis.call('set', ARGV[2], ARGV[3], 'ex', ARGV[4]); " +
                    "return redis.call('zAdd', KEYS[1], ARGV[1], ARGV[2]);";
    public static final String Z_POP_MIN_ORDER_NODE =
            "local value = redis.call('zRange', KEYS[1], '0', '0'); " +
                    "if (next(value) == nil) then " +
                    "    return nil " +
                    "else " +
                    "    redis.call('zRem', KEYS[1], value[1]) " +
                    "    local json = redis.call('get', value[1]) " +
                    "    redis.call('del', value[1]) " +
                    "    return json " +
                    "end ;";
    public static final String Z_REM_ORDER_NODE =
            "redis.call('zRem', KEYS[1], ARGV[1]) " +
                    "local json = redis.call('get', ARGV[1]) " +
                    "redis.call('del', ARGV[1]) " +
                    "return json";
    private static final Logger log = LoggerFactory.getLogger(ZsetOperationTests.class);

    @Test
    void zAddOrderNodeTest() {
        Boolean s = zAddOrderNode("order:queue",
                100D,
                "iscar:order:1234",
                "{\"key\":\"value\",\"value\":124.4}",
                600);
        log.info("s: {}", s);
    }

    @Test
    void zAddOrderNode2Test() {
        Boolean s = zAddOrderNode2("order:queue",
                100D,
                "iscar:order:1234",
                "{\"key\":\"value\",\"value\":124.4}",
                600);
        log.info("s: {}", s);
    }

    @Test
    void zPopMinOrderNodeTest() {
        String s = zPopMinOrderNode("order:queue");
        log.info("s: {}", s);
    }

    @Test
    void zRemOrderNodeTest() {
        String s = zRemOrderNode("order:queue", "iscar:order:1234");
        log.info("s: {}", s);
    }

    @SneakyThrows
    public Boolean zAddOrderNode(String setKey, Double score, String memberKey, String orderJson, long orderCacheExpire) {
        // noinspection ConstantConditions
        Object eval = RedisConnectionUtils.getConnection(redisTemplate.getConnectionFactory())
                .eval(Z_ADD_ORDER_NODE.getBytes(StandardCharsets.UTF_8), ReturnType.BOOLEAN,
                        1, setKey.getBytes(StandardCharsets.UTF_8),
                        String.valueOf(score).getBytes(StandardCharsets.UTF_8),
                        memberKey.getBytes(StandardCharsets.UTF_8),
                        orderJson.getBytes(StandardCharsets.UTF_8),
                        String.valueOf(orderCacheExpire).getBytes(StandardCharsets.UTF_8));
        return ((Boolean) eval);
    }

    public Boolean zAddOrderNode2(String setKey, Double score, String memberKey, String orderJson, long orderCacheExpire) {
        RedisScript<Boolean> script = new DefaultRedisScript<>(Z_ADD_ORDER_NODE, Boolean.class);
        return redisTemplate.execute(script, Collections.singletonList(setKey),
                String.valueOf(score), memberKey, orderJson, String.valueOf(orderCacheExpire));
    }

    public String zPopMinOrderNode(String setKey) {
        RedisScript<String> script = new DefaultRedisScript<>(Z_POP_MIN_ORDER_NODE, String.class);
        return redisTemplate.execute(script, Collections.singletonList(setKey));
    }

    public String zRemOrderNode(String setKey, String memberKey) {
        RedisScript<String> script = new DefaultRedisScript<>(Z_REM_ORDER_NODE, String.class);
        return redisTemplate.execute(script, Collections.singletonList(setKey), memberKey);
    }
}
