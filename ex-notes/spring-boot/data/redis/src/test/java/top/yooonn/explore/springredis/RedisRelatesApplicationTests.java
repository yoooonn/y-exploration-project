package top.yooonn.explore.springredis;

import com.ycourlee.tranquil.core.CommonConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author yooonn
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RedisRelatesApplicationTests extends CommonConstants {

    @Autowired
    protected StringRedisTemplate redisTemplate;

    @BeforeEach
    void beforeEach() {
        // String pong = redisTemplate.execute(new DefaultRedisScript<>("return redis.call('ping');", String.class), Collections.emptyList());
        // assertTrue("pong".equalsIgnoreCase(pong));
    }

    protected Object executeScriptResource(String classpathResource, Class<?> clazz, List<String> keys, Object... args) {
        ResourceScriptSource scriptSource =
                new ResourceScriptSource(
                        new EncodedResource(
                                new ClassPathResource(classpathResource),
                                StandardCharsets.UTF_8));
        String script;
        try {
            script = scriptSource.getScriptAsString();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return executeScript(script, clazz, keys, args);
    }

    protected Object executeScript(String script, Class<?> clazz, List<String> keys, Object... args) {
        RedisScript<?> redisScript = new DefaultRedisScript<>(script, clazz);
        return redisTemplate.execute(redisScript, keys, args);
    }
}
