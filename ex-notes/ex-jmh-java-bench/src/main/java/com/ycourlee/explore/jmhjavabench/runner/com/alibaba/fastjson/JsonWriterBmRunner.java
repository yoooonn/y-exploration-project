package com.ycourlee.explore.jmhjavabench.runner.com.alibaba.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONWriter;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author yongjiang
 * @date 2021.08.28
 */
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 8, time = 3, timeUnit = TimeUnit.SECONDS)
public class JsonWriterBmRunner {

    static final int CASE_AMOUNT = 100;

    static List<Map<String, Object>> data = new ArrayList<>();

    static long id = 123145678L;

    static int dataSize = 1000;

    static {
        for (int i = 0; i < dataSize; i++) {
            HashMap<String, Object> map = new HashMap<>();
            for (int j = 0; j < 10; j++) {
                map.put(String.valueOf(j), ThreadLocalRandom.current().nextLong());
            }
            data.add(map);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void jsonWriterBenchmark() {
        for (int i = 0; i < CASE_AMOUNT; i++) {
            StringWriter out = new StringWriter();
            JSONWriter jsonWriter = new JSONWriter(out);
            jsonWriter.startObject();
            jsonWriter.writeKey("lid");
            jsonWriter.writeValue(id);
            jsonWriter.writeKey("pools");
            jsonWriter.startArray();
            if (!data.isEmpty()) {
                data.forEach(pool -> {
                    jsonWriter.startObject();
                    jsonWriter.writeKey("id");
                    jsonWriter.writeValue(id);
                    jsonWriter.writeKey("magics");
                    jsonWriter.startObject();
                    pool.forEach((key, value) -> {
                        jsonWriter.writeKey(key);
                        jsonWriter.writeValue(value);
                    });
                    jsonWriter.endObject();
                    jsonWriter.endObject();
                });
            }
            jsonWriter.endArray();
            jsonWriter.endObject();
            try {
                jsonWriter.flush();
                jsonWriter.close();
            } catch (IOException e) {
                throw new IllegalStateException();
            }
            out.toString();
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void toJsonStringBenchmark() {
        for (int i = 0; i < CASE_AMOUNT; i++) {
            JSONObject json = new JSONObject();
            json.put("lid", id);
            JSONArray array = new JSONArray();
            data.forEach(pool->{
                JSONObject object = new JSONObject(pool);
                object.put("id", id);
                array.add(object);
            });
            json.put("pools", array);
            json.toString();
        }
    }

    private void fn() {

    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JsonWriterBmRunner.class.getSimpleName())
                .forks(1)
                .threads(3)
                .build();
        new Runner(opt).run();
    }
}
