package com.ycourlee.explore.jmhjavabench.runner.java.util;

import com.ycourlee.tranquil.core.CommonConstants;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author yongjiang
 * @date 2021.08.27
 */
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
public class RandomBmRunner extends CommonConstants {

    static int CASE_AMOUNT = TEST_CASE_ONE_HUNDRED;

    private static final Logger log = LoggerFactory.getLogger(RandomBmRunner.class);

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void randomBenchmark() {
        for (int i = 0; i < CASE_AMOUNT; i++) {
            String arg = UUID.randomUUID().toString();
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void random2Benchmark() {
        for (int i = 0; i < CASE_AMOUNT; i++) {
            String s = UUID.randomUUID().toString().replaceAll("-", "");
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void threadLocalRandomBenchmark() {
        for (int i = 0; i < CASE_AMOUNT; i++) {
            ThreadLocalRandom current = ThreadLocalRandom.current();
            String s = new UUID(current.nextLong(), current.nextLong()).toString();
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void threadLocalRandom2Benchmark() {
        for (int i = 0; i < CASE_AMOUNT; i++) {
            ThreadLocalRandom current = ThreadLocalRandom.current();
            String s = new UUID(current.nextLong(), current.nextLong()).toString().replaceAll("-", "");
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(RandomBmRunner.class.getSimpleName())
                .forks(5)
                .threads(3)
                .build();
        new Runner(opt).run();
    }
}
