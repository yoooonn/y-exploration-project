package top.yooonn.explore.notes.mapstruct;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author yooonn
 */
public abstract class AbstractTests {

    protected static void assertThatPropertyAllEqualed(Object source, Object target) {
        JSONObject sourceJson = JSON.parseObject(JSON.toJSONString(source), JSONObject.class);
        JSONObject targetJson = JSON.parseObject(JSON.toJSONString(target), JSONObject.class);
        assertEquals(sourceJson.size(), targetJson.size());
        sourceJson.forEach((k, v) -> assertEquals(targetJson.get(k), v));
    }
}
