package com.ycourlee.explore.plugins;

import javax.annotation.Nonnull;

/**
 * @author yooonn
 * @date 2021.11.11
 */
public class Application {

    @SuppressWarnings("all")
    public static void main(String[] args) {
        print("hello");
        print(null);
    }

    @SuppressWarnings("NullableProblems")
    public static void print(@Nonnull String s) {
        System.out.println("s = " + s);
    }
}
