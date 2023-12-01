package top.yooonn.explore.java8.model.sudoku;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yooonn
 * @date 2022.03.04
 */
public class RestrictSquares {

    private List<Square> inners = new ArrayList<>(9);

    public RestrictSquares() {
    }

    public RestrictSquares(List<Square> inners) {
        this.inners = inners;
    }

    public boolean restrict() {
        List<Integer> answers = inners.stream().filter(Square::hasAnswer).map(Square::getAnswer).collect(Collectors.toList());

        return false;
    }

    public List<Square> inners() {
        return inners;
    }

    public Iterator<Square> iterator() {
        return inners.iterator();
    }
}
