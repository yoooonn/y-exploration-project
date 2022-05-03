package com.ycourlee.explore.javalib.sudoku;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author yongjiang
 * @date 2022.03.26
 */
public interface SudokuCell extends Cell, Serializable {

    Collection<Integer> possibleNumbers();

    boolean uniqueValue();

    Coordinate coordinate();

    boolean possible(Integer number);

    boolean possible(Collection<Integer> numbers);

    boolean impossible(Integer number);

    void answer(Integer number);
}
