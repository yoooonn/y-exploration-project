package top.yooonn.explore.notes.fooapp;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

/**
 * @author yooonn
 */
@RestController
@SpringBootApplication
public class FooApplication {

    private static final Logger log = LoggerFactory.getLogger(FooApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(FooApplication.class, args);
    }

    @GetMapping("/foo/{message}")
    public JSONObject foo(@PathVariable(required = false) String message) {
        log.info("'/foo/{message}' invoked. message: {}", message);
        return new JSONObject(Collections.singletonMap("data", message));
    }

    @GetMapping("/ping")
    public JSONObject ping() {
        log.info("'/ping' invoked.");
        return new JSONObject(Collections.singletonMap("data", "pong"));
    }
}
