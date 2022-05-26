package com.ycourlee.explore.notes.bootweb.org.springframework.lang;

import com.ycourlee.explore.notes.bootweb.BootProcessApplicationTests;
import com.ycourlee.explore.notes.bootweb.test.LangNullableExplore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author yooonn
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
