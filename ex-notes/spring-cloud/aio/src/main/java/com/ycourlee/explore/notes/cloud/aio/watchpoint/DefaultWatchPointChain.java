package com.ycourlee.explore.notes.cloud.aio.watchpoint;

import com.ycourlee.explore.notes.cloud.aio.chain.AbstractElementChain;
import com.ycourlee.tranquil.web.dto.Response;

import java.util.List;

/**
 * @author yooonn
 * @date 2021.11.30
 */
public class DefaultWatchPointChain extends AbstractElementChain<Response, Context, WatchPoint> implements WatchPointChain {

    public DefaultWatchPointChain(List<WatchPoint> follows) {
        super(follows);
    }

    @Override
    public void doExecute(Response resp, Context context) {
        if (this.index < this.elements.size()) {
            WatchPoint wp = this.elements.get(this.index++);
            wp.doExecute(resp, context, this);
        }
    }
}
