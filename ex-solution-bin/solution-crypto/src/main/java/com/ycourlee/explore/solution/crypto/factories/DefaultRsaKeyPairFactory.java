package com.ycourlee.explore.solution.crypto.factories;

import com.ycourlee.explore.solution.crypto.Algorithms;
import com.ycourlee.explore.solution.crypto.BCJcaJceHelperHolder;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

/**
 * @author yongjiang
 * @date 2021.11.15
 */
public class DefaultRsaKeyPairFactory extends BCJcaJceHelperHolder implements Factory<KeyPair, Integer> {

    public KeyPair keyPair(int keySize) throws NoSuchAlgorithmException {
        KeyPairGenerator rsa = helper.createKeyPairGenerator(Algorithms.RSA.name());
        rsa.initialize(keySize);
        return rsa.generateKeyPair();
    }

    @Override
    public KeyPair generate(Integer obj) throws Exception {
            return keyPair(((Number) obj).intValue());
    }
}
