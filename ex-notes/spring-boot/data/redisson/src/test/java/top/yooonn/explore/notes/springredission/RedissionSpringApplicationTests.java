package top.yooonn.explore.notes.springredission;

import org.junit.jupiter.api.extension.ExtendWith;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.util.Pair;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.StopWatch;

import java.util.concurrent.TimeUnit;

/**
 * @author yooonn
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@ComponentScan("com.ycourlee.explore.notes.springredission")
@EnableAspectJAutoProxy
public class RedissionSpringApplicationTests implements ApplicationContextAware {

    private static final Logger             log = LoggerFactory.getLogger(RedissionSpringApplicationTests.class);
    protected            ApplicationContext applicationContext;
    @Autowired
    @Qualifier("redisson")
    protected            RedissonClient     redissonClient;

    public RLock getMultiLock(String... lockNames) {
        return redissonClient.getMultiLock(getLocks(lockNames));
    }

    public RLock[] getLocks(String... lockNames) {
        RLock[] rLocks = new RLock[lockNames.length];
        int i = 0;
        for (String lockName : lockNames) {
            rLocks[i++] = redissonClient.getLock(lockName);
        }
        return rLocks;
    }

    public RLock getLock(String lockName) {
        return redissonClient.getLock(lockName);
    }

    public Pair<RLock, Boolean> tryLock(String lockName) {
        return tryLock(lockName, -1, -1, TimeUnit.SECONDS);
    }

    public Pair<RLock, Boolean> tryLock(String lockName, long waitTimeout, TimeUnit unit) {
        return tryLock(lockName, waitTimeout, -1, unit);
    }

    public Pair<RLock, Boolean> tryLock(String lockName, long waitTimeout, long leaseTime, TimeUnit unit) {
        RLock lock = redissonClient.getLock(lockName);
        try {
            StopWatch stopWatch = new StopWatch(Thread.currentThread().getName());
            stopWatch.start();
            boolean res = lock.tryLock(waitTimeout, leaseTime, unit);
            stopWatch.stop();
            log.info(stopWatch.prettyPrint());
            if (!res) {
                log.debug(" get lock fail ,lockKey:{}", lockName);
                return Pair.of(lock, false);
            }
            log.debug(" get lock success ,lockKey:{}", lockName);
            return Pair.of(lock, true);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error(" get lock fail,lockKey:{}, cause:{} ",
                    lockName, e.getMessage());
            return Pair.of(lock, false);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
