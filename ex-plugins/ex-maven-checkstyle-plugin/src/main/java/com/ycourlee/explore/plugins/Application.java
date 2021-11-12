package com.ycourlee.explore.plugins;

import lombok.NonNull;

import javax.annotation.Nonnull;

/**
 * @author yongjiang
 * @date 2021.11.11
 */
public class Application {

    public static void main(String[] args) {
        print("hello");
        print(null);
    }

    public static void print(@Nonnull String s) {
        System.out.println("s = " + s);
    }
}
