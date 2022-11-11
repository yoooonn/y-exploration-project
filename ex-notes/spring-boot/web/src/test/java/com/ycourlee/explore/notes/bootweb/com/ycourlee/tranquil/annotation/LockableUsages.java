package com.ycourlee.explore.notes.bootweb.com.ycourlee.tranquil.annotation;

import com.ycourlee.tranquil.redisson.annotation.Lockable;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author yooonn
 * @date 2022.04.16
 */
public class LockableUsages {

    private static final Logger log = LoggerFactory.getLogger(LockableUsages.class);
    private static long sharedNumber  = 0;
    private static long sharedNumber1 = 100;

    private StringRedisTemplate redisTemplate;

    public LockableUsages(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Lockable(keys = "hello:lock", waitTime = 3)
    public void simple() {
        log.info("watch point: {}", 17);
    }

    @SneakyThrows
    @Lockable(keys = "{{lockName}}", waitTime = 3)
    public void simple(String lockName) {
        log.info("watch point: {}", 27);
        TimeUnit.SECONDS.sleep(1);
    }

    @SneakyThrows
    @Lockable(keys = "lock1:{{name}}", waitTime = 3)
    public void withPattern(String name) {
        log.info("watch point: {}, name: {}", 24, name);
        TimeUnit.SECONDS.sleep(1);
    }

    @SneakyThrows
    @Lockable(keys = {"lock1:{{name}}", "lock2"}, waitTime = 10)
    public void multiLock(String name) {
        log.info("watch point: {}, name: {}", 40, name);
        TimeUnit.SECONDS.sleep(5);
    }

    @Lockable(keys = "shared:num:incr", waitTime = 5)
    public void incrementSharedNumberInLock() {
        sharedNumber++;
    }

    @Lockable(keys = "shared:num1:incr", waitTime = 5)
    public void incrementSharedNumber1InLock() {
        sharedNumber1++;
    }

    @Lockable(keys = {
            "shared:num:incr",
            "shared:num1:incr",
    }, waitTime = 5)
    public void incrementTwoSharedNumberInLock() {
        sharedNumber++;
        sharedNumber1++;
    }

    public void incrementSharedNumberBySetNx() {
        while (true) {
            // noinspection ConstantConditions
            if (redisTemplate.opsForValue().setIfAbsent("shared:num:incr", "1")) {
                sharedNumber++;
                redisTemplate.delete("shared:num:incr");
                break;
            }
        }
    }

    public synchronized void incrementSharedNumberBySyncMethod() {
        sharedNumber++;
    }

    public void incrementSharedNumber() {
        sharedNumber++;
    }

    public Long sharedNumber() {
        return sharedNumber;
    }

    public Long sharedNumberToZero() {
        return sharedNumber = 0;
    }


}
