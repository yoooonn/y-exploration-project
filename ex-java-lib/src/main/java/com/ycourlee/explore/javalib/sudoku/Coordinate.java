package com.ycourlee.explore.javalib.sudoku;

import com.ycourlee.tranquil.core.util.Assert;
import lombok.Getter;

/**
 * @author yongjiang
 * @date 2022.03.26
 */
@Getter
public class Coordinate {

    private int r;

    private int c;

    private Coordinate() {
    }

    public static Coordinate of(int r, int c) {
        Assert.that(1 <= r && r <= 9);
        Assert.that(1 <= c && c <= 9);
        Coordinate coordinate = new Coordinate();
        coordinate.r = r;
        coordinate.c = c;
        return coordinate;
    }

    @Override
    public String toString() {
        return "(" + r + ", " + c + ")";
    }
}
