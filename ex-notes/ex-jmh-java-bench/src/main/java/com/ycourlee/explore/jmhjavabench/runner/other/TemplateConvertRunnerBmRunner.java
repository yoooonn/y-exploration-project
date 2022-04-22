package com.ycourlee.explore.jmhjavabench.runner.other;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ycourlee.explore.jmhjavabench.support.TemplateConverter;
import com.ycourlee.explore.springbootfreemarker.RedisStringTemplateLoader;
import com.ycourlee.tranquil.core.CommonConstants;
import com.ycourlee.tranquil.core.util.BufferedWriterWrapper;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author yongjiang
 */
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 3, time = 1)
public class TemplateConvertRunnerBmRunner extends CommonConstants {

    private static final Logger            log               = LoggerFactory.getLogger(TemplateConvertRunnerBmRunner.class);
    private static final TemplateConverter templateConverter = new TemplateConverter();

    static final RedisStringTemplateLoader redisStringTemplateLoader = new RedisStringTemplateLoader();
    static       Map<String, Object>       map                       = new HashMap<>(4);

    static {
        map.put("cityId", "231234");
        List<Map<String, Object>> mapList = new ArrayList<>(3);
        Map<String, Object> subMap;

        for (int i = 0; i < TEST_CASE_ONE_THOUSAND; i++) {
            subMap = new HashMap<>(1);
            subMap.put("bikeSn", UUID.randomUUID().toString());
            subMap.put("qrCode", UUID.randomUUID().toString());
            subMap.put("bikeFrame", UUID.randomUUID().toString());
            subMap.put("lonLat", UUID.randomUUID().toString());
            mapList.add(subMap);
        }
        map.put("gpsList", mapList);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void defineSelfConverterBenchmark() throws IOException {
        JSONObject jsonObject = JSON.parseObject("{\"params\":{\"${bikes:gpsList}\":[{\"operate\":3,\"qr_code\":\"${qrCode}\",\"location\":\"${lonLat}\",\"bike_frame\":\"${bikeFrame}\"}],\"city_id\":\"${cityId}\"}}");
        JSONObject convert = templateConverter.execConvert(JSON.parseObject(jsonObject.toJSONString()), map);
        BufferedWriterWrapper fileWriter = new BufferedWriterWrapper(TEMP_JSON_FILE_DIR + "/a.json", true);
        fileWriter.write(convert.toJSONString());
        fileWriter.save();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void freemarkerConverterBenchmark() throws IOException, TemplateException {
        Configuration config = new Configuration(Configuration.VERSION_2_3_0);
        config.setTemplateLoader(redisStringTemplateLoader);
        config.setLocalizedLookup(false);
        Template template = config.getTemplate("jy", StandardCharsets.UTF_8.name());
        String string = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
        BufferedWriterWrapper fileWriter = new BufferedWriterWrapper(TEMP_JSON_FILE_DIR + "/b.json", true);
        fileWriter.write(string);
        fileWriter.save();
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(TemplateConvertRunnerBmRunner.class.getSimpleName())
                .forks(1)
                .threads(5)
                .output(TEMP_DIR + "/a.txt")
                .build();
        new Runner(opt).run();
    }
}
