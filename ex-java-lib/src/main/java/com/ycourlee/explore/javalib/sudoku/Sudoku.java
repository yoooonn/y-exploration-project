package com.ycourlee.explore.javalib.sudoku;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author yongjiang
 * @date 2022.03.26
 */
public interface Sudoku extends SudokuOperation, Serializable {

    SquareGroup column(int column);

    SquareGroup row(int row);

    SquareGroup box(int index);

    Collection<Cell> values();

    default Sudoku deepClone() {
        return SerializationUtils.clone(this);
    }
}
