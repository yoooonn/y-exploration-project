package com.ycourlee.explore.jmhjavabench.runner.org.springframework.beans;

import com.ycourlee.explore.jmhjavabench.model.MultiFieldEntity;
import com.ycourlee.root.mocks.UnitTestResource;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.springframework.beans.BeanUtils;

import java.util.concurrent.TimeUnit;

/**
 * @author yongjiang
 */
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
public class BeanUtilsBmRunner extends UnitTestResource {

    static final MultiFieldEntity entity = new MultiFieldEntity();

    static {
        entity.setField1(1024);
        entity.setField2("1024");
        entity.setField3("1024");
        entity.setField4(1024L);
        entity.setField5("1024");
        entity.setField6("1024");
        entity.setField7("1024");
        entity.setField8(1024);
        entity.setField9("1024");
        entity.setField10("1024");
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void aBenchmark() {
        for (int i = 0; i < 1; i++) {
            MultiFieldEntity temp = new MultiFieldEntity();
            temp.setField1(entity.getField1());
            temp.setField2(entity.getField2());
            temp.setField3(entity.getField3());
            temp.setField4(entity.getField4());
            temp.setField5(entity.getField5());
            temp.setField6(entity.getField6());
            temp.setField7(entity.getField7());
            temp.setField8(entity.getField8());
            temp.setField9(entity.getField9());
            temp.setField10(entity.getField10());
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void bBenchmark() {
        for (int i = 0; i < 1; i++) {
            MultiFieldEntity temp = new MultiFieldEntity();
            BeanUtils.copyProperties(entity, temp);
        }
    }

    /**
     * 10,000的测试量
     * <pre>
     * Benchmark                     Mode  Cnt     Score     Error  Units
     * BeanUtilsBmRunner.aBenchmark  avgt    5   219.461 ±   8.784  us/op
     * BeanUtilsBmRunner.bBenchmark  avgt    5  3157.425 ± 142.380  us/op
     * </pre>
     * 可以看出
     *
     * @param args
     * @throws RunnerException
     */
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(BeanUtilsBmRunner.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }
}
