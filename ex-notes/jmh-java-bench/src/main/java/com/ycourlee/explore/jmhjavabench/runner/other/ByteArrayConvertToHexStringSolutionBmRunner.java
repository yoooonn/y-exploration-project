package com.ycourlee.explore.jmhjavabench.runner.other;

import com.ycourlee.tranquil.core.CommonConstants;
import org.apache.commons.codec.binary.Hex;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

/**
 * 将字节数组转化为16进制的实现方式效率比较.
 * <p>
 * Benchmark                                                          Mode  Cnt     Score      Error  Units
 * ByteArrayConvertToHexStringSolutionBmRunner.byBigIntegerBenchmark  avgt    5  7425.263 ± 1444.034  us/op
 * ByteArrayConvertToHexStringSolutionBmRunner.md5AndHexBenchmark     avgt    5  6605.760 ±  493.537  us/op
 * </p>
 *
 * @author yooonn
 * @date 2021.07.06
 */
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
public class ByteArrayConvertToHexStringSolutionBmRunner extends CommonConstants {

    private static final Logger log = LoggerFactory.getLogger(ByteArrayConvertToHexStringSolutionBmRunner.class);

    private static byte[] base = null;

    static {
        try {
            base = MessageDigest.getInstance("MD5").digest("hello, world".getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(ByteArrayConvertToHexStringSolutionBmRunner.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void md5AndHexBenchmark() {
        for (int i = 0; i < TEST_CASE_ONE_THOUSAND; i++) {
            log.info("Hex.encodeHex(md5) = {}", new String(Hex.encodeHex(base)));
        }

    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void byBigIntegerBenchmark() {
        for (int i = 0; i < TEST_CASE_ONE_THOUSAND; i++) {
            log.info("md5Str =             {}", new BigInteger(1, base).toString(16));
        }
    }
}
