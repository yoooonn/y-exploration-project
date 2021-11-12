package com.ycourlee.explore.java8.java.util.stream;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yongjiang
 */
public class CollectorsTest {

    private static final Logger log = LoggerFactory.getLogger(CollectorsTest.class);

    static List<String> data = Arrays.asList("hello3", "world", "hello2", "hello8", "hello7", "hello4");

    @Test
    public void Test() {
        Map<String, String> collect = data.stream().collect(Collectors.toMap(s -> s.substring(0, 5), s -> s, (k1, k2) -> k2));
        log.info("JSON.toJSONString(collect) = {}", JSON.toJSONString(collect));
    }
}
