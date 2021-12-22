package com.ycourlee.explore.solution.crypto.aes;

import com.ycourlee.explore.solution.crypto.ApplicationContextRunningConfiguration;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author yongjiang
 * @date 2021.12.16
 */
public class AesCryptoTest extends ApplicationContextRunningConfiguration {

    private static final Logger log = LoggerFactory.getLogger(AesCryptoTest.class);

    @Test
    void nullCiphertextTest() {
        String ciphertext = aesCrypto.ciphertext(null);
        log.info("ciphertext: {}", ciphertext);
        assertNull(ciphertext);
    }

    @Test
    void emptyCiphertextTest() {
        String ciphertext = aesCrypto.ciphertext("");
        log.info("ciphertext: {}", ciphertext);
        assertNotNull(ciphertext);
        assertTrue(ciphertext.length() > 0);
    }

    @Test
    void ciphertextTest() {
        String ciphertext = aesCrypto.ciphertext("hello", "group1");
        log.info("ciphertext: {}", ciphertext);
        String plaintext = aesCrypto.plaintext(ciphertext, "group1");
        assertEquals(plaintext, "hello");
    }
}
