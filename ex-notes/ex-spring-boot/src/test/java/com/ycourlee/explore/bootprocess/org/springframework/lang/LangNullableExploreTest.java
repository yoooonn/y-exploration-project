package com.ycourlee.explore.bootprocess.org.springframework.lang;

import com.ycourlee.explore.bootprocess.BootProcessApplicationTests;
import com.ycourlee.explore.bootprocess.test.LangNullableExplore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author yongjiang
 */
public class LangNullableExploreTest extends BootProcessApplicationTests {

    @Autowired
    private LangNullableExplore langNullableExplore;

    @Test
    void nonNullAboutTest() {
        langNullableExplore.nonNullAbout(hello(), null, new ArrayList<>());
    }

    @Test
    void nullableAboutTest() {
        langNullableExplore.nullableAbout(null, null, new ArrayList<>());
    }

    @Nullable
    private String hello() {
        if (new Date().getTime() == System.currentTimeMillis()) {
            return null;
        }
        return "hello";
    }
}
