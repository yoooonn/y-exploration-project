package com.ycourlee.explore.javalib.sudoku;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author yongjiang
 * @date 2022.03.28
 */
public class DefaultSudokuSolver implements SudokuSolver {

    private static final Logger log = LoggerFactory.getLogger(DefaultSudokuSolver.class);

    private long MAX_COMPUTE_TIME = 100;

    private Sudoku puzzle;

    private Sudoku workPuzzle;

    private boolean initSolution;

    public DefaultSudokuSolver(Sudoku puzzle) {
        this.puzzle = puzzle;
        this.workPuzzle = puzzle.deepClone();
    }

    public DefaultSudokuSolver(Sudoku puzzle, Integer allowedComputeTimeInSeconds) {
        this.puzzle = puzzle;
        this.workPuzzle = puzzle.deepClone();
        if (allowedComputeTimeInSeconds != null && allowedComputeTimeInSeconds > 0) {
            MAX_COMPUTE_TIME = allowedComputeTimeInSeconds;
        }
    }

    @Override
    public Sudoku puzzle() {
        return this.puzzle;
    }

    @Override
    public void solve() {
        StopWatch stopWatch = StopWatch.createStarted();

        initSolution(this.workPuzzle);

        Set<Coordinate> visited = new HashSet<>();
        Sudoku result = recursivelyFindAnswer(stopWatch, this.workPuzzle, visited);
        printCurrentResult(result);
    }

    private void printCurrentResult(Sudoku resultPuzzle) {
        int cnt = 0;
        for (SudokuCell cell : resultPuzzle.cells()) {
            cnt++;
            String value = "-";
            if (cell.uniqueValue()) {
                value = String.valueOf(cell.getValue());
            }
            if (cnt % 9 != 0) {
                System.out.print(value + "  ");
            } else {
                System.out.println(value);
            }
        }
    }

    private void initSolution(Sudoku replica) {
        if (initSolution) {
            return;
        }
        addNinePossiblesIfCellNonUnique(replica);

        removePossiblesByCellUniqueValue(replica);

        initSolution = true;
    }

    private void addNinePossiblesIfCellNonUnique(Sudoku sudoku) {
        sudoku.cells().forEach(cell -> {
            if (!cell.uniqueValue()) {
                cell.possible(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
            }
        });
    }

    private Sudoku recursivelyFindAnswer(StopWatch stopWatch, Sudoku sudoku, Set<Coordinate> visited) {
        Sudoku clone = sudoku.deepClone();
        removePossiblesByCellUniqueValue(clone);
        if (clone.abnormal()) {
            return clone;
        }
        if (clone.correct()) {
            return clone;
        }
        while (stopWatch.getTime(TimeUnit.SECONDS) <= MAX_COMPUTE_TIME) {
            SudokuCell cell = findMinimumPossibleNumberCell(clone.cells(), visited);
            if (cell == null) {
                log.warn("no direction!");
                break;
            }
            Collection<Integer> possibleNumbers = cell.possibleNumbers();
            log.info("\n{}find cell {}", StringUtils.repeat(" ", visited.size() * 2), cell);
            visited.add(cell.coordinate());
            for (Integer possibleNumber : possibleNumbers) {
                log.info("{}answer cell {} with {}", StringUtils.repeat(" ", (visited.size() - 1) * 2), cell, possibleNumber);
                cell.answer(possibleNumber);
                return recursivelyFindAnswer(stopWatch, clone, visited);
            }
            visited.remove(cell.coordinate());
        }
        return clone;
    }

    private SudokuCell findMinimumPossibleNumberCell(Collection<SudokuCell> values, Set<Coordinate> excludes) {
        return values.stream()
                .filter(cell -> !cell.uniqueValue())
                .filter(cell -> !excludes.contains(cell.coordinate()))
                .min(Comparator.comparingInt(o -> o.possibleNumbers().size()))
                .orElse(null);
    }

    private void removePossiblesByCellUniqueValue(Sudoku sudoku) {
        Collection<SudokuCell> cells = sudoku.cells();
        while (true) {
            int count = 0;
            for (SudokuCell cell : cells) {
                if (cell.uniqueValue()) {
                    // row clear
                    boolean cellHasImpossible = sudoku.row(cell.getRowKey()).impossible(cell.coordinate(), cell.getValue());
                    // column clear
                    boolean columnImpossible = sudoku.column(cell.getColumnKey()).impossible(cell.coordinate(), cell.getValue());
                    // box clear
                    boolean boxImpossible = sudoku.box(Sudoku.indexOfBox(cell.coordinate())).impossible(cell.coordinate(), cell.getValue());
                    if (cellHasImpossible || columnImpossible || boxImpossible) {
                        count++;
                    }
                }
            }
            if (count == 0) {
                break;
            }
        }
    }
}
