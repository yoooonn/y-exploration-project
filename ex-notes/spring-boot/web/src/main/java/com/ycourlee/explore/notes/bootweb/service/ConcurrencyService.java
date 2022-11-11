package com.ycourlee.explore.notes.bootweb.service;

import com.ycourlee.tranquil.redisson.annotation.Lockable;

/**
 * @author yooonn
 * @date 2022.06.23
 */
public interface ConcurrencyService {

    void addAge(Long uid) throws InterruptedException;

    @Lockable(value = "add:age:{{uid}}")
    void addAgeNoLock(Long uid) throws InterruptedException;
}
