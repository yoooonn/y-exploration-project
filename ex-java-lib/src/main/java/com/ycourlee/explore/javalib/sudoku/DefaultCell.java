package com.ycourlee.explore.javalib.sudoku;

import com.google.common.collect.Table;
import com.ycourlee.tranquil.core.util.Assert;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author yongjiang
 * @date 2022.03.26
 */
public class DefaultCell implements Cell {

    private final Character MUTEX_ANSWER = 'L';
    private Coordinate coordinate;
    private Collection<Integer> possibleNumbers = new ArrayList<>();
    private volatile Integer answer;
    private boolean answerIsAssumed = true;

    private DefaultCell() {
    }

    public static Cell of(int r, int c, int value) {
        DefaultCell cell = new DefaultCell();
        cell.coordinate = Coordinate.of(r, c);
        cell.answer = value;
        cell.answerIsAssumed = false;
        return cell;
    }

    public static Cell of(Table.Cell<Integer, Integer, Integer> tableCell) {
        DefaultCell cell = new DefaultCell();
        Assert.notNull(tableCell.getRowKey());
        Assert.notNull(tableCell.getColumnKey());
        Assert.notNull(tableCell.getValue());
        cell.coordinate = Coordinate.of(tableCell.getRowKey(), tableCell.getColumnKey());
        cell.answer = tableCell.getValue();
        cell.answerIsAssumed = false;
        return cell;
    }

    @Override
    public Coordinate coordinate() {
        return coordinate;
    }

    @Override
    public Collection<Integer> possibleNumbers() {
        return possibleNumbers;
    }

    @Override
    public int possible(Integer number) {
        possibleNumbers.add(number);
        return possibleNumbers.size();
    }

    @Override
    public int impossible(Integer number) {
        possibleNumbers.remove(number);
        return possibleNumbers.size();
    }

    @Override
    public boolean answer(Integer number) {
        if (answerIsAssumed) {
            synchronized (MUTEX_ANSWER) {
                answer = number;
                answerIsAssumed = false;
            }
        }
        throw new CellAnswerConflictException(this);
    }

    @Override
    public void assumeAnswer(Integer number) {
        synchronized (MUTEX_ANSWER) {
            answer = number;
            answerIsAssumed = true;
        }
    }

    @Override
    public @Nullable Integer getRowKey() {
        return coordinate.getR();
    }

    @Override
    public @Nullable Integer getColumnKey() {
        return coordinate.getC();
    }

    @Override
    public @Nullable Integer getValue() {
        return answer;
    }

    @Override
    public String toString() {
        return "(" + getRowKey() + ", " + getColumnKey() + ", " + getValue() + ")" +
                " " + possibleNumbers.toString();
    }
}
