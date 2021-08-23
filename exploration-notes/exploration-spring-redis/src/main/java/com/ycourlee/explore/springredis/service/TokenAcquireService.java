package com.ycourlee.explore.springredis.service;

/**
 * @author yongjiang
 */
public interface TokenAcquireService {

    String availableTokenByDistributeLock();

    String availableTokenByDistributeLock2();

    String availableTokenBySynchronizedLock2();
}
