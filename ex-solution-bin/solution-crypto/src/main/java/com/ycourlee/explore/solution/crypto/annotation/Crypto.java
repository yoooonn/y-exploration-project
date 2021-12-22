package com.ycourlee.explore.solution.crypto.annotation;

import java.lang.annotation.*;

/**
 * @author yongjiang
 * @date 2021.12.16
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Crypto {

    String[] enableGroups() default {""};
}
