package com.ycourlee.explore.springredis.other;

import com.ycourlee.explore.springredis.SpringTestEnv;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.script.DefaultRedisScript;

import java.util.Collections;

/**
 * @author yongjiang
 * @date 2022.02.07
 */
public class LuaScriptTest extends SpringTestEnv {

    private static final Logger log = LoggerFactory.getLogger(LuaScriptTest.class);

    @Test
    void mainTest() {
        String result = ;
        log.info("result: {}", result);
    }
}
