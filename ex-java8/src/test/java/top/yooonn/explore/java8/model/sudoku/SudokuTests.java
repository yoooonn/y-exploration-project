package top.yooonn.explore.java8.model.sudoku;

import top.yooonn.explore.java8.AbstractTest;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yooonn
 * @date 2022.03.05
 */
public class SudokuTests extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(SudokuTests.class);

    @Test
    public void mainTest() {
        Sudoku sudoku = Sudoku.of(
                Pair.of(Position.of(1, 1), 9),
                Pair.of(Position.of(3, 4), 9),
                Pair.of(Position.of(2, 5), 9));
        log.info("sudoku: \n{}", sudoku);
    }
}
