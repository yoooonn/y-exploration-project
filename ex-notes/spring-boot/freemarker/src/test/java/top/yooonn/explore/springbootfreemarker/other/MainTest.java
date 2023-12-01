package top.yooonn.explore.springbootfreemarker.other;

import com.alibaba.fastjson.JSONObject;
import top.yooonn.explore.springbootfreemarker.ApplicationTests;
import top.yooonn.explore.springbootfreemarker.RedisStringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yooonn
 */
public class MainTest extends ApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(MainTest.class);

    @Autowired
    private RedisStringTemplateLoader redisStringTemplateLoader;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    void aTest() {
        try {
            redisTemplate.opsForValue()
                    .set("jy", "{\"params\":{\"code\":\"${code}\",\"city_id\":${cityId},\"status\":1,\"bikes\":[<#list bikeList><#items as bike>{\"id\":${bike.id},\"sn\":\"${bike.id}\"}</#items></#list>]}}");
            Configuration config = new Configuration(Configuration.VERSION_2_3_0);
            config.setTemplateLoader(redisStringTemplateLoader);
            config.setLocalizedLookup(false);
            Template template = config.getTemplate("jy", StandardCharsets.UTF_8.name());

            Map<Object, Object> model = new HashMap<>();
            model.put("code", "hello");
            model.put("cityId", 123);
            List<Object> value = new ArrayList<>();
            JSONObject e = new JSONObject();
            e.put("id", 123);
            e.put("sn", "123");
            value.add(e);
            e = new JSONObject();
            e.put("id", 1234);
            e.put("sn", "1234");
            value.add(e);
            model.put("bikeList", new ArrayList<>());
            String string = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

            log.info("string = {}", string);
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }
}
