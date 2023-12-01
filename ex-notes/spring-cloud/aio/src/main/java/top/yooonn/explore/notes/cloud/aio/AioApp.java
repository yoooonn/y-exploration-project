package top.yooonn.explore.notes.cloud.aio;

import com.alibaba.fastjson.JSONObject;
import top.yooonn.explore.notes.cloud.aio.watchpoint.Context;
import top.yooonn.explore.notes.cloud.aio.watchpoint.WatchPointChain;
import com.ycourlee.tranquil.web.dto.Response;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yooonn
 * @date 2022.11.15
 */
@SpringBootApplication
@EnableFeignClients(basePackages = {"top.yooonn.explore.notes.cloud.aio.client"})
@RequiredArgsConstructor
public class AioApp implements ApplicationContextAware {

    private static final Logger log = LoggerFactory.getLogger(AioApp.class);

    private static ApplicationContext applicationContext;

    public static void main(String[] args) {
        // args = new String[]{
        //         "--spring.cloud.nacos.config.enabled=false",
        //         "--spring.cloud.nacos.discovery.enabled=false",
        // };
        SpringApplication.run(AioApp.class, args);
    }

    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
        AioApp.applicationContext = applicationContext;
    }

    @RestController
    @RequiredArgsConstructor
    static class Controller {

        private final WatchPointChain watchPointChain;

        @PostMapping("/watch")
        public Response watch(@Validated @RequestBody(required = false) JSONObject param, HttpServletRequest request, HttpServletResponse response) {
            Response r = Response.success();
            watchPointChain.doExecute(r, new Context().setRequest(param).setServletRequest(request).setServletResponse(response));
            return r;
        }

        @PostMapping("/ping")
        public Response ping(@RequestBody(required = false) JSONObject param) {
            return Response.success().pin("request content", param);
        }
    }
}
