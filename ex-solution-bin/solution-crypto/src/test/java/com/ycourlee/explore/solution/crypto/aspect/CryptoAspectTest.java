package com.ycourlee.explore.solution.crypto.aspect;

import com.alibaba.fastjson.JSON;
import com.ycourlee.explore.solution.crypto.ApplicationContextRunningConfiguration;
import com.ycourlee.explore.solution.crypto.annotation.*;
import com.ycourlee.explore.solution.crypto.exception.CryptoException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author yongjiang
 * @date 2021.12.16
 */
public class CryptoAspectTest extends ApplicationContextRunningConfiguration {

    private static final Logger log = LoggerFactory.getLogger(CryptoAspectTest.class);

    @Resource
    private CryptoAspectPointcutTest cryptoAspectPointcutTest;

    @Test
    void willNotBeWeavedTest() {
        CiphertextTest notBeWeaved = cryptoAspectPointcutTest.willNotBeWeaved();
        assertEquals("hello", notBeWeaved.getHello());
        log.info("notBeWeaved: {}", JSON.toJSONString(notBeWeaved));
    }

    @Test
    void simpleTest() {
        CiphertextTest simple = cryptoAspectPointcutTest.simple("hello");
        assertNotEquals(simple.getHello(), "hello");
        PlaintextTest simplePlaintext = cryptoAspectPointcutTest.simplePlaintext(simple.getHello());
        assertEquals(simplePlaintext.getHello(), "hello");
        log.info("simple: {}", JSON.toJSONString(simple));
        log.info("simplePlaintext: {}", JSON.toJSONString(simplePlaintext));
    }

    @Test
    void groupTest() {
        CiphertextCryptoEnableGroupTest group = cryptoAspectPointcutTest.group("hello", "world");
        assertNotEquals(group.getHello(), "hello");
        assertEquals(group.getWorld(), "world");
        PlaintextCryptoEnableGroupTest plaintext = cryptoAspectPointcutTest.groupPlaintext(group.getHello(), group.getWorld());
        assertEquals(plaintext.getHello(), "hello");
        assertEquals(plaintext.getWorld(), "world");
        log.info("group: {}", JSON.toJSONString(group));
        log.info("plaintext: {}", JSON.toJSONString(plaintext));
    }

    @Test
    void notAesAlgTest() {
        assertThrows(CryptoException.class, () -> {
            CiphertextNotAesAlgTest notAesAlg = cryptoAspectPointcutTest.notAesAlg("hello");
        });

        assertThrows(CryptoException.class, () -> {
            PlaintextNotAesAlgTest notAesAlgPlaintext = cryptoAspectPointcutTest.notAesAlgPlaintext("aoshg");
        });
    }

    @Test
    void notExistKeyGroupTest() {
        assertThrows(CryptoException.class, () -> {
            cryptoAspectPointcutTest.notExistKeyGroup("hello");
        });
        assertThrows(CryptoException.class, () -> {
            cryptoAspectPointcutTest.notExistKeyGroupPlaintext("hello");
        });
    }

    @Test
    void keyGroupTest() {
        CiphertextKeyGroupTest keyGroup = cryptoAspectPointcutTest.keyGroup("hello");
        PlaintextKeyGroupTest keyGroupPlaintext = cryptoAspectPointcutTest.keyGroupPlaintext(keyGroup.getHello());
        assertEquals(keyGroupPlaintext.getHello(), "hello");
        log.info("keyGroup: {}", JSON.toJSONString(keyGroup));
        log.info("keyGroupPlaintext: {}", JSON.toJSONString(keyGroupPlaintext));
    }

    @Test
    void urlSafelyTest() {
        CiphertextUrlSafelyTest urlSafely = cryptoAspectPointcutTest.urlSafely("hello");
        PlaintextUrlSafelyTest urlSafelyPlaintext = cryptoAspectPointcutTest.urlSafelyPlaintext(urlSafely.getHello());
        assertEquals(urlSafelyPlaintext.getHello(), "hello");
        assertFalse(urlSafelyPlaintext.getHello().contains("/"));
    }
}
