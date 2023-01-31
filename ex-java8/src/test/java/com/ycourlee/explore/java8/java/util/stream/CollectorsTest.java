package com.ycourlee.explore.java8.java.util.stream;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yooonn
 */
public class CollectorsTest {

    private static final Logger log = LoggerFactory.getLogger(CollectorsTest.class);

    static List<String> data = Arrays.asList("hello3", "world", "hello2", "hello8", "hello7", "hello4");

    @Test
    public void arrayToMapTest() {

    }

    @Test
    public void Test() {
        Map<String, String> collect = data.stream().collect(Collectors.toMap(s -> s.substring(0, 5), s -> s, (k1, k2) -> k2));
        log.info("JSON.toJSONString(collect) = {}", JSON.toJSONString(collect));
    }

    @Test
    public void toMapTest() {
        Foo foo = new Foo();
        Foo[] foos = new Foo[]{foo};

        Map<Integer, String> map = Arrays.stream(foos).collect(Collectors.toMap(e -> e.getCnt(), e -> e.getId(), (o, n) -> n));
    }

    @Setter
    @Getter
    @ToString
    private static class Foo {

        private String id;

        private Integer cnt;
    }
}
