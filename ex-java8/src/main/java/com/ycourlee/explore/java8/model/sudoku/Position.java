package com.ycourlee.explore.java8.model.sudoku;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * @author yongjiang
 * @date 2022.03.04
 */
@Getter
@Setter
public class Position {

    private Integer r;

    private Integer c;

    public Position(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public static Position of(int r, int c) {
        return new Position(r, c);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Position) {
            final Position other = (Position) obj;
            return Objects.equals(getR(), other.getR())
                    && Objects.equals(getC(), other.getC());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getR(), getC());
    }

    @Override
    public String toString() {
        return "(" + r + ", " + c + ")";
    }
}
