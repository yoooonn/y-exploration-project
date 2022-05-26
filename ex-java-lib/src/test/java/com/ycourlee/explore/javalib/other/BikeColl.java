package com.ycourlee.explore.javalib.other;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ycourlee.explore.javalib.AbstractTest;
import com.ycourlee.explore.javalib.util.FileUtil;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yooonn
 * @date 2022.01.05
 */
public class BikeColl extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(BikeColl.class);

    @Test
    void mainTest() {
        JSONObject object = FileUtil.readJson(TEMP_JSON_FILE_DIR + "/bike.json");
        JSONArray data = object.getJSONArray("data");
        Map<Long, Long> cityIdMap = new HashMap<>();
        for (int i = 0; i < data.size(); i++) {
            Long cityId = data.getJSONObject(i).getLong("city_id");
            Long cnt = data.getJSONObject(i).getLong("cnt");
            cityIdMap.put(cityId, cnt);
        }

        cityIdMap.entrySet()
                .stream()
                .collect(Collectors.groupingBy(e -> groupJudge(e.getKey())))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue()
                        .stream()
                        .map(Map.Entry::getValue)
                        .collect(Collectors.toList())
                        .stream()
                        .mapToLong(value -> value).sum(), Long::sum))
                .forEach((key, value1) -> log.info("{}", key + ": " + value1));
    }

    public String groupJudge(Long cityId) {
        // if (cityId == 326) {
        //     return
        // }
        String group = "0";
        if (cityId <= 200) {
            group = "(0, 200]";
        } else if (cityId <= 400) {
            group = "(200, 400]";
        } else if (cityId <= 600) {
            group = "(400, 600]";
        } else if (cityId <= 750) {
            group = "(600, 750]";
        }
        return group;
    }
}
