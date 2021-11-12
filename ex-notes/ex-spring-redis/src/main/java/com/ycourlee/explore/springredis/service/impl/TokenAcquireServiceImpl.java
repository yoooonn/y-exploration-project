package com.ycourlee.explore.springredis.service.impl;

import com.ycourlee.explore.springredis.service.TokenAcquireService;
import com.ycourlee.root.util.Assert;
import com.ycourlee.root.util.RandomUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.Duration;
import java.util.Objects;

/**
 * @author yongjiang
 */
@Service
public class TokenAcquireServiceImpl implements TokenAcquireService {

    private static final Logger log = LoggerFactory.getLogger(TokenAcquireServiceImpl.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public String availableTokenByDistributeLock() {
        String accessToken = redisTemplate.opsForValue().get(keyAccessToken());
        if (!StringUtils.isEmpty(accessToken)) {
            return accessToken + ", assert: " + Objects.equals(redisTemplate.opsForValue().get(keyAccessToken()), accessToken);
        }

        try {
            /*
             * http utils 对post请求的 connection timeout和socket timeout都为5s，这里设10s，多余的时间保证其他业务，同时认为redis是极高可用的
             * 避免锁因到期而释放引起finally块删后面线程获得的锁引起业务非预期的解决办法, 可以为获得锁的线程加守护线程（竞争、非竞争的哪个好，可以调研下），当锁快到期，为它续命
             * 后续可以调研下，并运用实践
             */
            if (Objects.equals(redisTemplate.opsForValue().setIfAbsent(accessTokenMutex(), "1", Duration.ofSeconds(5)), Boolean.TRUE)) {
                try {
                    accessToken = redisTemplate.opsForValue().get(keyAccessToken());
                    if (!StringUtils.isEmpty(accessToken)) {
                        return accessToken + ", assert: " + Objects.equals(redisTemplate.opsForValue().get(keyAccessToken()), accessToken);
                    }

                    accessToken = refreshToken();
                    Assert.notEmpty(accessToken);
                    if (Objects.equals(redisTemplate.opsForValue().setIfAbsent(keyAccessToken(), accessToken, Duration.ofSeconds(300)), true)) {
                        log.info("更新了access token: {}", accessToken);
                        return accessToken + ", assert: " + Objects.equals(redisTemplate.opsForValue().get(keyAccessToken()), accessToken);
                    }
                } catch (Exception e) {
                    log.error(e.getMessage());
                } finally {
                    redisTemplate.delete(accessTokenMutex());
                }
            }

            log.info("未获取到更新access token的锁，休眠1s等待查access token");
            Thread.sleep(1000);
            accessToken = redisTemplate.opsForValue().get(keyAccessToken());
            if (!StringUtils.isEmpty(accessToken)) {
                return accessToken + ", assert: " + Objects.equals(redisTemplate.opsForValue().get(keyAccessToken()), accessToken);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }

    @Override
    public String availableTokenByDistributeLock2() {
        String accessToken = redisTemplate.opsForValue().get(keyAccessToken());
        if (!StringUtils.isEmpty(accessToken)) {
            return accessToken + ", assert: " + Objects.equals(redisTemplate.opsForValue().get(keyAccessToken()), accessToken);
        }

        try {
            /*
             * http utils 对post请求的 connection timeout和socket timeout都为5s，这里设10s，多余的时间保证其他业务，同时认为redis是极高可用的
             * 避免锁因到期而释放引起finally块删后面线程获得的锁引起业务非预期的解决办法, 可以为获得锁的线程加守护线程（竞争、非竞争的哪个好，可以调研下），当锁快到期，为它续命
             * 后续可以调研下，并运用实践
             */
            if (Objects.equals(redisTemplate.opsForValue().setIfAbsent(accessTokenMutex(), "1", Duration.ofSeconds(5)), Boolean.TRUE)) {
                try {
                    accessToken = refreshToken();
                    Assert.notBlank(accessToken);
                    if (Objects.equals(redisTemplate.opsForValue().setIfAbsent(keyAccessToken(), accessToken, Duration.ofSeconds(300)), true)) {
                        log.info("更新了access token: {}", accessToken);
                        return accessToken + ", assert: " + Objects.equals(redisTemplate.opsForValue().get(keyAccessToken()), accessToken);
                    }
                } catch (Exception e) {
                    log.error(e.getMessage());
                } finally {
                    redisTemplate.delete(accessTokenMutex());
                }
            }

            log.info("未获取到更新access token的锁，休眠1s等待查access token");
            Thread.sleep(1000);
            accessToken = redisTemplate.opsForValue().get(keyAccessToken());
            if (!StringUtils.isEmpty(accessToken)) {
                return accessToken + ", assert: " + Objects.equals(redisTemplate.opsForValue().get(keyAccessToken()), accessToken);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }

    @Override
    public String availableTokenBySynchronizedLock2() {
        String accessToken = redisTemplate.opsForValue().get(keyAccessToken());
        if (!StringUtils.isEmpty(accessToken)) {
            return accessToken;
        }

        return null;
    }

    private String refreshToken() {
        return RandomUtil.nextRandomString();
    }

    private String keyAccessToken() {
        return "temp:mock:access_token";
    }

    private String accessTokenMutex() {
        return "temp:mutex:access_token";
    }

}