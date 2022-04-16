package com.ycourlee.explore.javalib.sudoku;

import cn.hutool.core.collection.CollectionUtil;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author yongjiang
 * @date 2022.03.28
 */
public class DefaultSquareGroup implements SquareGroup {

    private Map<Integer, Cell> squares;

    public DefaultSquareGroup(Map<Integer, Cell> squares) {
        if (CollectionUtil.isEmpty(squares)) {
            throw new IllegalArgumentException();
        }
        this.squares = squares;
    }

    @Override
    public boolean untenable() {
        return this.squares
                .values().stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Cell::getValue))
                .values().stream()
                .anyMatch(cells -> cells.size() > 1);
    }

    @Override
    public void impossible(Integer num) {
        squares.values().forEach(cell -> cell.impossible(num));
    }

    public Map<Integer, Cell> squares() {
        return this.squares;
    }
}
