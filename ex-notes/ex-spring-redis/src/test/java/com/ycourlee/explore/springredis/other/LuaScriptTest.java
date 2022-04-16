package com.ycourlee.explore.springredis.other;

import com.ycourlee.explore.springredis.SpringTestEnv;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.scripting.support.ResourceScriptSource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author yongjiang
 * @date 2022.02.07
 */
public class LuaScriptTest extends SpringTestEnv {

    private static final Logger log = LoggerFactory.getLogger(LuaScriptTest.class);

    @Test
    void main3Test() throws IOException {
        ResourceScriptSource source = new ResourceScriptSource(new EncodedResource(new ClassPathResource("lua/zPopMin.lua"), StandardCharsets.UTF_8));
        Object s = executeScript(source.getScriptAsString(),String.class, Arrays.asList("hello"));
        log.info("s: {}", s);
    }

    @Test
    void mainTest() {
        String result = "";
        log.info("result: {}", result);
    }

    @Test
    void main2Test() {

        Object[] args = new Object[2];
        args[0] = String.valueOf(1);
        args[1] = String.valueOf(4);

        Object script = executeScript("local score = redis.call('zScore', KEYS[2], KEYS[1]); local retCode = 0;if score + ARGV[1] < 0 then retCode = -1 else retCode = " +
                        "redis.call('zIncrBy', KEYS[2], ARGV[1], KEYS[1]) end;redis.call('zIncrBy', KEYS[3], ARGV[2], KEYS[1]);redis.cal" +
                        "l('zIncrBy', KEYS[4], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[5], ARGV[2], KEYS[1]);redis.call('zIncrBy'," +
                        " KEYS[6], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[7], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[8], ARGV" +
                        "[2], KEYS[1]);redis.call('zIncrBy', KEYS[9], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[10], ARGV[2], KEYS[1]);" +
                        "redis.call('zIncrBy', KEYS[11], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[12], ARGV[2], KEYS[1]);redis.call('z" +
                        "IncrBy', KEYS[13], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[14], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS" +
                        "[15], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[16], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[17], ARGV[2]" +
                        ", KEYS[1]);redis.call('zIncrBy', KEYS[18], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[19], ARGV[2], KEYS[1]);re" +
                        "dis.call('zIncrBy', KEYS[20], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[21], ARGV[2], KEYS[1]);redis.call('zIncr" +
                        "By', KEYS[22], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[23], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[24], " +
                        "ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[25], ARGV[2], KEYS[1]);redis.call('zIncrBy', KEYS[26], ARGV[2], KEYS[1]" +
                        ");return retCode;",
                String.class,
                Arrays.asList(("1001394 iscar:stock:online:88:132:20220216:18.00~19.00 iscar:stock:online:132:88:20220216:17.00~18.00 " +
                        "iscar:stock:online:132:88:20220216:18.00~19.00 iscar:stock:online:132:88:20220216:19.00~20.00 iscar:stock:onli" +
                        "ne:88:320:20220216:17.00~18.00 iscar:stock:online:88:320:20220216:16.00~17.00 iscar:stock:online:88:320:202202" +
                        "16:15.00~16.00 iscar:stock:online:88:320:20220216:18.00~19.00 iscar:stock:online:88:320:20220216:19.00~20.00 i" +
                        "scar:stock:online:88:320:20220216:20.00~21.00 iscar:stock:online:320:88:20220216:17.00~18.00 iscar:stock:onlin" +
                        "e:320:88:20220216:16.00~17.00 iscar:stock:online:320:88:20220216:17.00~18.00 iscar:stock:online:320:88:20220216:16" +
                        ".00~17.00 iscar:stock:online:320:88:20220216:15.00~16.00 iscar:stock:online:320:88:20220216:18.00~19.00 iscar:stoc" +
                        "k:online:320:88:20220216:19.00~20.00 iscar:stock:online:320:88:20220216:20.00~21.00 iscar:stock:online:320:88:2022" +
                        "0216:19.00~20.00 iscar:stock:online:320:88:20220216:20.00~21.00 iscar:stock:online:88:132:20220216:17.00~18.00 isc" +
                        "ar:stock:online:88:132:20220216:16.00~17.00 iscar:stock:online:88:132:20220216:15.00~16.00 iscar:stock:online:88:1" +
                        "32:20220216:19.00~20.00 iscar:stock:online:88:132:20220216:20.00~21.00").split(" ")),
                args);
        log.info("script.getClass(): {}", script.getClass());
        log.info("script: {}", script);
    }
}
