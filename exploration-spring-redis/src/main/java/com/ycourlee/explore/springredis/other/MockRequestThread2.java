package com.ycourlee.explore.springredis.other;

import com.ycourlee.explore.springredis.service.TokenAcquireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yongjiang
 */
@Component
public class MockRequestThread2 implements Runnable {

    @Autowired
    private TokenAcquireService tokenAcquireService;




    @Override
    public void run() {
        tokenAcquireService.availableTokenBySynchronizedLock();
    }
}
