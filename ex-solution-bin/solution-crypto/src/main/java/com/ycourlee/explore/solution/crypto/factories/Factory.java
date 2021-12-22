package com.ycourlee.explore.solution.crypto.factories;

/**
 * @author yongjiang
 * @date 2021.11.29
 */
public interface Factory<T, P> {

    T generate(P obj) throws Exception;
}
