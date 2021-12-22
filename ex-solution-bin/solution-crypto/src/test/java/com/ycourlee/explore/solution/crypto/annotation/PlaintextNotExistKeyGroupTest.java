package com.ycourlee.explore.solution.crypto.annotation;

import lombok.Getter;
import lombok.Setter;

/**
 * @author yongjiang
 * @date 2021.12.16
 */
@Setter
@Getter
public class PlaintextNotExistKeyGroupTest {

    @Plaintext(keyGroup = "group1000")
    private String hello;
}
