package top.yooonn.explore.jmhjavabench.runner.java.util.stream;

import top.yooonn.explore.jmhjavabench.GlobalVariablesAndMethods;
import top.yooonn.explore.jmhjavabench.model.MultiFieldEntity;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author yooonn
 * @date 2021.04.08
 */
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
public class StreamBmRunner extends GlobalVariablesAndMethods {

    static List<MultiFieldEntity> data = new ArrayList<>();

    static {
        for (int i = 0; i < TEST_CASE_TEN_THOUSAND; i++) {
            MultiFieldEntity entity = new MultiFieldEntity();
            entity.setField1(i);
            entity.setField2(i + "");
            entity.setField4(((long) i));
            data.add(entity);
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(StreamBmRunner.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void streamBenchmark() {
        List<Integer> collect = data.stream().filter(entity -> entity.getField2() != null)
                .map(MultiFieldEntity::getField1)
                .collect(Collectors.toList());
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void parallelStreamBenchmark() {
        List<Integer> collect = data.parallelStream().filter(entity -> entity.getField2() != null)
                .map(MultiFieldEntity::getField1)
                .collect(Collectors.toList());
    }
}
