package com.ycourlee.explore.groovy.groovy.lang;

import com.ycourlee.root.mocks.UnitTestResource;
import groovy.lang.GroovyClassLoader;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author yongjiang
 * @date 2021.07.06
 */
public class GroovyClassLoaderTest extends UnitTestResource {

    private static final Logger log = LoggerFactory.getLogger(GroovyClassLoaderTest.class);

    @Test
    public void parseClassTest() throws IOException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
        Class<?> aClass = groovyClassLoader.parseClass(new File(RESOURCE_DIR + "/a.txt"));
        Object instance = aClass.newInstance();
        Method sendEmail = aClass.getDeclaredMethod("sendEmail", String.class);
        Object yongjiang = sendEmail.invoke(instance, "yongjiang");
        log.info("yongjiang = {}", yongjiang);
    }

    @Test
    public void aTest() {
    }
}
