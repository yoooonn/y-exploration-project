package com.ycourlee.explore.solution.crypto.aes;

import com.ycourlee.explore.solution.crypto.exception.CryptoException;
import com.ycourlee.explore.solution.crypto.autoconfiguration.CryptoProperties;

/**
 * @author yongjiang
 * @date 2021.12.15
 */
public class AesCrypto {

    private CryptoProperties cryptoProperties;

    private AesCryptoExecutor aesCryptoExecutor;

    public AesCrypto(CryptoProperties cryptoProperties, AesCryptoExecutor aesCryptoExecutor) {
        this.cryptoProperties = cryptoProperties;
        this.aesCryptoExecutor = aesCryptoExecutor;
    }

    public String ciphertext(String plaintext) {
        return aesCryptoExecutor.ciphertext(plaintext);
    }

    public String ciphertext(String plaintext, boolean urlSafely) {
        return aesCryptoExecutor.ciphertext(plaintext, urlSafely);
    }

    public String ciphertext(String plaintext, String group) {
        return ciphertext(plaintext, group, false);
    }

    public String ciphertext(String plaintext, String group, boolean urlSafely) {
        CryptoProperties.AesProp aesProp = retrieveGroupProp(group);
        return aesCryptoExecutor.ciphertext(plaintext, aesProp.getRawKey(), aesProp.getTransform(), urlSafely);
    }

    public String plaintext(String ciphertext) {
        return aesCryptoExecutor.plaintext(ciphertext);
    }

    public String plaintext(String ciphertext, boolean urlSafely) {
        return aesCryptoExecutor.plaintext(ciphertext, urlSafely);
    }

    public String plaintext(String ciphertext, String group) {
        return plaintext(ciphertext, group, false);
    }

    public String plaintext(String ciphertext, String group, boolean urlSafely) {
        CryptoProperties.AesProp aesProp = retrieveGroupProp(group);
        return aesCryptoExecutor.plaintext(ciphertext, aesProp.getRawKey(), aesProp.getTransform(), urlSafely);
    }

    private CryptoProperties.AesProp retrieveGroupProp(String group) {
        CryptoProperties.AesProp aesProp = cryptoProperties.getAes().get(group);
        if (aesProp == null) {
            throw new CryptoException("Not found aes key group: " + group);
        }
        return aesProp;
    }
}
