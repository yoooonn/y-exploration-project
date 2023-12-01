package top.yooonn.explore.notes.cloud.aio.watchpoint.impl;

import com.alibaba.fastjson.JSONObject;
import top.yooonn.explore.notes.cloud.aio.watchpoint.Context;
import top.yooonn.explore.notes.cloud.aio.watchpoint.WatchPoint;
import top.yooonn.explore.notes.cloud.aio.watchpoint.WatchPointChain;
import com.ycourlee.tranquil.web.dto.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author yooonn
 * @date 2023.01.29
 */
@Component
@RequiredArgsConstructor
public class PropOverwriteWatchPoint implements WatchPoint {

    private final Environment environment;

    @Override
    public void doExecute(Response response, Context context, WatchPointChain chain) {
        String propKey = ((JSONObject) context.getRequest()).getString("prop_key");
        if (StringUtils.isEmpty(propKey)) {
            chain.doExecute(response, context);
        }
        String value = environment.resolvePlaceholders("${" + propKey + "}");
        response.pin(propKey, value);
        chain.doExecute(response, context);
    }
}
