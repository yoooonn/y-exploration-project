package com.ycourlee.explore.solution.crypto;

import org.bouncycastle.util.encoders.Base64;

import java.net.UnknownHostException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

/**
 * @author yongjiang
 * @date 2021.11.15
 */
public class RsaKeyPairFactory extends BCJcaJceHelperHolder implements Factory<KeyPair> {

    public static void main(String[] args) throws NoSuchAlgorithmException, UnknownHostException {
        RsaKeyPairFactory factory = new RsaKeyPairFactory();
        KeyPair keyPair = factory.keyPair(4096, Algorithms.RSA);
        String privateKey = factory.privateKey(keyPair);
        String publicKey = factory.publicKey(keyPair);
    }

    public String publicKey(KeyPair keyPair) {
        return Base64.toBase64String(keyPair.getPublic().getEncoded());
    }

    public String privateKey(KeyPair keyPair) {
        return Base64.toBase64String(keyPair.getPrivate().getEncoded());
    }

    public KeyPair rsaKeyPair(int keySize) throws NoSuchAlgorithmException {
        return keyPair(keySize, Algorithms.RSA);
    }

    public KeyPair keyPair(int keySize, Algorithms algorithm) throws NoSuchAlgorithmException {
        KeyPairGenerator rsa = helper.createKeyPairGenerator(algorithm.name());
        rsa.initialize(keySize);
        return rsa.generateKeyPair();
    }

    @Override
    public KeyPair generate(Object obj) throws Exception {
        if (obj instanceof Number) {
            return rsaKeyPair(((Number) obj).intValue());
        }
        return rsaKeyPair(4096);
    }
}
