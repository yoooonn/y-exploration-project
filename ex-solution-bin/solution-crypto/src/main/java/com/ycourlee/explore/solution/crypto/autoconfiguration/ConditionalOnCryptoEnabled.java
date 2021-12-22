package com.ycourlee.explore.solution.crypto.autoconfiguration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import java.lang.annotation.*;

/**
 * @author yongjiang
 * @date 2021.12.22
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
@Documented
@ConditionalOnProperty(prefix = CryptoProperties.PREFIX, name = "enable", havingValue = "true", matchIfMissing = true)
public @interface ConditionalOnCryptoEnabled {
}
