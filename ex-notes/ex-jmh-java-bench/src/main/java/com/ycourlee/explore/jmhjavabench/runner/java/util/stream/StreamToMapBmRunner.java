package com.ycourlee.explore.jmhjavabench.runner.java.util.stream;

import com.ycourlee.explore.jmhjavabench.GlobalVariablesAndMethods;
import com.ycourlee.explore.jmhjavabench.model.User;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author yongjiang
 * @date 2021.11.01
 */
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
public class StreamToMapBmRunner extends GlobalVariablesAndMethods {

    static final int CASE_AMOUNT = 10000;

    static final List<User> data = new ArrayList<>();

    static {
        for (int i = 0; i < CASE_AMOUNT; i++) {
            data.add(new User(i, "name" + i));
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void toMapBenchmark() {
        Map<String, User> map = data.stream().collect(Collectors.toMap(e -> e.getId().toString(), e -> e));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void ordinaryBenchmark() {
        Map<String, User> tempMap = new HashMap<>();
        for (User user : data) {
            tempMap.put(user.getId().toString(), user);
        }
    }


    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(StreamToMapBmRunner.class.getSimpleName())
                .forks(1)
                .threads(50)
                .output(outputFile(StreamToMapBmRunner.class.getSimpleName(), CASE_AMOUNT))
                .build();
        new Runner(opt).run();
    }
}
