package com.ycourlee.explore.javalib.sudoku;

import com.google.common.collect.Table;

import java.util.Collection;

/**
 * @author yongjiang
 * @date 2022.03.26
 */
public interface Cell extends Table.Cell<Integer, Integer, Integer>, CellOperation {

    Collection<Integer> possibleNumbers();

    Coordinate coordinate();
}
