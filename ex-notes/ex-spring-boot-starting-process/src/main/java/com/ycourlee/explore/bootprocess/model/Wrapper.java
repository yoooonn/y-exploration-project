package com.ycourlee.explore.bootprocess.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author yongjiang
 * @date 2021.11.22
 */
@Setter
@Getter
@ToString
public class Wrapper<T> {
    private T wrapped;

    private Wrapper(T wrapped) {
        this.wrapped = wrapped;
    }

    public static <T> Wrapper<T> wrapped(T wrapped) {
        return new Wrapper<>(wrapped);
    }
}
