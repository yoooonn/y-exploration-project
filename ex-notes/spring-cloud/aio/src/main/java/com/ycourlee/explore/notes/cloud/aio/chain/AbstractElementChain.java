package com.ycourlee.explore.notes.cloud.aio.chain;

import java.util.List;

/**
 * @author yooonn
 * @date 2021.11.19
 */
public abstract class AbstractElementChain<Ex, Ctx, E extends Element<Ex, Ctx, ? extends ElementChain<Ex, Ctx>>> implements ElementChain<Ex, Ctx> {

    protected final List<E> elements;

    protected int index = 0;

    public AbstractElementChain(List<E> elements) {
        this.elements = elements;
    }
}
