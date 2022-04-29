package com.ycourlee.explore.java8.mocks;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author yongjiang
 * @date 2021.08.20
 */
@Setter
@Getter
@ToString
public class Cat {

    private String name = "hello";

    private String color;

    private Integer age = 2;

    public Cat() {
    }

    public Cat(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public Cat(String name, String color, Integer age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }
}
