package com.ycourlee.explore.jmhjavabench.runner.java.util.stream;

import com.ycourlee.tranquil.core.CommonConstants;
import lombok.*;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author yongjiang
 * @date 2021.08.09
 */
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
public class StreamForeachBmRunner extends CommonConstants {

    static final List<Flag> flags = new ArrayList<>();

    static {
        for (int i = 0; i < TEST_CASE_TEN; i++) {
            flags.add(new Flag("data" + i, i + "name"));
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(StreamForeachBmRunner.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void streamBenchmark() {
        Flag flag = new Flag();
        flags.forEach(e -> {
            flag.setData(e.getData());
            flag.setName(e.getName());
        });
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void forBenchmark() {
        Flag flag = new Flag();
        for (Flag e : flags) {
            flag.setData(e.getData());
            flag.setName(e.getName());
        }
    }

    @Setter
    @Getter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    static class Flag {

        private String data;

        private String name;
    }
}
