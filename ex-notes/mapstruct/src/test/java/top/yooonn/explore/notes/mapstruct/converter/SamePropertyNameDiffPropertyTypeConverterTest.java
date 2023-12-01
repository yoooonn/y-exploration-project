package top.yooonn.explore.notes.mapstruct.converter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import top.yooonn.explore.notes.mapstruct.converter.property.SamePropertyNameDiffPropertyTypeConverter;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author yooonn
 * @date 2021.10.21
 */
public class SamePropertyNameDiffPropertyTypeConverterTest {

    private static final Logger log = LoggerFactory.getLogger(SamePropertyNameDiffPropertyTypeConverterTest.class);

    /**
     * 只有name被set
     */
    @Test
    void asUserDTOTest() {
        SamePropertyNameDiffPropertyTypeConverter.Dto dto = SamePropertyNameDiffPropertyTypeConverter.INSTANCE.asDto(SamePropertyNameDiffPropertyTypeConverter.Entity.builder()
                .name("1").datetime(new Date()).valid(true).build());
        String jsonString = JSON.toJSONString(dto);
        log.info("jsonString = {}", jsonString);
        JSONObject object = JSON.parseObject(jsonString);
        assertNotNull(dto.getName());
        assertEquals(1, object.size());
    }

    @Test
    void asUserDTO2Test() {
        SamePropertyNameDiffPropertyTypeConverter.Dto dto = SamePropertyNameDiffPropertyTypeConverter.INSTANCE.asDto2(SamePropertyNameDiffPropertyTypeConverter.Entity.builder()
                .name("1").datetime(new Date()).build());
        String jsonString = JSON.toJSONString(dto);
        JSONObject object = JSON.parseObject(jsonString);
        assertNotNull(dto.getName());
        assertNotNull(dto.getDatetimeString());
        assertEquals(2, object.size());
    }
}
