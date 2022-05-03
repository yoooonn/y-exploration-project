package com.ycourlee.explore.javalib.sudoku;

import com.ycourlee.explore.javalib.AbstractTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yongjiang
 * @date 2022.03.28
 */
public class DefaultSudokuTests extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(DefaultSudokuTests.class);

    @Test
    void mainTest() {
        Sudoku sudoku = DefaultSudoku.initFrom(DefaultCell.of(1, 1, 2));
        Sudoku clone = sudoku.deepClone();
        log.info("sudoku: {}", sudoku.cells());
    }
}
