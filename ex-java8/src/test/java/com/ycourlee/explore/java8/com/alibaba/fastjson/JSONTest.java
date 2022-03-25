package com.ycourlee.explore.java8.com.alibaba.fastjson;

import com.alibaba.fastjson.JSON;
import com.ycourlee.explore.java8.AbstractTest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author yongjiang
 * @date 2022.02.15
 */
public class JSONTest extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(JSONTest.class);

    @Test
    public void mainTest() {
        A a = JSON.parseObject("", A.class);
        log.info("a: {}", a);
    }

    @Setter
    @Getter
    @ToString
    static class A{
        private Long id;

        private List<Object> list;

        private Set<Object> set = new HashSet<>();
    }
}
