package top.yooonn.explore.javalib.sudoku;

/**
 * @author yooonn
 * @date 2022.03.26
 */
public class CellAnswerConflictException extends RuntimeException {

    private static final long serialVersionUID = -5980770472617239132L;

    public CellAnswerConflictException() {
        super();
    }

    public CellAnswerConflictException(Cell cell) {
        super(" Cell (" + cell.getRowKey() + ", " + cell.getColumnKey() + ") already has answer " + cell.getValue());
    }

    public CellAnswerConflictException(Cell cell, Throwable cause) {
        super(" Cell (" + cell.getRowKey() + ", " + cell.getColumnKey() + ") already has answer " + cell.getValue(), cause);
    }
}
