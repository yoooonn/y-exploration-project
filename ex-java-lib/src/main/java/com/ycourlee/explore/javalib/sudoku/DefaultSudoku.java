package com.ycourlee.explore.javalib.sudoku;

import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;
import com.ycourlee.tranquil.core.util.Assert;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yongjiang
 * @date 2022.03.26
 */
public class DefaultSudoku implements Sudoku {

    private static final long serialVersionUID = -2142873974928065116L;

    private Table<Integer, Integer, Cell> data;

    @SafeVarargs
    private DefaultSudoku(Table.Cell<Integer, Integer, Integer>... cells) {
        ImmutableTable.Builder<Integer, Integer, Cell> builder = ImmutableTable.builder();
        for (Table.Cell<Integer, Integer, Integer> cell : cells) {
            Assert.notNull(cell.getRowKey());
            Assert.notNull(cell.getColumnKey());
            Assert.notNull(cell.getValue());
            builder.put(cell.getRowKey() - 1, cell.getColumnKey() - 1,
                    DefaultCell.of(cell.getRowKey() - 1, cell.getColumnKey() - 1, cell.getValue()));
        }
        data = builder.build();
    }

    @Override
    public SquareGroup column(int column) {
        Assert.that(1 <= column && column <= 9);
        return new DefaultSquareGroup(dataColumn(column));
    }

    @Override
    public SquareGroup row(int row) {
        Assert.that(1 <= row && row <= 9);
        return new DefaultSquareGroup(dataRow(row));
    }

    @Override
    public SquareGroup box(int index) {
        Assert.that(1 <= index && index <= 9);

        int i = (index / 3) * 3;
        int j = (index % 3 - 1) * 3;
        Map<Integer, Cell> boxMap = new HashMap<>(12);
        int idx = 1;
        for (int k = i; k < i + 3; k++) {
            for (int l = j; l < j + 3; l++) {
                boxMap.put(idx, get(k, l));
            }
        }
        return new DefaultSquareGroup(boxMap);
    }

    @Override
    public Collection<Cell> values() {
        return data.values();
    }

    @Override
    public int possible(Coordinate coo, Integer number) {
        Assert.notNull(coo);
        Assert.notNull(number);
        Cell cell = get(coo.getR(), coo.getC());
        Assert.notNull(cell);
        return cell.possible(number);
    }

    @Override
    public int impossible(Coordinate coo, Integer number) {
        Assert.notNull(coo);
        Assert.notNull(number);
        Cell cell = get(coo.getR(), coo.getC());
        Assert.notNull(cell);
        SquareGroup column = column(coo.getR());
        column.impossible(number);
        return cell.impossible(number);
    }

    @Override
    public boolean answer(Coordinate coo, Integer number) {
        Assert.notNull(coo);
        Assert.notNull(number);
        Cell cell = get(coo.getR(), coo.getC());
        Assert.notNull(cell);
        return cell.answer(number);
    }

    @Override
    public void assumeAnswer(Coordinate coo, Integer number) {
        Assert.notNull(coo);
        Assert.notNull(number);
        Cell cell = get(coo.getR(), coo.getC());
        Assert.notNull(cell);
        cell.assumeAnswer(number);
    }

    @Override
    public boolean whetherAbnormal() {
        for (int i = 1; i <= 9; i++) {
            if (row(i).untenable()) {
                return true;
            }
            if (column(i).untenable()) {
                return true;
            }
            if (box(i).untenable()) {
                return true;
            }
        }
        return false;
    }

    private Cell get(int r, int c) {
        return data.get(r - 1, c - 1);
    }

    private Map<Integer, Cell> dataRow(int row) {
        return data.row(row - 1);
    }

    private Map<Integer, Cell> dataColumn(int column) {
        return data.column(column - 1);
    }
}
