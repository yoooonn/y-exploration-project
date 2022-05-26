package com.ycourlee.explore.notes.springredission.com.mitchellbosecke.pebble;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.template.PebbleTemplate;
import com.ycourlee.explore.notes.springredission.RedissionSpringApplicationTests;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yooonn
 * @date 2022.04.04
 */

public class PebbleEngineTests extends RedissionSpringApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(PebbleEngineTests.class);

    @Autowired
    private PebbleEngine pebbleEngine;

    @Test
    void mainTest() throws IOException {
        PebbleTemplate template = pebbleEngine.getTemplate("hello, {{cat.name}}");
        Map<String, Object> context = new HashMap<>();
        context.put("cat", new Cat().setName("nio").setColor("white"));
        context.put("hello", "world");
        Writer writer = new StringWriter();
        template.evaluate(writer, context);
        log.info("context: {}", writer);
    }

    @Setter
    @Getter
    @ToString
    @Accessors(chain = true)
    static class Cat {

        private String name;
        private String color;
    }
}
