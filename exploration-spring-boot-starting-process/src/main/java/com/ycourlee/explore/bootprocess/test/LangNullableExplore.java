package com.ycourlee.explore.bootprocess.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author yongjiang
 */
@Component
public class LangNullableExplore {

    private static final Logger log = LoggerFactory.getLogger(LangNullableExplore.class);

    public void nonNullAbout(@NonNull String hello, @NonNull Object world, @NonNull List<String> list) {
        log.info("hello = {}", hello);
        log.info("world = {}", world);
        log.info("list = {}", list);
    }

    public void nullableAbout(@Nullable String hello, @Nullable Object world, @Nullable List<String> list) {
        log.info("hello = {}", hello);
        log.info("world = {}", world);
        log.info("list = {}", list);
    }
}
