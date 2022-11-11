package com.ycourlee.explore.springredis.other;

import com.ycourlee.explore.springredis.RedisRelatesApplicationTests;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.ReturnType;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.util.Assert;

import java.time.Duration;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author yooonn
 * @date 2021.08.05
 */
public class LeftPushAllTest extends RedisRelatesApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(LeftPushAllTest.class);

    @Test
    void leftPushAllTest() {
        redisTemplate.opsForList().leftPushAll("an:list", Collections.emptyList());
    }

    @Test
    void main2Test() {
        Set<ZSetOperations.TypedTuple<String>> helloSet = zPopMin("helloSet", 3);
        helloSet.forEach(t -> {
            log.info("t.getValue(): {}", t.getValue());
            log.info("t.getScore(): {}", t.getScore());
        });
    }

    @Test
    void main3Test() {
        List execute = redisTemplate.execute(new DefaultRedisScript<>("return redis.call('zrange', KEYS[1], ARGV[1], ARGV[2], ARGV[3])", List.class),
                Arrays.asList("helloSet"), "0", "-1", "withscores");
        log.info("execute: {}", execute);
    }

    @SuppressWarnings({"rawtypes", "ConstantConditions", "unchecked"})
    private Set<ZSetOperations.TypedTuple<String>> zPopMin(String key, int count) {
        RedisScript<List> script = new DefaultRedisScript<>("return redis.call('zrange', KEYS[1], ARGV[1], ARGV[2], ARGV[3])", List.class);
        List<String> results = redisTemplate.execute(script, Arrays.asList("helloSet"), "0", "-1", "withscores");

        // assert results != null && results.size() % 2 == 0;
        Set<ZSetOperations.TypedTuple<String>> valueWithScores = new LinkedHashSet<>();
        for (int i = 0; i < results.size(); ) {
            valueWithScores.add(new DefaultTypedTuple<>(results.get(i++), Double.parseDouble(results.get(i++))));
        }
        return valueWithScores;
    }

    @SuppressWarnings("unchecked")
    private Set<ZSetOperations.TypedTuple<String>> zpopmin(String key, int count) {
        Object helloSet = eval("return redis.call('zpopmin', KEYS[1], ARGV[1])", ReturnType.MULTI, 1, key, String.valueOf(count));
        List<byte[]> raws = (List<byte[]>) helloSet;

        if (raws.size() % 2 != 0) {
            String[] errorResults = new String[raws.size()];
            for (int i = 0; i < raws.size(); i++) {
                errorResults[i] = redisTemplate.getStringSerializer().deserialize(raws.get(i));
            }
            log.error("zpopmin result count error, result: {}", Arrays.toString(errorResults));
            throw new IllegalStateException("zpopmin return result count error");
        }
        Set<ZSetOperations.TypedTuple<String>> result;
        try {
            result = new LinkedHashSet<>();
            for (int i = 0; i < raws.size(); ) {
                String value = redisTemplate.getStringSerializer().deserialize(raws.get(i++));
                String score = redisTemplate.getStringSerializer().deserialize(raws.get(i++));
                result.add(new DefaultTypedTuple<>(value, Double.parseDouble(score)));
            }
        } catch (Exception e) {
            String[] errorResults = new String[raws.size()];
            for (int i = 0; i < raws.size(); i++) {
                errorResults[i] = new String(raws.get(i));
            }
            log.error("zpopmin result deserialize error, result: {}", Arrays.toString(errorResults));
            throw new IllegalStateException(e);
        }
        return result;
    }

    public Object eval(String script, ReturnType returnType, int numberKeys, String... keysAndArgv) {
        byte[] rawScript = redisTemplate.getStringSerializer().serialize(script);
        Assert.notNull(rawScript);
        byte[][] rawKeysAndArgv = new byte[keysAndArgv.length][];
        int i = 0;
        for (String ka : keysAndArgv) {
            rawKeysAndArgv[i++] = redisTemplate.getStringSerializer().serialize(ka);
        }
        RedisConnectionFactory connectionFactory = redisTemplate.getConnectionFactory();
        // connectionFactory not null.
        return connectionFactory.getConnection().eval(rawScript, returnType, numberKeys, rawKeysAndArgv);
    }

    @Test
    void mainTest() {
        String helloSet = "helloSet";
        redisTemplate.opsForZSet().add(helloSet, String.valueOf((char) ('a' + (37 - 27))), 37 - 27);
        redisTemplate.opsForZSet().add(helloSet, String.valueOf((char) ('a' + (28 - 27))), 28 - 27);
        redisTemplate.opsForZSet().add(helloSet, String.valueOf((char) ('a' + (33 - 27))), 33 - 27);
        redisTemplate.opsForZSet().add(helloSet, String.valueOf((char) ('a' + (31 - 27))), 31 - 27);
        redisTemplate.opsForZSet().add(helloSet, String.valueOf((char) ('a' + (32 - 27))), 32 - 27);
        redisTemplate.opsForZSet().add(helloSet, String.valueOf((char) ('a' + (30 - 27))), 30 - 27);
        redisTemplate.opsForZSet().add(helloSet, String.valueOf((char) ('a' + (36 - 27))), 36 - 27);
        redisTemplate.opsForZSet().add(helloSet, String.valueOf((char) ('a' + (34 - 27))), 34 - 27);
        redisTemplate.opsForZSet().add(helloSet, String.valueOf((char) ('a' + (35 - 27))), 35 - 27);
        redisTemplate.opsForZSet().add(helloSet, String.valueOf((char) ('a' + (29 - 27))), 29 - 27);
        redisTemplate.expire(helloSet, Duration.ofDays(1));
        Long rank = redisTemplate.opsForZSet().reverseRank(helloSet, "6");
        log.info("rank: {}", rank);
        Set<String> range = redisTemplate.opsForZSet().range(helloSet, 0, -1);
        assertNotNull(range);
        range.forEach(s -> log.info("s: {}", s));
        // redisTemplate.opsForZSet().rangeWithScores()
    }
}
