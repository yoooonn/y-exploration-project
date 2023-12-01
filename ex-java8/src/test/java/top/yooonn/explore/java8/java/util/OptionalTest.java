package top.yooonn.explore.java8.java.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import top.yooonn.explore.java8.AbstractTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @author yooonn
 * @date 2022.01.20
 */
public class OptionalTest extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(OptionalTest.class);

    @Test
    public void mapTest() {
        log.info("{}", Optional.of("String").map(s -> s + "haha").orElse(null));

        log.info("{}", Optional.ofNullable(getNull()).map(s -> s + "haha").orElse("haha"));

        Optional<String> world = Optional.of(getValue()).flatMap(s -> Optional.of("world"));

    }

    @Test
    public void main2Test() {
        Optional<String> value = Optional.ofNullable(getNull());
        log.info("value.get(): {}", value.get());
        String s = value.orElse("Hello");
        log.info("s: {}", s);
    }

    private String getValue() {
        return "hello";
    }

    private String getNull() {
        return null;
    }

    @Test
    public void mainTest() {
        Set<String> data = mockData();
        Optional<String> first = data.stream().findFirst();
        JSONObject json = first.map(s -> JSON.parseObject(s, JSONObject.class)).orElse(null);

        // noinspection ConstantConditions
        log.info("json.get(\"hello\"): {}", json.get("hello"));


    }


    private Set<String> mockData() {
        Set<String> set = new LinkedHashSet<>();
        set.add("{\"hello\":123}");
        set.add("20");
        set.add("21");
        set.add("22");
        set.add("23");
        set.add("24");
        set.add("25");
        set.add("26");
        set.add("27");
        set.add("28");
        set.add("29");
        set.add("30");
        set.add("31");
        set.add("32");
        set.add("33");
        set.add("34");
        set.add("35");
        set.add("36");
        return set;
    }
}
