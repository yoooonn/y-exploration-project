package top.yooonn.explore.jmhjavabench.runner.java.lang;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author yooonn
 * @date 2022.04.06
 */
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
public class XorOperationBmRunner {

    static final int CASE_AMOUNT = 100;

    static final List<Integer> data = Arrays.asList(1, 2, 3, 4, 5, 6);

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(XorOperationBmRunner.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void xorBenchmark() {
        int a = 4;
        for (int i = 0; i < CASE_AMOUNT; i++) {
            if ((1 ^ 2 ^ 3 ^ 4 ^ 5 ^ a) == 0) {

            }
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void ifBenchmark() {
        for (int i = 0; i < CASE_AMOUNT; i++) {

        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void containsBenchmark() {
        for (int i = 0; i < CASE_AMOUNT; i++) {

        }
    }
}
