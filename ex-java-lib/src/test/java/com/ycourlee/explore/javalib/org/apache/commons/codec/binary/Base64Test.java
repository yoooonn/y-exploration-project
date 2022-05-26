package com.ycourlee.explore.javalib.org.apache.commons.codec.binary;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yooonn
 * @date 2021.10.21
 */
public class Base64Test {

    private static final Logger log = LoggerFactory.getLogger(Base64Test.class);
    List<String> data = Lists.list("123", "abc", "https://abc.com", "汉字", "哈哈aa");

    @Test
    void getMimeDecoderTest() {
        byte[] decode = java.util.Base64.getMimeDecoder().decode("&13115611802");
        System.out.println("new String(decode) = " + new String(decode));
        byte[] decode1 = java.util.Base64.getDecoder().decode("&13115611802");
        System.out.println("decode1 = " + new String(decode1));
    }

    @Test
    void decode2Test() {
        byte[] encode = java.util.Base64.getEncoder().encode("你好&13115611802".getBytes(StandardCharsets.UTF_8));
        System.out.println("new String(decode1) = " + new String(encode));

        byte[] decode = java.util.Base64.getDecoder().decode(new String(encode));
        System.out.println("new String(decode) = " + new String(decode));

    }

    /**
     * true   123                  MTIz                 MTIz
     * true   汉字                   Pz8=                 Pz8=
     * true   abc                  YWJj                 YWJj
     * true   https://abc.com      aHR0cHM6Ly9hYmMuY29t aHR0cHM6Ly9hYmMuY29t
     * true   哈哈aa                 Pz9hYQ==             Pz9hYQ==
     * <p>
     * true   123                  123                  123
     * false  汉字                   ??                   ??
     * true   abc                  abc                  abc
     * true   https://abc.com      https://abc.com      https://abc.com
     * false  哈哈aa                 ??aa                 ??aa
     *
     * <p>
     * 有汉字不可用US_ASCII
     */
    @Test
    void encodeBase64Test() {
        Map<String, Pair<String, String>> collect = data.stream()
                .collect(Collectors.toMap(
                        s -> s,
                        s -> new ImmutablePair<>(new String(Base64.encodeBase64(s.getBytes(StandardCharsets.US_ASCII))),
                                new String(java.util.Base64.getEncoder().encode(s.getBytes(StandardCharsets.US_ASCII))))
                ));
        collect.forEach((s, value) -> log.info(String.format("%-6s %-20s %-20s %-20s",
                value.getLeft().equals(value.getRight()), s, value.getLeft(), value.getRight())));
        log.info("");
        collect.forEach((k, v) -> {
            String left = new String(Base64.decodeBase64(v.getLeft().getBytes(StandardCharsets.US_ASCII)));
            String right = new String(java.util.Base64.getDecoder().decode(v.getRight().getBytes(StandardCharsets.US_ASCII)));
            log.info(String.format("%-6s %-20s %-20s %-20s",
                    k.equals(left) && left.equals(right), k, left, right));
        });
    }

    /**
     * true   123                  MTIz                 MTIz
     * true   汉字                   5rGJ5a2X             5rGJ5a2X
     * true   abc                  YWJj                 YWJj
     * true   https://abc.com      aHR0cHM6Ly9hYmMuY29t aHR0cHM6Ly9hYmMuY29t
     * true   哈哈aa                 5ZOI5ZOIYWE=         5ZOI5ZOIYWE=
     * <p>
     * true   123                  123                  123
     * true   汉字                   汉字                   汉字
     * true   abc                  abc                  abc
     * true   https://abc.com      https://abc.com      https://abc.com
     * true   哈哈aa                 哈哈aa                 哈哈aa
     * <p>
     * 有汉字可用UTF_8
     */
    @Test
    void encodeBase64Test2() {
        Map<String, Pair<String, String>> collect = data.stream()
                .collect(Collectors.toMap(
                        s -> s,
                        s -> new ImmutablePair<>(new String(Base64.encodeBase64(s.getBytes(StandardCharsets.UTF_8))),
                                new String(java.util.Base64.getEncoder().encode(s.getBytes(StandardCharsets.UTF_8))))
                ));
        collect.forEach((s, value) -> log.info(String.format("%-6s %-20s %-20s %-20s",
                value.getLeft().equals(value.getRight()), s, value.getLeft(), value.getRight())));
        log.info("");
        collect.forEach((k, v) -> {
            String left = new String(Base64.decodeBase64(v.getLeft().getBytes(StandardCharsets.UTF_8)));
            String right = new String(java.util.Base64.getDecoder().decode(v.getRight().getBytes(StandardCharsets.UTF_8)));
            log.info(String.format("%-6s %-20s %-20s %-20s",
                    k.equals(left) && left.equals(right), k, left, right));
        });
    }

    /**
     * <p>
     * 有汉字可用UTF_8
     */
    @Test
    void encodeBase64URLSafeTest() {
        Map<String, Pair<String, String>> collect = data.stream()
                .collect(Collectors.toMap(
                        s -> s,
                        s -> new ImmutablePair<>(new String(Base64.encodeBase64URLSafe(s.getBytes(StandardCharsets.UTF_8))),
                                new String(java.util.Base64.getUrlEncoder().encode(s.getBytes(StandardCharsets.UTF_8))))
                ));
        collect.forEach((s, value) -> log.info(String.format("%-6s %-20s %-20s %-20s",
                value.getLeft().equals(value.getRight()), s, value.getLeft(), value.getRight())));
        log.info("");
        collect.forEach((k, v) -> {
            String left = new String(Base64.decodeBase64(v.getLeft().getBytes(StandardCharsets.UTF_8)));
            String right = new String(java.util.Base64.getUrlDecoder().decode(v.getRight().getBytes(StandardCharsets.UTF_8)));
            log.info(String.format("%-6s %-20s %-20s %-20s",
                    k.equals(left) && left.equals(right), k, left, right));
        });
    }

    @Test
    void urlDecoderTest() throws UnsupportedEncodingException {
        String decode = URLDecoder.decode("%E9%A9%AC%E6%A2%A6%E5%B2%A9", StandardCharsets.UTF_8.name());
        log.info("decode: {}", decode);
    }
}
