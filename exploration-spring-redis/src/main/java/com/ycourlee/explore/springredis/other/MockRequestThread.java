package com.ycourlee.explore.springredis.other;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yongjiang
 */
public class MockRequestThread extends Thread {

    private static final Logger log = LoggerFactory.getLogger(MockRequestThread.class);

    @Override
    public synchronized void start() {
        super.start();
        log.info("MockRequestThread.class.getCanonicalName()+\"start\" = {}", MockRequestThread.class.getCanonicalName() + "start");
    }

    @Override
    public void run() {
        super.run();

    }
}
