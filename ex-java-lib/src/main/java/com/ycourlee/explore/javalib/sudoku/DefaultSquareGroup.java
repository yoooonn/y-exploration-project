package com.ycourlee.explore.javalib.sudoku;

import cn.hutool.core.collection.CollectionUtil;

import java.io.Serializable;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yongjiang
 * @date 2022.03.28
 */
public class DefaultSquareGroup implements SquareGroup, Serializable {

    private static final long serialVersionUID = -6273059386504728623L;

    private Map<Integer, SudokuCell> squares;

    public DefaultSquareGroup(Map<Integer, SudokuCell> squares) {
        if (CollectionUtil.isEmpty(squares)) {
            throw new IllegalArgumentException();
        }
        this.squares = squares;
    }

    @Override
    public boolean abnormal() {
        return this.squares.values().stream()
                .anyMatch(cell -> cell.possibleNumbers().size() == 0) ||
                this.squares
                        .values().stream()
                        .filter(SudokuCell::uniqueValue)
                        .collect(Collectors.groupingBy(Cell::getValue))
                        .values().stream()
                        .anyMatch(cells -> cells.size() > 1);
    }

    @Override
    public boolean incorrect() {
        return abnormal() || this.squares.values()
                .stream()
                .filter(SudokuCell::uniqueValue)
                .count() != 9;
    }

    @Override
    public boolean impossible(Coordinate coordinate, Integer num) {
        boolean hasImpossible = false;
        for (SudokuCell cell : squares.values()) {
            if (cell.coordinate().equals(coordinate)) {
                continue;
            }
            if (cell.impossible(num)) {
                hasImpossible = true;
            }
        }
        return hasImpossible;
    }

    public Map<Integer, SudokuCell> squares() {
        return this.squares;
    }
}
