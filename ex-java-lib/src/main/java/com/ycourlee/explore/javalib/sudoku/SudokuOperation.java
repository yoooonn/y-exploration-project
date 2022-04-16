package com.ycourlee.explore.javalib.sudoku;

/**
 * @author yongjiang
 * @date 2022.03.26
 */
public interface SudokuOperation {

    @Deprecated
    int possible(Coordinate coo, Integer number);

    int impossible(Coordinate coo, Integer number);

    boolean answer(Coordinate coo, Integer number);

    void assumeAnswer(Coordinate coo, Integer number);

    boolean whetherAbnormal();
}
