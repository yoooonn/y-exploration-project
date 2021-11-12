package com.ycourlee.explore.jmhjavabench.runner.java.util;

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

/**
 * @author yongjiang
 * @date 2021.03.24
 */
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
public class HashMapPutMethodBmRunner {

    static List<User> demoList;

    static {
        demoList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            demoList.add(new User(i, "test"));
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void testHashMapWithoutSize() {
        Map<Integer, String> testMap = new HashMap<>();
        for (User demo : demoList) {
            testMap.put(demo.getId(), demo.getName());
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void testHashMap() {
        Map<Integer, String> testMap = new HashMap<>((int) (demoList.size() / 0.75F + 1));
        for (User demo : demoList) {
            testMap.put(demo.getId(), demo.getName());
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(HashMapPutMethodBmRunner.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }
}
