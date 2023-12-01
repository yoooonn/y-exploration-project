package top.yooonn.explore.notes.cloud.aio.client;

import com.ycourlee.tranquil.web.dto.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @author yooonn
 * @date 2022.12.12
 */
@FeignClient(value = "${foo-server.name:foo-server}", fallback = FooServerClient.FooServerClientFallback.class, decode404 = true)
public interface FooServerClient {

    @PostMapping("/hello/{greetings}")
    Response helloGreetings(@RequestBody Map<String, Object> request, @PathVariable(required = false) String greetings);

    /**
     * {@link FeignClient#fallback()}和{@link FeignClient#fallbackFactory()}
     * 必须结合hystrix({@code feign.hystrix.enabled=true})使用, 并且对应类必须在BeanFactory中
     */
    @Component
    class FooServerClientFallback implements FooServerClient {

        @Override
        public Response helloGreetings(Map<String, Object> request, String greetings) {
            return Response.success("hello");
        }
    }
}
