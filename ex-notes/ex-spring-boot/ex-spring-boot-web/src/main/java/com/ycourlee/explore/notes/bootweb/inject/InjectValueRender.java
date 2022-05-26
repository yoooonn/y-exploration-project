package com.ycourlee.explore.notes.bootweb.inject;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.ycourlee.explore.notes.bootweb.model.bo.CatBO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yooonn
 * @date 2022.01.11
 */
@Component
public class InjectValueRender {

    private static final Logger log = LoggerFactory.getLogger(InjectValueRender.class);

    @Autowired
    private ValueViewer valueViewer;

    public String setList(String listString) {
        log.info("old.list.json: {}", JSON.toJSONString(valueViewer.getList()));
        valueViewer.setList(Arrays.stream(listString.split(",")).map(Long::parseLong).collect(Collectors.toList()));
        log.info("new.list.json: {}", JSON.toJSONString(valueViewer.getList()));
        return listString;
    }

    public String setCat(String catConfig) {
        List<CatBO> catBOS = JSON.parseObject(catConfig, new TypeReference<List<CatBO>>() {});
        valueViewer.setCat(catBOS.isEmpty() ? null : catBOS.get(0));
        return catConfig;
    }
}
