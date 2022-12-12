package com.ycourlee.explore.notes.cloud.aio;

import com.alibaba.fastjson.JSONObject;
import com.ycourlee.explore.notes.cloud.aio.watchpoint.Context;
import com.ycourlee.explore.notes.cloud.aio.watchpoint.WatchPointChain;
import com.ycourlee.tranquil.web.dto.Response;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yongjiang
 * @date 2022.11.15
 */
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.ycourlee.explore.notes.cloud.aio.client"})
public class AioApp {

    private static final Logger log = LoggerFactory.getLogger(AioApp.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AioApp.class, args);
        // while (context != null) {
        //     Arrays.stream(context.getBeanDefinitionNames()).sorted()
        //             .forEach(log::debug);
        //     context = ((ConfigurableApplicationContext) context.getParent());
        // }
    }

    @RestController
    @RequiredArgsConstructor
    static class Controller {

        private final WatchPointChain watchPointChain;

        @PostMapping("/watch")
        public Response watch(@RequestBody(required = false) JSONObject param, HttpServletRequest request, HttpServletResponse response) {
            Response r = Response.success();
            watchPointChain.doExecute(r, new Context().setRequest(param).setServletRequest(request).setServletResponse(response));
            return r;
        }
    }
}
