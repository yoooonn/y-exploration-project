package com.ycourlee.explore.springredis.service;

/**
 * @author yooonn
 */
public interface TokenAcquireService {

    String availableTokenByDistributeLock();

    String availableTokenByDistributeLock2();

    String availableTokenBySynchronizedLock2();
}
