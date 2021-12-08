package com.ycourlee.explore.solution.crypto;

/**
 * @author yongjiang
 * @date 2021.11.29
 */
public interface Factory<T> {

    T generate(Object obj) throws Exception;
}
