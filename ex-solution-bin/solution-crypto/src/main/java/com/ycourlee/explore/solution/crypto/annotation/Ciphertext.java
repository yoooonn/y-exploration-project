package com.ycourlee.explore.solution.crypto.annotation;

import com.ycourlee.explore.solution.crypto.Algorithms;

import java.lang.annotation.*;

/**
 * @author yongjiang
 * @date 2021.11.12
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Ciphertext {

    Category category() default Category.TEXT;

    Algorithms algorithm() default Algorithms.AES;

    String keyGroup() default "";

    String group() default "";

    boolean urlSafely() default false;
}
