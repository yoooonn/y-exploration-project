package top.yooonn.explore.springredis.value;

import top.yooonn.explore.springredis.RedisRelatesApplicationTests;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yooonn
 * @date 2022.04.24
 */
public class MultiGetTests extends RedisRelatesApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(MultiGetTests.class);

    @Test
    void mainTest() {
        // List<String> strings = redisTemplate.opsForValue().multiGet(Arrays.asList("hello", "world", "aowigw"));
        // log.info("strings.json: {}", JSON.toJSONString(strings));
        redisTemplate.opsForZSet().add("this:is:zset", "hello", 12);
        redisTemplate.opsForZSet().remove("this:is:zset", "hello", null);
    }
}
