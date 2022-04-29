package com.ycourlee.explore.notes.bootweb.other;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author yongjiang
 * @date 2022.04.01
 */
public class FastJsonTests {

    private static final Logger log = LoggerFactory.getLogger(FastJsonTests.class);

    /**
     * 没有getters的字段，不参与fastjson的json序列化
     */
    @Test
    public void noGettersEntityToJSONStringTest() {
        Cat cat = new Cat();
        cat.setColor("w");
        cat.setName("hkl");
        String jsonString = JSON.toJSONString(cat);
        log.info("jsonString: {}", jsonString);
        assertEquals(jsonString, "{}");
    }

    /**
     * 没有默认构造方法的类，fastjson不可以对其反序列化
     */
    @Test
    public void noDefaultConstructEntityTParseObjectTest() {
        Fish fish = new Fish("w", "hkl");
        String jsonString = JSON.toJSONString(fish);

        assertThrows(Exception.class, () -> {
            Fish object = JSON.parseObject(jsonString, Fish.class);
        });

    }

    /**
     * 没有setters的字段，fastjson不可以对其反序列化
     */
    @Test
    public void noSettersEntityParseObjectTest() {
        Car car = new Car("w", "hkl");
        String jsonString = JSON.toJSONString(car);
        assertTrue(jsonString.contains("w"));
        assertTrue(jsonString.contains("hkl"));
        Car object = JSON.parseObject(jsonString, Car.class);
        assertNull(object.color);
        assertNull(object.name);
    }

    @Getter
    static class Car {

        private String name;

        private String color;

        public Car() {
        }

        public Car(String name, String color) {
            this.name = name;
            this.color = color;
        }
    }

    @Setter
    static class Cat {

        private String name;

        private String color;
    }

    @Getter
    @Setter
    static class Fish {

        private String name;

        private String color;

        public Fish(String name, String color) {
            this.name = name;
            this.color = color;
        }
    }
}
