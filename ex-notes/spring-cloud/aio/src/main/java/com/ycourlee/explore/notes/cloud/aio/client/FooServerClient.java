package com.ycourlee.explore.notes.cloud.aio.client;

import com.ycourlee.tranquil.web.dto.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @author yongjiang
 * @date 2022.12.12
 */
@FeignClient(value = "${foo-server.name:foo-server}", decode404 = true)
public interface FooServerClient {

    @PostMapping("/hello/{greetings}")
    Response helloGreetings(@RequestBody Map<String, Object> request, @PathVariable(required = false) String greetings);
}
