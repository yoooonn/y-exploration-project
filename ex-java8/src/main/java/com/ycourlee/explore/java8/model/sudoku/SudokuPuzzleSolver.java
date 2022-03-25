package com.ycourlee.explore.java8.model.sudoku;

import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author yongjiang
 * @date 2022.03.05
 */
public class SudokuPuzzleSolver {

    private static final Logger log = LoggerFactory.getLogger(SudokuPuzzleSolver.class);

    private Sudoku sudoku;

    public SudokuPuzzleSolver(Sudoku sudoku) {
        if (sudoku == null) {
            throw new IllegalArgumentException("Sudoku can not be null.");
        }
        this.sudoku = sudoku;
        if (sudoku.getInitialNumbers() < 18) {
            log.warn("Initial answer of sudoku is too less, and it is likely that no solution will be found: \n{}", sudoku);
        } else {
            log.debug("Sudoku puzzle solver init with sudoku: \n{}", sudoku);
        }
    }

    public void findSolution() {
        if (sudoku.getInitialNumbers() < 12) {
            throw new IllegalStateException("Initial count of number less than 12");
        }
        initEverySquareAllPossibleNumbers();

        removePossiblesFromExistNumbers();

        findAnswers();
    }

    private void findAnswers() {
        Pair<Integer, Position> nextPossibleAnswer = new MutablePair<>(9, null);
        Iterator<Square> iterator = sudoku.squaresIterator();

        while (iterator.hasNext()) {
            Square next = iterator.next();
            // if(next.)

        }

    }

    private void removePossiblesFromExistNumbers() {
        sudoku.getRow().forEach((row, squares) -> remove(squares.inners()));

        sudoku.getCol().forEach((col, squares) -> remove(squares.inners()));

        sudoku.getPositionMatrixMap().forEach(((position, matrix) -> remove(matrix.getSquares().inners())));
    }

    private void remove(Collection<Square> squares) {
        Integer[] answerNumbers = squares.stream().filter(Square::hasAnswer).map(Square::getAnswer).toArray(Integer[]::new);
        if (answerNumbers.length > 0) {
            squares.forEach(square -> {
                if (!square.hasAnswer()) {
                    square.impossible(answerNumbers);
                }
            });
        }
    }

    private void initEverySquareAllPossibleNumbers() {
        sudoku.getRow().forEach((row, squares) -> {
            squares.inners().forEach(square -> {
                if (!square.hasAnswer()) {
                    square.possible(1, 2, 3, 4, 5, 6, 7, 8, 9);
                }
            });
        });
    }
}
