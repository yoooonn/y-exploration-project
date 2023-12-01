package top.yooonn.explore.notes.cloud.aio.chain;

/**
 * @author yooonn
 * @date 2021.11.19
 */
public interface ElementChain<Exchange, Ctx> {

    /**
     * 执行链
     *
     * @param exchange 交换体
     * @param ctx      上下文
     */
    void doExecute(Exchange exchange, Ctx ctx);
}
