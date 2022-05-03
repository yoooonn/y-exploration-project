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

    private Table<Integer, Integer, SudokuCell> data;

    private DefaultSudoku(Cell... cells) {
        ImmutableTable.Builder<Integer, Integer, SudokuCell> builder = ImmutableTable.builder();
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                builder.put(i, j, DefaultCell.of(i, j));
            }
        }
        data = builder.build();
        for (Cell cell : cells) {
            SudokuCell sudokuCell = get(cell.getRowKey(), cell.getColumnKey());
            sudokuCell.answer(cell.getValue());
        }
    }

    public static DefaultSudoku initFrom(Cell... cells) {
        return new DefaultSudoku(cells);
    }

    @Override
    public SudokuCell cell(Coordinate coordinate) {
        return get(coordinate.getR(), coordinate.getC());
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
        index--;
        int i = (index / 3) * 3;
        int j = (index % 3) * 3;
        Map<Integer, SudokuCell> boxMap = new HashMap<>(9);
        int idx = 1;
        for (int k = i; k < i + 3; k++) {
            for (int l = j; l < j + 3; l++) {
                boxMap.put(idx++, get(k + 1, l + 1));
            }
        }
        return new DefaultSquareGroup(boxMap);
    }

    @Override
    public Collection<SudokuCell> cells() {
        return data.values();
    }

    @Override
    public boolean possible(Coordinate coo, Integer number) {
        Assert.notNull(coo);
        Assert.notNull(number);
        SudokuCell cell = cell(coo);
        Assert.notNull(cell);
        return cell.possible(number);
    }

    @Override
    public boolean impossible(Coordinate coo, Integer number) {
        Assert.notNull(coo);
        Assert.notNull(number);
        SudokuCell cell = cell(coo);
        return cell.impossible(number);
    }

    @Override
    public void answer(Coordinate coo, Integer number) {
        Assert.notNull(coo);
        Assert.notNull(number);
        SudokuCell cell = cell(coo);
        Assert.notNull(cell);
        cell.answer(number);
    }

    @Override
    public boolean abnormal() {
        for (int i = 1; i <= 9; i++) {
            if (row(i).abnormal()) {
                return true;
            }
            if (column(i).abnormal()) {
                return true;
            }
            if (box(i).abnormal()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean correct() {
        for (int i = 1; i <= 9; i++) {
            if (row(i).incorrect()) {
                return false;
            }
            if (column(i).incorrect()) {
                return false;
            }
            if (box(i).incorrect()) {
                return false;
            }
        }
        return true;
    }

    private SudokuCell get(int r, int c) {
        return data.get(r, c);
    }

    private Map<Integer, SudokuCell> dataRow(int row) {
        return data.row(row);
    }

    private Map<Integer, SudokuCell> dataColumn(int column) {
        return data.column(column);
    }
}
