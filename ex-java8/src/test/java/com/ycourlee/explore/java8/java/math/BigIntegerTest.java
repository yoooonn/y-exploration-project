package com.ycourlee.explore.java8.java.math;

import org.apache.commons.codec.binary.Hex;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author yooonn
 * @date 2021.07.06
 */
public class BigIntegerTest {

    private static final Logger log = LoggerFactory.getLogger(BigIntegerTest.class);

    @Test
    public void newTest() throws NoSuchAlgorithmException {
        byte[] md5 = MessageDigest.getInstance("MD5").digest("hello, world".getBytes(StandardCharsets.UTF_8));

        log.info("Hex.encodeHex(md5) = {}", new String(Hex.encodeHex(md5)));

        String md5Str = new BigInteger(1, md5).toString(16);
        log.info("md5Str =             {}", md5Str);
    }
}
