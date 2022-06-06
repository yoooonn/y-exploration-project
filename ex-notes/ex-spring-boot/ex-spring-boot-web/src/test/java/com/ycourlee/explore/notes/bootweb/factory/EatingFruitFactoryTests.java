package com.ycourlee.explore.notes.bootweb.factory;

import com.ycourlee.explore.notes.bootweb.BootProcessApplicationTests;
import com.ycourlee.explore.notes.bootweb.service.EatingFruitSteps;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;

/**
 * @author yooonn
 * @date 2022.03.24
 */
public class EatingFruitFactoryTests extends BootProcessApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(EatingFruitFactoryTests.class);

    @Autowired
    private EatingFruitFactory eatingFruitFactory;

    @Test
    public void mainTest() {
        Iterator<EatingFruitSteps> iterator = eatingFruitFactory.get();
        while (iterator.hasNext()) {
            EatingFruitSteps next = iterator.next();
            log.info("next.name(): {}", next.name());
            next.beforeEat();
            next.eat();
            next.afterEat();
        }
    }
}
