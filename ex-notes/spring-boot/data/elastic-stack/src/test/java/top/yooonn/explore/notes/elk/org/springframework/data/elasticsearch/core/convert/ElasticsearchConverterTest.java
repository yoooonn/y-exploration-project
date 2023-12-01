package top.yooonn.explore.notes.elk.org.springframework.data.elasticsearch.core.convert;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import top.yooonn.explore.notes.elk.ElkApplicationTests;
import top.yooonn.explore.notes.elk.entity.EcommerceOrderEntity;
import top.yooonn.explore.notes.elk.model.Cat;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.convert.ElasticsearchConverter;
import org.springframework.data.elasticsearch.core.document.Document;
import org.springframework.data.elasticsearch.core.index.MappingBuilder;
import org.springframework.data.elasticsearch.core.mapping.SimpleElasticsearchMappingContext;

/**
 * @author yooonn
 * @date 2022.03.10
 */
public class ElasticsearchConverterTest extends ElkApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(ElasticsearchConverterTest.class);

    @Autowired
    private ElasticsearchConverter converter;

    @Autowired
    private SimpleElasticsearchMappingContext mappingContext;

    @Test
    void mainTest() {
        MappingBuilder mappingBuilder = new MappingBuilder(converter);
        String mapping = mappingBuilder.buildPropertyMapping(EcommerceOrderEntity.class);

        JSONObject object = JSON.parseObject(mapping);
        String jsonString = JSON.toJSONString(object, SerializerFeature.PrettyFormat);

        log.info("jsonString: {}", jsonString);
    }

    @Test
    void mapObjectTest() {
        Document hello = converter.mapObject(new Cat().setId(12).setName("hello"));
        String json = hello.toJson();
        log.info("json: {}", json);
    }
}
