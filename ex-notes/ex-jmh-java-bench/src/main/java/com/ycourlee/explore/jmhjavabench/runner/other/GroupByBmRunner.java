package com.ycourlee.explore.jmhjavabench.runner.other;

import com.ycourlee.tranquil.core.CommonConstants;
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
 * @date 2021.08.05
 */
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
public class GroupByBmRunner extends CommonConstants {

    static List<User> userList = new ArrayList<>(10000);

    static {
        for (int i = 0; i < 100; i++) {
            int a = 1;
            for (int j = 0; j < a; j++) {
                userList.add(new User("name" + i + j, i));
            }
        }
    }


    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void mainBenchmark() {
        Map<Integer, List<User>> collect = userList.stream().collect(Collectors.groupingBy(User::getAge));
        // System.out.println("collect = " + collect.size());
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void main2Benchmark() {
        Map<Integer, List<User>> map = new HashMap<>();
        for (User user : userList) {
            List<User> temp = map.getOrDefault(user.getAge(), new ArrayList<>());
            temp.add(user);
            map.put(user.getAge(), temp);
        }
        // System.out.println("map.size() = " + map.size());
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(GroupByBmRunner.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }

    static class User {

        private String  name;
        private Integer age;

        public User() {
        }

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
