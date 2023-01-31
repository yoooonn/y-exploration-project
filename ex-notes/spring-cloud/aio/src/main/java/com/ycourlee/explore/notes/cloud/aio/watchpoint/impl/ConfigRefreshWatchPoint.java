package com.ycourlee.explore.notes.cloud.aio.watchpoint.impl;

import com.ycourlee.explore.notes.cloud.aio.context.ParamsHolder;
import com.ycourlee.explore.notes.cloud.aio.watchpoint.Context;
import com.ycourlee.explore.notes.cloud.aio.watchpoint.WatchPoint;
import com.ycourlee.explore.notes.cloud.aio.watchpoint.WatchPointChain;
import com.ycourlee.tranquil.web.dto.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author yooonn
 * @date 2022.11.18
 */
@Component
@RequiredArgsConstructor
public class ConfigRefreshWatchPoint implements WatchPoint {

    private final ParamsHolder paramsHolder;

    @Override
    public void doExecute(Response response, Context context, WatchPointChain chain) {
        response.pin(getClass().getCanonicalName(), paramsHolder.getStr());
        chain.doExecute(response, context);
    }
}
