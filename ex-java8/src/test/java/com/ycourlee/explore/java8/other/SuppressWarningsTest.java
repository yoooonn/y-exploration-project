package com.ycourlee.explore.java8.other;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author yooonn
 * @date 2022.01.22
 */
public class SuppressWarningsTest {

    private static final Logger log = LoggerFactory.getLogger(SuppressWarningsTest.class);


    @Test
    @SuppressWarnings({"rawtypes", "unchecked", "Convert2MethodRef",
            "SimplifyStreamApiCallChains", "CodeBlock2Expr",
            "ConstantConditions", "unused"})
    public void methodTest() {
        Integer a = null;

        log.info("a.toString(): {}", a.toString());

        List list = new ArrayList();

        List<String> stringList = (List<String>) list;

        list.add("1234");

        stringList.forEach(s -> System.out.println(s));

        stringList.stream().forEach(System.out::println);

        Stream<String> stringStream = stringList.stream().map(s -> {
            return s + "a";
        });
    }

    @Test
    public void statementTest() {
        Integer a = null;

        // noinspection ConstantConditions
        log.info("a.toString(): {}", a.toString());

        @SuppressWarnings("rawtypes")
        List list = new ArrayList();

        @SuppressWarnings("unchecked")
        List<String> stringList = (List<String>) list;

        // noinspection unchecked
        list.add("1234");

        // noinspection Convert2MethodRef
        stringList.forEach(s -> System.out.println(s));

        // noinspection SimplifyStreamApiCallChains
        stringList.stream().forEach(System.out::println);

        //noinspection unused
        Stream<String> stringStream = stringList.stream().map(s -> {
            // noinspection CodeBlock2Expr
            return s + "a";
        });
    }
}
