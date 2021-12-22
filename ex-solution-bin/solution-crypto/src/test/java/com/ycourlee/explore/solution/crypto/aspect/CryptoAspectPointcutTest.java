package com.ycourlee.explore.solution.crypto.aspect;

import com.ycourlee.explore.solution.crypto.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author yongjiang
 * @date 2021.12.16
 */
@Component
public class CryptoAspectPointcutTest {

    public CiphertextTest willNotBeWeaved() {
        CiphertextTest ciphertextTest = new CiphertextTest();
        ciphertextTest.setHello("hello");
        return ciphertextTest;
    }

}
