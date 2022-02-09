package com.ycourlee.explore.solution.crypto.annotation;

import lombok.Getter;
import lombok.Setter;

/**
 * @author yongjiang
 * @date 2021.12.16
 */
@Setter
@Getter
public class PlaintextCryptoEnableGroupTest {

    @Plaintext(group = "1")
    private String hello;

    @Plaintext(group = "2")
    private String world;
}