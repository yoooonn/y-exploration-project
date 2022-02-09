package com.ycourlee.explore.java8.java.util.function;

import com.alibaba.fastjson.JSON;
import com.ycourlee.explore.java8.AbstractTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author yongjiang
 * @date 2022.01.07
 */
public class ConsumerTest extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(ConsumerTest.class);

    @Test
    public void mainTest() {
        Map<String, Object> map = overwriteAnMap(m -> {
            m.put("other key", "an value");
            m.put("what", "uh");
        });
        log.info("map.json: {}", JSON.toJSONString(map));
    }

    private Map<String, Object> overwriteAnMap(Consumer<Map<String, Object>> consumer) {
        Map<String, Object> retMap = new HashMap<>();
        retMap.put("cat", "It's mine. Init it.");
        if (consumer != null) {
            consumer.accept(retMap);
        }
        return retMap;
    }
}
