package com.ycourlee.explore.jmhjavabench.runner.other;

import com.ycourlee.explore.jmhjavabench.GlobalVariablesAndMethods;
import com.ycourlee.explore.jmhjavabench.model.RtmWrapper;
import com.ycourlee.explore.jmhjavabench.model.User;
import com.ycourlee.root.core.domain.context.Rtm;
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
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
public class InvokeDeepMethodBmRunner extends GlobalVariablesAndMethods {

    static final User USER;

    static {
        USER = new User();
        USER.setId(123);
        USER.setName("hello");
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void codeMsgDataLinkInvokeBenchmark() {
        for (int i = 0; i < TEST_CASE_ONE_THOUSAND; i++) {
            Rtm.blanker().code(1).msg("成功").data(USER);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void successInvokeBenchmark() {
        for (int i = 0; i < TEST_CASE_ONE_THOUSAND; i++) {
            Rtm.success(1, "成功", USER);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void putInvokeBenchmark() {
        for (int i = 0; i < TEST_CASE_ONE_THOUSAND; i++) {
            Rtm rtm = Rtm.blanker();
            rtm.pin("code", 1);
            rtm.pin("msg", "成功");
            rtm.pin("data", USER);
        }
    }


    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void codeMsgDataLinkInvokeBenchmark2() {
        for (int i = 0; i < TEST_CASE_ONE_THOUSAND; i++) {
            RtmWrapper.blanker().code(1).msg("成功").data(USER);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void successInvokeBenchmark2() {
        for (int i = 0; i < TEST_CASE_ONE_THOUSAND; i++) {
            RtmWrapper.success(1, "成功", USER);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void putInvokeBenchmark2() {
        for (int i = 0; i < TEST_CASE_ONE_THOUSAND; i++) {
            RtmWrapper rtm = RtmWrapper.blanker();
            rtm.pin("code", 1);
            rtm.pin("msg", "成功");
            rtm.pin("data", USER);
        }
    }

    /**
     * Benchmark                                                Mode  Cnt   Score   Error  Units
     * DeepInvokeMethodBmRunner.codeMsgDataLinkInvokeBenchmark  avgt    5  36.257 ± 0.293  us/op
     * DeepInvokeMethodBmRunner.putInvokeBenchmark              avgt    5  36.678 ± 0.542  us/op
     * DeepInvokeMethodBmRunner.successInvokeBenchmark          avgt    5  46.505 ± 2.716  us/op
     *
     * @param args args
     * @throws RunnerException exception.
     */
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(InvokeDeepMethodBmRunner.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }
}