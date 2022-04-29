package com.ycourlee.explore.java8.model.sudoku;

import lombok.Getter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 3*3方格矩阵
 *
 * @author yongjiang
 * @date 2022.03.04
 */
@Getter
public class Matrix {

    /**
     * 该3*3方格中坐标位置对应的square
     */
    private Map<Position, Square> positionSquareMap = new LinkedHashMap<>(9);

    /**
     * 该3*3方格的方格
     */
    private RestrictSquares squares = new RestrictSquares();

    /**
     * 行，方格
     */
    private Map<Integer, List<Square>> row = new LinkedHashMap<>(3);

    /**
     * 列，方格
     */
    private Map<Integer, List<Square>> col = new LinkedHashMap<>(3);

    public Matrix() {
    }

    public static Matrix of(int x, int y) {
        Matrix matrix = new Matrix();
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                Square square = Square.of(i, j);
                List<Square> rowSquares = matrix.row.getOrDefault(i, new ArrayList<>(3));
                List<Square> colSquares = matrix.col.getOrDefault(j, new ArrayList<>(3));

                rowSquares.add(square);
                colSquares.add(square);

                matrix.row.put(i, rowSquares);
                matrix.col.put(j, colSquares);
                matrix.squares.inners().add(square);
                matrix.positionSquareMap.put(Position.of(i, j), square);
            }
        }
        return matrix;
    }

    public void init(Position position, Integer number) {
        positionSquareMap.get(position).answer(number);
    }

    @Override
    public String toString() {
        final String format = "%3s %3s %3s";

        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Integer, List<Square>> entry : row.entrySet()) {
            List<Square> squares = entry.getValue();
            Integer number1 = squares.get(0).getAnswer();
            Integer number2 = squares.get(1).getAnswer();
            Integer number3 = squares.get(2).getAnswer();
            Object[] numbers = new Object[3];
            numbers[0] = number1 == null ? "?" : number1.toString();
            numbers[1] = number2 == null ? "?" : number2.toString();
            numbers[2] = number3 == null ? "?" : number3.toString();
            builder.append(String.format(format, numbers)).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
