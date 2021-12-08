package com.ycourlee.explore.solution.crypto;

import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * @author yongjiang
 * @date 2021.11.29
 */
public class AesKeyFactory extends BCJcaJceHelperHolder implements Factory<KeyGenerator> {

    @Override
    public KeyGenerator generate(Object obj) throws NoSuchAlgorithmException {
        KeyGenerator aes = helper.createKeyGenerator(Algorithms.AES.name());
        return aes;
    }

    public Key aesKey(int keySize) throws NoSuchAlgorithmException {
        KeyGenerator aes = generate(null);
        aes.init(keySize);
        return aes.generateKey();
    }
}
