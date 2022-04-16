package com.ycourlee.explore.springredis.other;

import com.ycourlee.explore.springredis.SpringTestEnv;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;

/**
 * @author yongjiang
 * @date 2022.04.03
 */
public class MainWatcher extends SpringTestEnv {

    private static final Logger log = LoggerFactory.getLogger(MainWatcher.class);

    @Test
    void mainTest() {
        Object o = executeScriptResource("lua/redissonTryLockInnerAsync.lua", String.class, Collections.emptyList());
        log.info("o: {}", o);
    }
}
