package com.ycourlee.explore.javalib.sudoku;

/**
 * @author yongjiang
 * @date 2022.03.28
 */
public interface SquareGroup {

    boolean untenable();

    void impossible(Integer num);
}
