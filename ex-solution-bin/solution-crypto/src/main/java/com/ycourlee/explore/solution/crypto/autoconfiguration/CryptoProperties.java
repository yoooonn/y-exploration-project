package com.ycourlee.explore.solution.crypto.autoconfiguration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * @author yongjiang
 * @date 2021.11.12
 */
@Setter
@Getter
@ConfigurationProperties(prefix = CryptoProperties.PREFIX)
public class CryptoProperties {

    public static final String PREFIX = "crypto";

    private Boolean enable;

    /**
     * Must be divisible by 16
     */
    private String aesDefaultRawKey;

    /**
     * algorithm name/mode/padding
     * see <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#Cipher />
     */
    private String aesDefaultTransform;

    private Map<String, AesProp> aes;

    private Map<String, RsaProp> rsa;

    @Setter
    @Getter
    public static class AesProp {

        private String rawKey;

        private String transform;
    }

    @Setter
    @Getter
    public static class RsaProp {

        private String publicKey;
        private String privateKey;
    }
}
