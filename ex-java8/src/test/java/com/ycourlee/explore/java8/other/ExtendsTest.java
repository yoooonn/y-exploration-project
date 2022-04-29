package com.ycourlee.explore.java8.other;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author yongjiang
 * @date 2021.07.29
 */
public class ExtendsTest {

    private static final Logger log = LoggerFactory.getLogger(ExtendsTest.class);

    @Test
    public void declaredFieldsTest() {
        Cat cat = new Cat();
        Field[] declaredFields = cat.getClass().getDeclaredFields();
        log.info("Arrays.toString(cat.getClass().getDeclaredFields()) = {}", Arrays.toString(declaredFields));

        Arrays.stream(declaredFields).forEach(field -> {
            Annotation[] annotations = field.getAnnotations();
            Arrays.stream(annotations).forEach(annotation -> {
                log.info("annotation.annotationType().getName() = {}", annotation.annotationType().getName());
            });
        });
    }

    /**
     * 这里itsName()执行的是Cat中的方法。
     */
    @Test
    public void extendTest() {
        Animal cat = new Cat();
        cat.setName("qw");
        log.info("cat = {}", cat);
        Animal animal = ((Animal) cat);
        animal.itsName();
    }

    @Test
    public void mainTest() {

        log.info("Arrays.toString(OrangeCat.class.getDeclaredFields()) = {}", Arrays.toString(OrangeCat.class.getDeclaredFields()));
        log.info("Arrays.toString(OrangeCat.class.getDeclaredMethods()) = {}", Arrays.toString(OrangeCat.class.getDeclaredMethods()));
        log.info("Arrays.toString(OrangeCat.class.getFields()) = {}", Arrays.toString(OrangeCat.class.getFields()));
        log.info("Arrays.toString(OrangeCat.class.getMethods()) = {}", Arrays.toString(OrangeCat.class.getMethods()));
    }

    /**
     * 这里itsName()执行的是Cat中的方法。
     */
    @Test
    public void extendTest2() {
        OrangeCat orangeCat = new OrangeCat();
        orangeCat.setName("qw");
        log.info("orangeCat.getName() = {}", orangeCat.getName());
        log.info("orangeCat = {}", orangeCat);
        Animal animal = ((Animal) orangeCat);
        animal.itsName();
    }

    @Setter
    @Getter
    @ToString
    static class Animal {

        private String name;

        public void itsName() {
            log.info("name = {}", name);
        }
    }

    @Setter
    @Getter
    @ToString
    static class Cat extends Animal {

        private String name;

        public void itsName() {
            log.info("name = {}", name);
        }
    }

    @ToString
    static class OrangeCat extends Cat {

    }
}
