package top.yooonn.explore.notes.cloud.aio.watchpoint.impl;

import com.google.common.collect.ImmutableMap;
import top.yooonn.explore.notes.cloud.aio.client.FooServerClient;
import top.yooonn.explore.notes.cloud.aio.watchpoint.Context;
import top.yooonn.explore.notes.cloud.aio.watchpoint.WatchPoint;
import top.yooonn.explore.notes.cloud.aio.watchpoint.WatchPointChain;
import com.ycourlee.tranquil.web.dto.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

/**
 * @author yooonn
 * @date 2023.01.28
 */
@Component
@RequiredArgsConstructor
public class SpringRetryWatchPoint implements WatchPoint {

    private final FooServiceClientManager fooServiceClientManager;

    @Override
    public void doExecute(Response response, Context context, WatchPointChain chain) {
        fooServiceClientManager.helloGreetings("hello foo");
        chain.doExecute(response, context);
    }

    @Component
    @RequiredArgsConstructor
    public static class FooServiceClientManager {

        private final FooServerClient fooServerClient;

        @Retryable(backoff = @Backoff(delay = 2, multiplier = 2))
        public void helloGreetings(String greeting) {
            fooServerClient.helloGreetings(ImmutableMap.of("defer", 20000), greeting);
        }
    }

    @Configuration(proxyBeanMethods = false)
    @EnableRetry(proxyTargetClass = false)
    public static class EnableRetryConf {
    }
}
