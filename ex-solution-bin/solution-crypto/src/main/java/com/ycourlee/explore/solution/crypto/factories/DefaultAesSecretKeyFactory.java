package com.ycourlee.explore.solution.crypto.factories;

import com.ycourlee.explore.solution.crypto.Algorithms;
import com.ycourlee.explore.solution.crypto.util.Assert;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yongjiang
 * @date 2021.11.29
 */
public class DefaultAesSecretKeyFactory implements Factory<SecretKey, String> {

    private Map<String, SecretKey> secretKeyCaches = new ConcurrentHashMap<>(2);

    @Override
    public SecretKey generate(String rawKey) {
        Assert.notNull(rawKey, "raw key must not be null, you can see 'crypto.cipher-aes-default-raw-key'");
        SecretKey cache = secretKeyCaches.get(rawKey);
        if (cache != null) {
            return cache;
        }
        if (rawKey.length() % 16 != 0) {
            throw new IllegalArgumentException("Length of raw key must be divide by 16");
        }
        byte[] keyBytes = rawKey.getBytes(StandardCharsets.UTF_8);
        SecretKey secretKey = new SecretKeySpec(keyBytes, Algorithms.AES.name());
        secretKeyCaches.put(rawKey, secretKey);
        return secretKey;
    }
}
