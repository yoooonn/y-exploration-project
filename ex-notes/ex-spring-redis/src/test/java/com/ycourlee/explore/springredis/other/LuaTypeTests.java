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
public class LuaTypeTests extends SpringTestEnv {

    private static final Logger log = LoggerFactory.getLogger(LuaTypeTests.class);

    @Test
    void mainTest() {
        Object resource = executeScriptResource("lua/type/s1.lua", String.class, Collections.emptyList());
        log.info("resource: {}", resource);
    }
}
