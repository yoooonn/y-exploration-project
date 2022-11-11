package com.ycourlee.explore.notes.nacos.provider.chain;

/**
 * @author yooonn
 * @date 2021.11.19
 */
public interface ElementChain<Exchange, Rule> {

    /**
     * 执行链
     *
     * @param exchange 交换体
     * @param rule     规则依赖
     */
    void doExecute(Exchange exchange, Rule rule);
}
