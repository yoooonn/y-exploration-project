package com.ycourlee.explore.notes.cloud.aio.chain;

import org.springframework.core.Ordered;

/**
 * @author yooonn
 * @date 2021.11.19
 */
public interface Element<Exchange, Ctx, Chain extends ElementChain<Exchange, Ctx>> extends Ordered {

    @Override
    default int getOrder() {
        return 0;
    }

    default boolean disabled() {
        return false;
    }

    /**
     * @param exchange 交换体
     * @param ctx      上下文
     * @param chain    当前链
     */
    void doExecute(Exchange exchange, Ctx ctx, Chain chain);
}
