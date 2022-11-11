package com.ycourlee.explore.notes.mapstruct.converter;

import com.alibaba.fastjson.JSON;
import com.ycourlee.explore.notes.mapstruct.AbstractTests;
import org.junit.jupiter.api.Test;

/**
 * @author yooonn
 * @date 2021.10.26
 */
public class AutomaticConversionTypeConverterTest extends AbstractTests {

    /**
     * 1 同名的属性会自动复制
     * 2 基本类型和它对应的包装类型可以自动隐式转换
     */
    @Test
    void mainTest() {
        AutomaticConversionTypeConverter.Entity entity = JSON.parseObject("{\n" +
                        "  \"aByte\": 48,\n" +
                        "  \"aChar\": \"0\",\n" +
                        "  \"aFloat\": 72.50,\n" +
                        "  \"aDouble\": 25.32,\n" +
                        "  \"anInt\": 32,\n" +
                        "  \"aLong\": 82,\n" +
                        "  \"aShort\": 96\n" +
                        "}",
                AutomaticConversionTypeConverter.Entity.class);

        AutomaticConversionTypeConverter.Dto dto = AutomaticConversionTypeConverter.INSTANCE.asDto(entity);
        assertThatPropertyAllEqualed(entity, dto);
    }
}
