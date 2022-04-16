package com.ycourlee.explore.bootprocess.com.ycourlee.tranquil.annotation;

import com.ycourlee.tranquil.redisson.cache.annotation.Lockable;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author yongjiang
 * @date 2022.04.16
 */
@Component
public class LockableUsages {

    private static final Logger log = LoggerFactory.getLogger(LockableUsages.class);

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
}
