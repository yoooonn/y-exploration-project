package com.ycourlee.explore.solution.crypto.exception;

/**
 * @author yongjiang
 * @date 2021.12.16
 */
public class CryptoException extends RuntimeException {

    private static final long serialVersionUID = 2978094524735152681L;

    public CryptoException() {
    }

    public CryptoException(String message) {
        super(message);
    }
}
