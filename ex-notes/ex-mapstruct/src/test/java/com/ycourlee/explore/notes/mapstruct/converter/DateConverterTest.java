package com.ycourlee.explore.notes.mapstruct.converter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ycourlee.explore.notes.mapstruct.converter.date.DateConverter;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author yongjiang
 * @date 2021.10.21
 */
public class DateConverterTest {

    private static final Logger log = LoggerFactory.getLogger(DateConverterTest.class);

    @Test
    void asDtoTest() {
        DateConverter.Dto dto = DateConverter.INSTANCE.asDto(DateConverter.Entity.builder()
                .date(new Date())
                .build());
        String s = JSON.toJSONString(dto);
        log.info("JSON.toJSONString(dtoA) = {}", s);
        JSONObject object = JSON.parseObject(s);
        assertEquals(1, object.size());
    }
}
