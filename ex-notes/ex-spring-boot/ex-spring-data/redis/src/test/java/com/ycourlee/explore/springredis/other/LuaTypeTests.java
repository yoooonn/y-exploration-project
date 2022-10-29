package com.ycourlee.explore.springredis.other;

import com.ycourlee.explore.springredis.RedisRelatesApplicationTests;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;

/**
 * @author yooonn
 * @date 2022.04.03
 */
public class LuaTypeTests extends RedisRelatesApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(LuaTypeTests.class);

    @Test
    void s1Test() {
        Object resource = executeScriptResource("lua/type/s1.lua", String.class, Collections.emptyList());
        log.info("resource: {}", resource);
    }

    @Test
    void s2Test() {
        Object resource = executeScriptResource("lua/type/s2.lua", String.class, Collections.singletonList("asijg"));
        log.info("resource: {}", resource);
        log.info("resource.getClass(): {}", resource.getClass());
    }
}
