package com.ycourlee.explore.notes.mapstruct.converter;

import com.alibaba.fastjson.JSON;
import com.ycourlee.explore.notes.mapstruct.converter.nested.NestedClassPropertyConverter;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @author yongjiang
 * @date 2021.11.01
 */
public class NestedClassPropertyConverterTest {

    private static final Logger log = LoggerFactory.getLogger(NestedClassPropertyConverterTest.class);

    @Test
    void mainTest() {
        NestedClassPropertyConverter.Employee a =
                NestedClassPropertyConverter.INSTANCE.asEmployee(
                        new NestedClassPropertyConverter.User("qwe"),
                        new NestedClassPropertyConverter.Company("c", new Date(), null), "a");
        log.info("a.json: {}", JSON.toJSONString(a));
    }
}