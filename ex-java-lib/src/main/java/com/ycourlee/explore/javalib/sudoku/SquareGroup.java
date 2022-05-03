package com.ycourlee.explore.javalib.sudoku;

/**
 * @author yongjiang
 * @date 2022.03.28
 */
public interface SquareGroup {

    boolean abnormal();

    boolean incorrect();

    boolean impossible(Coordinate coordinate, Integer num);
}
