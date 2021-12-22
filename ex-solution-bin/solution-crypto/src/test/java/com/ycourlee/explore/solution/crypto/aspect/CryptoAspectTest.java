package com.ycourlee.explore.solution.crypto.aspect;

import com.ycourlee.explore.solution.crypto.ApplicationContextRunningConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * @author yongjiang
 * @date 2021.12.16
 */
public class CryptoAspectTest extends ApplicationContextRunningConfiguration {

    private static final Logger log = LoggerFactory.getLogger(CryptoAspectTest.class);

    @Resource
    private CryptoAspectPointcutTest cryptoAspectPointcutTest;


}
