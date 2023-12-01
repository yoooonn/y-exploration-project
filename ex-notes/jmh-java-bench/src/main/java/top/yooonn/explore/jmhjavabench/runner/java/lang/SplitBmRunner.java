package top.yooonn.explore.jmhjavabench.runner.java.lang;

import top.yooonn.explore.jmhjavabench.GlobalVariablesAndMethods;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yooonn
 * @date 2021.11.12
 */
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
public class SplitBmRunner extends GlobalVariablesAndMethods {

    static final int CASE_AMOUNT = 100;

    static final String data = "Iamfine";

    static final Pattern regex = Pattern.compile("a");

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SplitBmRunner.class.getSimpleName())
                .output(outputFile(SplitBmRunner.class.getSimpleName(), CASE_AMOUNT))
                .forks(1)
                .build();
        new Runner(opt).run();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void stringSplitBenchmark() {
        for (int i = 0; i < CASE_AMOUNT; i++) {
            String[] as = data.split("a");
            Arrays.stream(as).forEach(t -> {});
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void regexSplitBenchmark() {

        for (int i = 0; i < CASE_AMOUNT; i++) {
            Matcher matcher = regex.matcher(data);
            for (int i1 = 0; i1 < matcher.groupCount(); i1++) {
                matcher.group(i1);
            }
        }
    }
}
