package top.yooonn.explore.javalib.sudoku;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yooonn
 * @date 2022.03.28
 */
public class DefaultSudokuSolver implements SudokuSolver {

    private static final Logger log = LoggerFactory.getLogger(DefaultSudokuSolver.class);

    private long MAX_COMPUTE_TIME = 100;

    private Sudoku puzzle;

    private Sudoku workPuzzle;

    private Sudoku answer;

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

        initSolutionResolver(this.workPuzzle);

        List<Coordinate> visited = new ArrayList<>();
        recursivelyFindAnswer(stopWatch, this.workPuzzle, visited, 0);
        if (answer != null) {
            printCurrentResult(answer);
        } else {
            System.out.println("No answer found");
        }
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

    private void initSolutionResolver(Sudoku replica) {
        if (initSolution) {
            return;
        }
        addNinePossiblesIfCellNonUnique(replica);

        removePossiblesByCellUniqueValue(replica);

        printCurrentResult(replica);

        long poss = 1;
        for (SudokuCell cell : replica.cells()) {
            poss *= cell.possibleNumbers().size();
        }

        System.out.println("\n共" + poss + "种可能");

        initSolution = true;
    }

    private void addNinePossiblesIfCellNonUnique(Sudoku sudoku) {
        sudoku.cells().forEach(cell -> {
            if (!cell.uniqueValue()) {
                cell.possible(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
            }
        });
    }

    private void recursivelyFindAnswer(StopWatch stopWatch, Sudoku sudoku, List<Coordinate> visited, int depth) {
        removePossiblesByCellUniqueValue(sudoku);
        if (sudoku.correct()) {
            answer = sudoku;
        }
        if (sudoku.abnormal()) {
            log.warn("{}abnormal path to solution", StringUtils.repeat(" ", Math.max(0, (depth - 1) * 2)));
            return;
        }
        for (SudokuCell cell : findNoAnswerCells(sudoku.cells(), visited)) {
            Collection<Integer> possibleNumbers = cell.possibleNumbers();
            log.info("\n{}find cell {}", StringUtils.repeat(" ", depth * 2), cell);
            visited.add(cell.coordinate());
            for (Integer possibleNumber : possibleNumbers) {
                log.info("{}answer cell {} with {}", StringUtils.repeat(" ", (depth) * 2), cell, possibleNumber);
                Sudoku clone = sudoku.deepClone();
                SudokuCell sudokuCell = clone.cell(cell.coordinate());
                sudokuCell.answer(possibleNumber);
                recursivelyFindAnswer(stopWatch, clone, visited, depth + 1);
            }
            visited.remove(cell.coordinate());
        }
    }

    private SudokuCell findMinimumPossibleNumberCell(Collection<SudokuCell> values, Collection<Coordinate> excludes) {
        return values.stream()
                .filter(cell -> !cell.uniqueValue())
                .filter(cell -> !excludes.contains(cell.coordinate()))
                .min(Comparator.comparingInt(o -> o.possibleNumbers().size()))
                .orElse(null);
    }

    private Collection<SudokuCell> findNoAnswerCells(Collection<SudokuCell> values, Collection<Coordinate> excludes) {
        return values.stream()
                .filter(cell -> !cell.uniqueValue())
                .sorted(new Comparator<SudokuCell>() {
                    @Override
                    public int compare(SudokuCell o1, SudokuCell o2) {
                        return o1.possibleNumbers().size() - o2.possibleNumbers().size();
                    }
                }).collect(Collectors.toList());
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
