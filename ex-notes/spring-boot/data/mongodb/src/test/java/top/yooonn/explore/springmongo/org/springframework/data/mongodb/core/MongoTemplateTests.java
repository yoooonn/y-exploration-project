package top.yooonn.explore.springmongo.org.springframework.data.mongodb.core;

import top.yooonn.explore.springmongo.MongoRelatesApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author yooonn
 * @date 2022.10.25
 */
public class MongoTemplateTests extends MongoRelatesApplicationTests {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void mainTest() {
        List<Object> data = mongoTemplate.find(Query.query(Criteria.where("1").is("1")), Object.class);
        assertThat(data).isNotEmpty();
    }
}
