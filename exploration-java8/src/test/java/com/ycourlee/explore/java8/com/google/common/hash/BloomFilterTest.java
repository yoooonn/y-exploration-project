package com.ycourlee.explore.java8.com.google.common.hash;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

/**
 * @author yongjiang
 */
public class BloomFilterTest {

    private static final Logger log = LoggerFactory.getLogger(BloomFilterTest.class);

    public static final BloomFilter<String> FILTER = BloomFilter.create(Funnels.stringFunnel(StandardCharsets.UTF_8), 1000000, 0.03f);

    @Test
    public void aTest() {
        log.info("FILTER.mightContain(\"aaa\") = {}", FILTER.mightContain("aaa"));
        log.info("FILTER.put(\"aaa\") = {}", FILTER.put("aaa"));
    }

    @Test
    public void putTest() {
        System.out.println("FILTER.mightContain(\"a\") = " + FILTER.mightContain("a"));
        System.out.println("FILTER.put(\"a\") = " + FILTER.put("a"));
        System.out.println("FILTER.mightContain(\"a\") = " + FILTER.mightContain("a"));
        System.out.println("FILTER.put(\"a\") = " + FILTER.put("a"));
        System.out.println("FILTER.mightContain(\"a\") = " + FILTER.mightContain("a"));

    }
}
