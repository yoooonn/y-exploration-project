package com.ycourlee.explore.notes.elk.service;

import com.ycourlee.explore.notes.elk.ElkApplicationTests;
import org.elasticsearch.cluster.metadata.MappingMetaData;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author yongjiang
 * @date 2022.03.04
 */
@SuppressWarnings("ConstantConditions")
public class EsIndexOperationTests extends ElkApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(EsIndexOperationTests.class);

    private static final String SAMPLE_INDEX = "kibana_sample_data_ecommerce";

    @Autowired
    private EsIndexOperation esIndexOperation;

    @Test
    void getMappingTest() {
        Map<String, MappingMetaData> mapping = esIndexOperation.getMapping(SAMPLE_INDEX);
        assertNotNull(mapping);
        MappingMetaData mappingMetaData = mapping.get(SAMPLE_INDEX);
        Map<String, Object> sourceAsMap = mappingMetaData.getSourceAsMap();
        Object properties = sourceAsMap.get("properties");
        log.info("properties.getClass(): {}", properties.getClass());
        sourceAsMap.forEach((key, value) -> log.info("{}: {}", key, value));
    }

    @Test
    void existTest() {
        boolean exist = esIndexOperation.exist("hello-test");
        assertFalse(exist);
        boolean exist1 = esIndexOperation.exist("kibana_sample_data_ecommerce");
        assertTrue(exist1);
    }

    @Test
    void mainTest() {
        boolean create = esIndexOperation.create("hello-test", Collections.emptyMap());
        if (!create) {
            log.info("create: {}", "failed");
        }

    }
}
