package com.ycourlee.explore.bootprocess.chain;

/**
 * @author yongjiang
 * @date 2021.11.19
 */
public interface Element<Exchange, Rule, Chain extends ElementChain<Exchange, Rule>> {

    /**
     * order
     * @return 值越小优先级越大
     */
    int order();

    default boolean disabled() {
        return false;
    }

    /**
     *
     * @param exchange 交换体
     * @param rule 规则依赖
     * @param chain 当前链
     */
    void doExecute(Exchange exchange, Rule rule, Chain chain);
}
