package top.yooonn.explore.javalib.sudoku;

import com.ycourlee.tranquil.core.util.Assert;
import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author yooonn
 * @date 2022.03.26
 */
@Getter
public class Coordinate implements Serializable {

    private static final long serialVersionUID = -5707507626534313174L;

    private int r;

    private int c;

    private Coordinate() {
    }

    public static Coordinate of(int r, int c) {
        Assert.that(1 <= r && r <= 9, String.valueOf(r));
        Assert.that(1 <= c && c <= 9, String.valueOf(r));
        Coordinate coordinate = new Coordinate();
        coordinate.r = r;
        coordinate.c = c;
        return coordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Coordinate that = (Coordinate) o;
        return r == that.r && c == that.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(r, c);
    }

    @Override
    public String toString() {
        return "(" + r + ", " + c + ")";
    }
}
