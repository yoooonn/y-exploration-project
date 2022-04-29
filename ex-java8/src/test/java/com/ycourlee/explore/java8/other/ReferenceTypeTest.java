package com.ycourlee.explore.java8.other;

import com.alibaba.fastjson.JSON;
import com.ycourlee.explore.java8.AbstractTest;
import com.ycourlee.explore.java8.mocks.Cat;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author yongjiang
 * @date 2021.12.21
 */
public class ReferenceTypeTest extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(ReferenceTypeTest.class);

    @Test
    public void objectTest() {

        Cat cat = new Cat("aa", "red");

        setBlackColor(cat);

        Assert.assertEquals(cat.getColor(), "black");

        setWhiteColor(cat);

        Assert.assertEquals(cat.getColor(), "white");

    }

    @Test
    public void arraySortTest() {
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("aa", "red"));
        cats.add(new Cat("cc", "black"));
        cats.add(new Cat("bb", "white"));
        sort(cats);
        log.info("cats.json: {}", JSON.toJSONString(cats));
    }

    @Test
    public void arraySort2Test() {
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("aa", "red"));
        cats.add(new Cat("cc", "black"));
        cats.add(new Cat("bb", "white"));
        sort2(cats);
        log.info("cats.json: {}", JSON.toJSONString(cats));
    }

    private void sort(List<Cat> cats) {
        cats.sort(Comparator.comparing(Cat::getName));
    }

    private void sort2(List<Cat> cats) {
        List<Cat> catsTemp = cats;
        catsTemp.sort(Comparator.comparing(Cat::getName));
    }

    private void setBlackColor(Cat cat) {
        cat.setColor("black");
    }

    private void setWhiteColor(Cat cat) {
        Cat catTemp = cat;
        catTemp.setColor("white");
    }
}
