package com.ycourlee.explore.solution.crypto.autoconfiguration;

import com.ycourlee.explore.solution.crypto.aes.AesCryptoExecutor;
import com.ycourlee.explore.solution.crypto.aes.CipherParam;
import com.ycourlee.explore.solution.crypto.factories.DefaultAesSecretKeyFactory;
import com.ycourlee.explore.solution.crypto.factories.DefaultCipherFactory;
import com.ycourlee.explore.solution.crypto.factories.Factory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/**
 * @author yongjiang
 * @date 2021.12.13
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(CryptoProperties.class)
@EnableConfigurationProperties(value = CryptoProperties.class)
@Import({AnnotationDrivenAesCryptoConfiguration.class})
@ConditionalOnCryptoEnabled
@EnableAspectJAutoProxy
public class CryptoAutoConfiguration {

    private final CryptoProperties cryptoProperties;

    public CryptoAutoConfiguration(CryptoProperties cryptoProperties) {
        this.cryptoProperties = cryptoProperties;
    }

    @Bean("aesSecretKeyFactory")
    @ConditionalOnMissingBean(name = "aesSecretKeyFactory")
    public Factory<SecretKey, String> aesSecretKeyFactory() {
        return new DefaultAesSecretKeyFactory();
    }

    @Bean("cipherFactory")
    @ConditionalOnMissingBean(name = "cipherFactory")
    public Factory<Cipher, CipherParam> cipherFactory() {
        return new DefaultCipherFactory();
    }

    @Bean
    @ConditionalOnMissingBean
    public AesCryptoExecutor aesCryptoExecutor(Factory<Cipher, CipherParam> cipherFactory,
                                               Factory<SecretKey, String> aesSecretKeyFactory) {
        CryptoProperties.AesPropInternal defaultProp = cryptoProperties.getCipher().getAes().getDefaultProp();
        return new AesCryptoExecutor(cipherFactory, aesSecretKeyFactory, defaultProp.getRawKey(),
                defaultProp.getAlgMode(), defaultProp.getAlgPadding(), defaultProp.getCbcModeIv());
    }
}
