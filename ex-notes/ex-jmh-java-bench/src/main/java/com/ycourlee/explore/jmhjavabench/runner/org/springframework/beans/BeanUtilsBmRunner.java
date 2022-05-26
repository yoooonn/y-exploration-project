package com.ycourlee.explore.jmhjavabench.runner.org.springframework.beans;

import com.ycourlee.explore.jmhjavabench.GlobalVariablesAndMethods;
import com.ycourlee.explore.jmhjavabench.model.MultiFieldEntity;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author yooonn
 */
@Warmup(iterations = 50, time = 1, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 500, time = 1, timeUnit = TimeUnit.MILLISECONDS)
public class BeanUtilsBmRunner extends GlobalVariablesAndMethods {

    static final List<MultiFieldEntity> data = new ArrayList<>();

    static final int CASE = 100;

    static {
        for (int i = 0; i < CASE; i++) {
            MultiFieldEntity entity = new MultiFieldEntity();
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
            data.add(entity);
        }
    }

    /**
     * @param args
     * @throws RunnerException
     */
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(BeanUtilsBmRunner.class.getSimpleName())
                .forks(1)
                .threads(10)
                .syncIterations(false)
                .output(outputFile(BeanUtilsBmRunner.class.getSimpleName(), CASE, 10))
                .build();
        new Runner(opt).run();
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void setterBenchmark() {
        for (int i = 0; i < data.size(); i++) {
            MultiFieldEntity temp = new MultiFieldEntity();
            temp.setField1(data.get(i).getField1());
            temp.setField2(data.get(i).getField2());
            temp.setField3(data.get(i).getField3());
            temp.setField4(data.get(i).getField4());
            temp.setField5(data.get(i).getField5());
            temp.setField6(data.get(i).getField6());
            temp.setField7(data.get(i).getField7());
            temp.setField8(data.get(i).getField8());
            temp.setField9(data.get(i).getField9());
            temp.setField10(data.get(i).getField10());
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void copyPropertiesBenchmark() {
        for (int i = 0; i < data.size(); i++) {
            MultiFieldEntity temp = new MultiFieldEntity();
            BeanUtils.copyProperties(data.get(i), temp);
        }
    }
}
