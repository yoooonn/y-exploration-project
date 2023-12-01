package top.yooonn.explore.notes.cloud.fooserver;

import com.alibaba.nacos.api.utils.NetUtils;
import com.ycourlee.tranquil.web.dto.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author yooonn
 * @date 2022.12.12
 */
@RestController
@SpringBootApplication
public class FooServerApplication {

    private static final Logger log = LoggerFactory.getLogger(FooServerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(FooServerApplication.class, args);
    }

    @PostMapping("/hello/{greetings}")
    public Response helloGreetings(@RequestBody Map<String, Object> request,
                                   @PathVariable(required = false) String greetings) throws InterruptedException {
        log.warn("Received: {}, {}", request, greetings);
        Integer defer = (Integer) request.get("defer");
        if (defer != null) {
            Thread.sleep(defer);
        }
        return Response
                .success("Hello, happy to receive your that request!")
                .pin("my_ip", NetUtils.localIP());
    }
}
