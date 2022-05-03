package com.ycourlee.explore.javalib.sudoku;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author yongjiang
 * @date 2022.03.26
 */
public class DefaultCell implements SudokuCell {

    private static final long serialVersionUID = 230502069856359905L;

    private static final Character     MUTEX_ANSWER    = 'L';
    private              Coordinate    coordinate;
    private              List<Integer> possibleNumbers = new ArrayList<>();

    private DefaultCell() {
    }

    public static SudokuCell of(int r, int c, int value) {
        DefaultCell cell = new DefaultCell();
        cell.answer(value);
        cell.coordinate = Coordinate.of(r, c);
        return cell;
    }

    public static SudokuCell of(int r, int c) {
        DefaultCell cell = new DefaultCell();
        cell.coordinate = Coordinate.of(r, c);
        return cell;
    }

    public static SudokuCell of(Cell plainCell) {
        DefaultCell cell = new DefaultCell();
        cell.answer(plainCell.getValue());
        cell.coordinate = Coordinate.of(plainCell.getRowKey(), plainCell.getColumnKey());
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
    public boolean possible(Integer number) {
        if (!possibleNumbers.contains(number)) {
            return possibleNumbers.add(number);
        }
        return false;
    }

    @Override
    public boolean possible(Collection<Integer> numbers) {
        boolean hasTrue = false;
        for (Integer number : numbers) {
            if (possible(number)) {
                hasTrue = true;
            }
        }
        return hasTrue;
    }

    @Override
    public boolean impossible(Integer number) {
        return possibleNumbers.remove(number);
    }

    @Override
    public void answer(Integer number) {
        synchronized (MUTEX_ANSWER) {
            possibleNumbers.removeIf(e -> !e.equals(number));
            if (!possibleNumbers.contains(number)) {
                possibleNumbers.add(number);
            }
        }
    }

    @Override
    public boolean uniqueValue() {
        return possibleNumbers.size() == 1;
    }

    @Override
    public int getRowKey() {
        return coordinate.getR();
    }

    @Override
    public int getColumnKey() {
        return coordinate.getC();
    }

    @Override
    public int getValue() {
        if (uniqueValue()) {
            return possibleNumbers.get(0);
        }
        throw new IllegalStateException("Size is not 1");
    }

    @Override
    public String toString() {
        if (uniqueValue()) {
            return "(" + getRowKey() + ", " + getColumnKey() + ", " + getValue() + ")";
        }
        return "(" + getRowKey() + ", " + getColumnKey() + ", " +
                possibleNumbers.toString() + ")";
    }
}
