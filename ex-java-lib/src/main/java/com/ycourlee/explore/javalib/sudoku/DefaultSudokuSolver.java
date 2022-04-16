package com.ycourlee.explore.javalib.sudoku;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Collection;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/**
 * @author yongjiang
 * @date 2022.03.28
 */
public class DefaultSudokuSolver implements SudokuSolver {

    private Sudoku puzzle;

    public DefaultSudokuSolver(Sudoku puzzle) {
        this.puzzle = puzzle;
    }

    @Override
    public Sudoku puzzle() {
        return this.puzzle;
    }

    @Override
    public void solve() {
        StopWatch stopWatch = StopWatch.createStarted();
        recursivelyFindAnswer(stopWatch, this.puzzle);
    }

    private void recursivelyFindAnswer(StopWatch stopWatch, Sudoku sudoku) {
        Sudoku clone = sudoku.deepClone();
        while (stopWatch.getTime(TimeUnit.SECONDS) <= 60) {
            Cell cell = findMinimumPossibleNumberCell(clone.values());
            Collection<Integer> possibleNumbers = cell.possibleNumbers();
            for (Integer possibleNumber : possibleNumbers) {
                cell.assumeAnswer(possibleNumber);
                clone.impossible(cell.coordinate(), possibleNumber);
            }
        }
    }

    private Cell findMinimumPossibleNumberCell(Collection<Cell> values) {
        return values.stream().min(Comparator.comparingInt(o -> o.possibleNumbers().size())).orElse(null);
    }
}
