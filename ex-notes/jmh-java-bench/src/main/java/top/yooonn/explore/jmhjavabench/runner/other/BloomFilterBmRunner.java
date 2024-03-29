package top.yooonn.explore.jmhjavabench.runner.other;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import com.ycourlee.tranquil.core.CommonConstants;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author yooonn
 */
@Warmup(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
public class BloomFilterBmRunner extends CommonConstants {

    public static final BloomFilter<String> FILTER = BloomFilter.create(Funnels.stringFunnel(StandardCharsets.UTF_8), TEST_CASE_ONE_MILLION, 0.0002f);


    static {

        System.out.println("FILTER.expectedFpp() = " + FILTER.expectedFpp());

        int cnt = 0;
        for (int i = 0; i < TEST_CASE_ONE_MILLION; i++) {
            String s = composeVal(i);
            if (!FILTER.mightContain(s)) {
                cnt++;
            }
            FILTER.put(s);
        }
        System.out.println("cnt = " + cnt);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(BloomFilterBmRunner.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }

    public static String composeVal(int i) {
        return "qwerqwer" + i + "asd";
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void mightContainBenchmark() {
        for (int i = 0; i < TEST_CASE_ONE_THOUSAND; i++) {
            if (!FILTER.mightContain(composeVal(new Random().nextInt(TEST_CASE_ONE_MILLION)))) {
                System.out.println("false = " + false);
            }
        }
    }
}
