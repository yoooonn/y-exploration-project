package com.ycourlee.explore.jmhjavabench.runner.other;

import com.ycourlee.explore.jmhjavabench.GlobalVariablesAndMethods;
import com.ycourlee.explore.jmhjavabench.model.RtmWrapper;
import com.ycourlee.explore.jmhjavabench.model.User;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author yongjiang
 * @date 2021.03.31
 */
@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 30, time = 1, timeUnit = TimeUnit.SECONDS)
public class InvokeDirectlyMethodBmRunner extends GlobalVariablesAndMethods {

    static final User USER;

    static final int TEST_CASE_ONE_THOUSAND = 1_000;

    static {
        USER = new User();
        USER.setId(123);
        USER.setName("hello");
    }

    /**
     * Benchmark                                                    Mode  Cnt   Score   Error  Units
     * InvokeDirectlyMethodBmRunner.codeMsgDataLinkInvokeBenchmark  avgt    5  37.633 ± 4.105  us/op
     * InvokeDirectlyMethodBmRunner.putInvokeBenchmark              avgt    5  38.523 ± 7.181  us/op
     * InvokeDirectlyMethodBmRunner.successInvokeBenchmark          avgt    5  31.499 ± 8.235  us/op
     *
     * @param args args
     * @throws RunnerException exception.
     */
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(InvokeDirectlyMethodBmRunner.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void codeMsgDataLinkInvokeBenchmark() {
        for (int i = 0; i < TEST_CASE_ONE_THOUSAND; i++) {
            RtmWrapper.blanker().code(1).msg("成功").data(USER);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void successInvokeBenchmark() {
        for (int i = 0; i < TEST_CASE_ONE_THOUSAND; i++) {
            RtmWrapper.success(1, "成功", USER);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void putInvokeBenchmark() {
        for (int i = 0; i < TEST_CASE_ONE_THOUSAND; i++) {
            RtmWrapper Response = RtmWrapper.blanker();
            Response.pin("code", 1);
            Response.pin("msg", "成功");
            Response.pin("data", USER);
        }
    }
}
