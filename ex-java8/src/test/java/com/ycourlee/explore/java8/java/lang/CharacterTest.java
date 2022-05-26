package com.ycourlee.explore.java8.java.lang;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author yooonn
 * @date 2021.08.24
 */
public class CharacterTest {

    private static final Logger log = LoggerFactory.getLogger(CharacterTest.class);

    @Test
    public void mainTest() {
        Character character = '=';
        String string = String.valueOf(character);
        byte[] bytes = string.getBytes(StandardCharsets.UTF_8);
        log.info(Arrays.toString(bytes));
    }
}
