package com.ycourlee.explore.notes.bootweb.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author yooonn
 * @date 2021.11.22
 */
@Setter
@Getter
@ToString
public class Wrapper<T> {

    private T wrapped;

    public Wrapper() {
    }

    private Wrapper(T wrapped) {
        this.wrapped = wrapped;
    }

    public static <T> Wrapper<T> wrapped(T wrapped) {
        return new Wrapper<>(wrapped);
    }
}
