package com.ycourlee.explore.java8.model.sudoku;

import lombok.Getter;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yongjiang
 * @date 2022.03.04
 */
@Getter
public class Sudoku {

    /**
     * 每个方格位置与其所在3*3方格的对应关系
     */
    private Map<Position, Matrix> positionMatrixMap = new LinkedHashMap<>();

    /**
     * 该3*3方格的方格
     */
    private RestrictSquares squares = new RestrictSquares();

    /**
     * 行，方格
     */
    private Map<Integer, RestrictSquares> row = new LinkedHashMap<>();

    /**
     * 列，方格
     */
    private Map<Integer, RestrictSquares> col = new LinkedHashMap<>();

    private int initialNumbers = 0;

    public Sudoku() {

        for (int i = 0; i < 9; ) {
            for (int j = 0; j < 9; ) {
                Matrix matrix = Matrix.of(i, j);
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        Position position = new Position(k, l);
                        this.positionMatrixMap.put(position, matrix);
                    }
                }
                j += 3;
            }
            i += 3;
        }

        for (int i = 0; i < 9; i++) {
            row.put(i, new RestrictSquares());
            col.put(i, new RestrictSquares());
        }

        int r = 0;
        for (int i = 0; i < 9; ) {
            for (int k = 0; k < 3; k++, r++) {
                List<Square> squares = row.get(r).inners();
                for (int j = 0; j < 9; ) {
                    squares.addAll(positionMatrixMap.get(new Position(i, j)).getRow().get(r));
                    j += 3;
                }
                row.put(r, new RestrictSquares(squares));
                this.squares.inners().addAll(squares);
            }
            i += 3;
        }

        int c = 0;
        for (int i = 0; i < 9; ) {
            for (int k = 0; k < 3; k++, c++) {
                List<Square> squares = col.get(c).inners();
                for (int j = 0; j < 9; ) {
                    squares.addAll(positionMatrixMap.get(new Position(j, i)).getCol().get(c));
                    j += 3;
                }
                col.put(c, new RestrictSquares(squares));
            }
            i += 3;
        }
    }

    @SafeVarargs
    private Sudoku(Pair<Position, Integer>... inits) {
        this();
        if (inits.length > 0) {
            for (Pair<Position, Integer> squareInit : inits) {
                Position pos = Position.of(squareInit.getLeft().getR() - 1, squareInit.getLeft().getC() - 1);
                Matrix matrix = indexOf(pos);
                if (matrix == null) {
                    throw new IllegalArgumentException("matrix not found by position: " + pos);
                }
                matrix.init(pos, squareInit.getRight());
            }
            initialNumbers = inits.length;
        }
    }

    @SafeVarargs
    public static Sudoku of(Pair<Position, Integer>... inits) {
        return new Sudoku(inits);
    }

    public Matrix indexOf(Position position) {
        return positionMatrixMap.get(position);
    }

    public Iterator<Square> squaresIterator() {
        return squares.iterator();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (initialNumbers == 0) {
            for (int i = 0; i < 9; i++) {
                builder.append("?   ?   ?   ?   ?   ?   ?   ?   ?").append(System.lineSeparator());
            }
            return builder.toString();
        }
        String format = "%3s %3s %3s %3s %3s %3s %3s %3s %3s";
        row.forEach((k, v) ->
                builder.append(String.format(format,
                                v.inners().stream().map(square -> square.hasAnswer() ? square.getAnswer() : "?")
                                        .collect(Collectors.toList()).toArray()))
                        .append(System.lineSeparator()));
        return builder.toString();
    }
}
