package com.ycourlee.explore.jmhjavabench.runner.other;

import com.ycourlee.tranquil.core.CommonConstants;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.springframework.lang.Nullable;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author yongjiang
 * @date 2021.07.19
 */
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
public class StringAppendBmRunner extends CommonConstants {

    static String s = "nihao %s %s hello";

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void t1Benchmark() {
        for (int i = 0; i < TEST_CASE_ONE_MILLION; i++) {
            String yong = format1(s, "yong");
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void t2Benchmark() {
        for (int i = 0; i < TEST_CASE_ONE_MILLION; i++) {
            String yong = format2(s, "yong");
        }
    }

    String format1(@Nullable String template, @Nullable Object... args) {
        if (Objects.isNull(template)) {
            return null;
        }
        if (args == null || args.length == 0) {
            return template;
        }
        StringBuilder builder = new StringBuilder(template.length() + 16 * args.length);
        int templateStart = 0;

        int i;
        int placeholderStart;
        for (i = 0; i < args.length; templateStart = placeholderStart + 2) {
            placeholderStart = template.indexOf("%s", templateStart);
            if (placeholderStart == -1) {
                break;
            }

            builder.append(template, templateStart, placeholderStart);
            builder.append(args[i++]);
        }

        builder.append(template.substring(templateStart));
        if (i < args.length) {
            builder.append(" [");
            builder.append(args[i++]);

            while (i < args.length) {
                builder.append(", ");
                builder.append(args[i++]);
            }

            builder.append(']');
        }

        return builder.toString();
    }


    String format2(@Nullable String template, @Nullable Object... args) {
        if (Objects.isNull(template)) {
            return null;
        }
        if (args == null || args.length == 0) {
            return template;
        }
        StringBuilder builder = new StringBuilder(template.length() + 16 * args.length);
        int templateStart = 0;

        int i;
        int placeholderStart;
        for (i = 0; i < args.length; templateStart = placeholderStart + 2) {
            placeholderStart = template.indexOf("%s", templateStart);
            if (placeholderStart == -1) {
                break;
            }

            builder.append(template, templateStart, placeholderStart);
            builder.append(args[i++]);
        }

        builder.append(template, templateStart, template.length());
        if (i < args.length) {
            builder.append(" [");
            builder.append(args[i++]);

            while (i < args.length) {
                builder.append(", ");
                builder.append(args[i++]);
            }

            builder.append(']');
        }

        return builder.toString();
    }


    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(StringAppendBmRunner.class.getSimpleName())
                .forks(1)
                .threads(6)
                .build();
        new Runner(opt).run();
    }
}
