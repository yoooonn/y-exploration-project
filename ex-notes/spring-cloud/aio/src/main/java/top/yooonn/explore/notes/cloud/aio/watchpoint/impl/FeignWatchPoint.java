package top.yooonn.explore.notes.cloud.aio.watchpoint.impl;

import top.yooonn.explore.notes.cloud.aio.client.FooServerClient;
import top.yooonn.explore.notes.cloud.aio.watchpoint.Context;
import top.yooonn.explore.notes.cloud.aio.watchpoint.WatchPoint;
import top.yooonn.explore.notes.cloud.aio.watchpoint.WatchPointChain;
import com.ycourlee.tranquil.web.dto.Response;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yooonn
 * @date 2022.12.13
 */
@Component
@RequiredArgsConstructor
public class FeignWatchPoint implements WatchPoint {

    private static final Logger          log = LoggerFactory.getLogger(FeignWatchPoint.class);
    private final        FooServerClient fooServerClient;

    @Override
    public void doExecute(Response response, Context context, WatchPointChain chain) {
        Map<String, Object> request = new HashMap<>();
        request.put("hi", "foo");
        Response r = fooServerClient.helloGreetings(request, "hello, foo-server");
        log.info("r: {}", r);
        chain.doExecute(response, context);
    }
}
