package com.ycourlee.explore.java8.com.alibaba.fastjson;

import com.alibaba.fastjson.JSONWriter;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author yongjiang
 * @date 2021.08.28
 */
public class JSONWriterTest {

    static List<Map<String, Object>> data = new ArrayList<>();

    static long id = 123145678L;

    static long CASE_AMOUNT = 10000;

    static {
        for (int i = 0; i < CASE_AMOUNT; i++) {
            HashMap<String, Object> map = new HashMap<>();
            for (int j = 0; j < 10; j++) {
                map.put(String.valueOf(j), ThreadLocalRandom.current().nextLong());
            }
            data.add(map);
        }
    }


    @Test
    public void mainTest() {
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
    }
}
