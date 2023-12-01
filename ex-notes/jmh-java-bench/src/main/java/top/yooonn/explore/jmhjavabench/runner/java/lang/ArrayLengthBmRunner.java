package top.yooonn.explore.jmhjavabench.runner.java.lang;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author yooonn
 * @date 2022.08.23
 */
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
public class ArrayLengthBmRunner {

    static final int[] data = new int[10000];

    static {
        for (int i = 0; i < 10000; i++) {
            data[i] = i;
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void byVarBenchmark() {
        int length = data.length;
        for (int i = 0; i < 100000; i++) {
            int t = length - 1;
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void directAccessBenchmark() {
        for (int i = 0; i < 100000; i++) {
            int t = data.length - 1;
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(ArrayLengthBmRunner.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }
}
