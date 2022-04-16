package com.ycourlee.explore.javalib.sudoku;

/**
 * @author yongjiang
 * @date 2022.03.26
 */
public interface CellOperation {

    int possible(Integer number);

    int impossible(Integer number);

    boolean answer(Integer number);

    void assumeAnswer(Integer number);
}
