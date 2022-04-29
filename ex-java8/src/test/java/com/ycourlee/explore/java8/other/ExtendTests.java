package com.ycourlee.explore.java8.other;

import com.ycourlee.explore.java8.AbstractTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yongjiang
 * @date 2022.03.29
 */
public class ExtendTests extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(ExtendTests.class);

    @Test
    public void mainTest() {
        Animal animal = new Cat();
        process(animal);
    }

    private void process(Animal animal) {
        if (animal instanceof Cat) {
            Cat cat = (Cat) animal;
            log.info("cat.getAge(): {}", cat.getAge());
            log.info("cat.clazz(): {}", cat.clazz());
        }
    }

    static interface Animal {

        String name();

        default String clazz() {
            return getClass().getSimpleName();
        }
    }

    static class Cat implements Animal {

        private String name;

        private int age = 1;

        @Override
        public String name() {
            return null;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
