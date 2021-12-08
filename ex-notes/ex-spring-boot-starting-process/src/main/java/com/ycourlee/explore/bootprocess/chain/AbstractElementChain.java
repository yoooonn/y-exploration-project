package com.ycourlee.explore.bootprocess.chain;

import java.util.List;

/**
 * @author yongjiang
 * @date 2021.11.19
 */
public abstract class AbstractElementChain<Ex, R, E extends Element<Ex, R, ? extends ElementChain<Ex, R>>> implements ElementChain<Ex, R> {

    protected final List<E> elements;

    protected int index = 0;

    public AbstractElementChain(List<E> elements) {
        this.elements = elements;
    }
}
