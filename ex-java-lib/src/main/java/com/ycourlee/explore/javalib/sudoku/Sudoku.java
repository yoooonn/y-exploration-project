package com.ycourlee.explore.javalib.sudoku;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author yooonn
 * @date 2022.03.26
 */
public interface Sudoku extends Serializable {

    SudokuCell cell(Coordinate coordinate);

    SquareGroup column(int column);

    SquareGroup row(int row);

    SquareGroup box(int index);

    Collection<SudokuCell> cells();

    boolean abnormal();

    boolean correct();

    @Deprecated
    boolean possible(Coordinate coo, Integer number);

    boolean impossible(Coordinate coo, Integer number);

    @Deprecated
    void answer(Coordinate coo, Integer number);

    static int indexOfBox(Coordinate coordinate){
        return indexOfBox(coordinate.getR(), coordinate.getC());
    }

    static int indexOfBox(int row, int column) {
        int i = row - 1;
        int j = column - 1;
        int a = (i / 3) * 3;
        int b = (j / 3) * 3;
        return (a / 3) * 3 + b / 3 + 1;
    }

    default Sudoku deepClone() {
        return SerializationUtils.clone(this);
    }
}
