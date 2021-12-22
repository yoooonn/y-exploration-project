package com.ycourlee.explore.solution.crypto.autoconfiguration;

import com.ycourlee.explore.solution.crypto.aes.AesCrypto;
import com.ycourlee.explore.solution.crypto.aes.AesCryptoExecutor;
import com.ycourlee.explore.solution.crypto.aspect.CryptoAspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yongjiang
 * @date 2021.12.22
 */
@Configuration
@ConditionalOnCryptoEnabled
class AnnotationDrivenAesCryptoConfiguration {

    private CryptoProperties  cryptoProperties;
    private AesCryptoExecutor aesCryptoExecutor;

    AnnotationDrivenAesCryptoConfiguration(CryptoProperties cryptoProperties, AesCryptoExecutor aesCryptoExecutor) {
        this.cryptoProperties = cryptoProperties;
        this.aesCryptoExecutor = aesCryptoExecutor;
    }

    @Bean
    @ConditionalOnMissingBean
    AesCrypto aesCrypto() {
        return new AesCrypto(cryptoProperties, aesCryptoExecutor);
    }

    @Bean
    @ConditionalOnMissingBean
    CryptoAspect cryptoAspect(AesCrypto aesCrypto) {
        return new CryptoAspect(aesCrypto);
    }
}