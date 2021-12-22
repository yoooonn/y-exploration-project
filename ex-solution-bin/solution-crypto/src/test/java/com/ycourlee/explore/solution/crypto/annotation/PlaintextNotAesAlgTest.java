package com.ycourlee.explore.solution.crypto.annotation;

import com.ycourlee.explore.solution.crypto.Algorithms;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yongjiang
 * @date 2021.12.16
 */
@Setter
@Getter
public class PlaintextNotAesAlgTest {

    @Plaintext(algorithm = Algorithms.RSA)
    private String hello;
}
