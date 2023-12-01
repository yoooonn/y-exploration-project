package top.yooonn.explore.java8.com.alibaba.fastjson;

import com.alibaba.fastjson.JSON;
import top.yooonn.explore.java8.AbstractTest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author yooonn
 * @date 2022.02.15
 */
public class JSONTest extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(JSONTest.class);

    @Test
    public void mainTest() {
        A a = JSON.parseObject("{}", A.class);
        logMethod(a);
        log.info("a: {}", a);
    }

    private void logMethod(B b) {
        log.info("b.json: {}", JSON.toJSONString(b));
    }


    @Setter
    @Getter
    @ToString
    static class B {

        private Long baseId = 0L;
    }

    @Setter
    @Getter
    @ToString
    static class A extends B {

        private Long id;

        private String name = "empty";

        private List<Object> list;

        private Set<Object> set = new HashSet<>();
    }
}
