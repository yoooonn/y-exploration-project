package com.ycourlee.explore.java8.java.lang;

import com.ycourlee.explore.java8.interfaces.Compute;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author yooonn
 * @date 2021.03.26
 */
@Slf4j
public class ClassTest {

    @Test
    public void getDeclaredMethodsTest() {
        final Class<Compute> computeClass = Compute.class;
        log.info("computeClass.getName() = {}", computeClass.getName());
        final Method[] declaredMethods = computeClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            log.info("method.getName() = {}", method.getName());
        }
    }
}
