package com.ycourlee.explore.springredis.benchmark;

import com.ycourlee.explore.springredis.RedisRelatesApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author yooonn
 * @date 2022.04.24
 */
public class ZRemTest extends RedisRelatesApplicationTests {


    @Test
    void mainTest() throws InterruptedException {
        initData(10000);
        CountDownLatch latch = new CountDownLatch(1);
        new Thread(() -> {
            removeData(String.valueOf(ThreadLocalRandom.current().nextInt(10000)), String.valueOf(ThreadLocalRandom.current().nextInt(10000)),
                    String.valueOf(ThreadLocalRandom.current().nextInt(10000)), String.valueOf(ThreadLocalRandom.current()
                            .nextInt(10000)), String.valueOf(ThreadLocalRandom.current().nextInt(10000)),
                    String.valueOf(ThreadLocalRandom.current().nextInt(10000)), String.valueOf(ThreadLocalRandom.current()
                            .nextInt(10000)), String.valueOf(ThreadLocalRandom.current().nextInt(10000)));
            latch.countDown();
        }).start();

        latch.await();
        clearData();
    }

    private void clearData() {
        redisTemplate.delete("this:is:a:z:set");
    }

    private void removeData(Object... keys) {
        redisTemplate.opsForZSet().remove("this:is:a:z:set", keys);
    }

    private void initData(int count) {
        Set<ZSetOperations.TypedTuple<String>> dataSet = mockData(count);
        redisTemplate.opsForZSet().add("this:is:a:z:set", dataSet);
    }

    private Set<ZSetOperations.TypedTuple<String>> mockData(int count) {
        Set<ZSetOperations.TypedTuple<String>> data = new HashSet<>(count);
        for (int i = 0; i < count; i++) {
            data.add(new DefaultTypedTuple<>(String.valueOf(i), ((double) System.nanoTime())));
        }
        return data;
    }
}
