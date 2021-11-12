package com.ycourlee.explore.jmhjavabench.runner.other;

import com.esotericsoftware.reflectasm.MethodAccess;
import com.ycourlee.root.mocks.UnitTestResource;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author yongjiang
 * @date 2021.07.29
 */
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 50, time = 1, timeUnit = TimeUnit.SECONDS)
public class ReflectionEfficiencyBmRunner extends UnitTestResource {

    static SampleDecorator sampleDecorator = new SampleDecorator();

    static MethodAccess methodAccess = MethodAccess.get(SampleDecorator.class);


    static Map<String, Method> methodMap = new HashMap<>();

    static Map<String, Object> map  = new HashMap<>();
    static Map<String, Object> map2 = new HashMap<>();
    static Map<String, Object> map3 = new HashMap<>();

    static {
        map.put("aa", "unknown");
        map2.put("aa", "unknown");
        map3.put("aa", "unknown");
        methodAccess.getIndex("fill", Map.class);

        try {
            methodMap.put("fill", sampleDecorator.getClass().getMethod("fill", Map.class));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void ordinaryBenchmark() {

        // for (int i = 0; i < TEST_CASE_ONE_THOUSAND; i++) {
            sampleDecorator.fill(map);

        // }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void reflectionBenchmark() {
        // for (int i = 0; i < TEST_CASE_ONE_THOUSAND; i++) {
            Method fill = methodMap.get("fill");
            try {
                fill.invoke(sampleDecorator, map2);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        // }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void asmBenchmark() {
        // for (int i = 0; i < TEST_CASE_ONE_THOUSAND; i++) {
            methodAccess.invoke(sampleDecorator, "fill", map3);
        // }
    }


    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(ReflectionEfficiencyBmRunner.class.getSimpleName())
                .forks(1)
                .threads(3)
                .build();
        new Runner(opt).run();
    }

    static class SampleDecorator {

        public void fill(Map<String, Object> map) {
            map.put("hello", 123);
            map.put("world", "world");
        }
    }
}
