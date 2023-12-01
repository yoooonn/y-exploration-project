package top.yooonn.explore.jmhjavabench.runner.other;

import com.ycourlee.tranquil.core.CommonConstants;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author yooonn
 * @date 2021.07.19
 */
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
public class RandomIntGeneratorBmRunner extends CommonConstants {


    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(RandomIntGeneratorBmRunner.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void t1Benchmark() {
        for (int i = 0; i < TEST_CASE_ONE_MILLION; i++) {
            double random = Math.random();
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void t2Benchmark() {
        Random random = new Random();
        for (int i = 0; i < TEST_CASE_ONE_MILLION; i++) {
            double i1 = random.nextDouble();
        }
    }
}
