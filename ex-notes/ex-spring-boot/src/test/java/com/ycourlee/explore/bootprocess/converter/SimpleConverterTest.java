package com.ycourlee.explore.bootprocess.converter;

import com.ycourlee.explore.bootprocess.BootProcessApplicationTests;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yongjiang
 * @date 2021.11.03
 */
public class SimpleConverterTest extends BootProcessApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(SimpleConverterTest.class);

    @Autowired
    private SimpleConverter simpleConverter;

    @Test
    void asStringTest() {
        log.info("simpleConverter.asString(5) = {}", simpleConverter.asString(5));;
    }
}
