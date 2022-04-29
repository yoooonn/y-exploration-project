package com.ycourlee.explore.java8.model.sudoku;

import lombok.Getter;
import lombok.experimental.Accessors;
import org.springframework.lang.Nullable;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

/**
 * @author yongjiang
 * @date 2022.03.04
 */
@Accessors(chain = true)
public class Square extends Position {

    private final Character mutex = 'L';
    @Getter
    @Nullable
    private volatile Integer answer;
    private volatile boolean unique = false;
    private Collection<Integer> possibleAnswers = new HashSet<>();

    private Square(int x, int y) {
        super(x, y);
    }

    public static Square of(int x, int y) {
        return new Square(x, y);
    }

    public int possibilities() {
        return possibleAnswers.size();
    }

    public void possible(Integer... answers) {
        if (hasAnswer()) {
            throw new IllegalStateException("Already has answer.");
        }
        for (Integer answer : answers) {
            if (!possibleAnswers.contains(answer)) {
                synchronized (mutex) {
                    possibleAnswers.add(answer);
                }
            }
        }
    }

    public void impossible(Integer... answers) {
        impossible(true, answers);
    }

    public void impossible(boolean autoAnswerIfPossible, Integer... answers) {
        for (Integer answer : answers) {
            if (possibleAnswers.contains(answer)) {
                synchronized (mutex) {
                    possibleAnswers.remove(answer);
                }
            }
        }
        int size = possibleAnswers.size();
        if (autoAnswerIfPossible && size == 1) {
            answer(possibleAnswers.stream().findFirst().orElse(null));
        }
    }

    public void answer(Integer answer) {
        if (answer == null) {
            throw new IllegalArgumentException("answer must not be null");
        }
        if (this.answer != null) {
            throw new IllegalStateException(this + " already has answer.");
        }
        synchronized (mutex) {
            this.answer = answer;
            possibleAnswers.clear();
            possibleAnswers.add(answer);
        }
    }

    public boolean hasAnswer() {
        if (unique) {
            return unique;
        }
        if (answer != null) {
            unique = true;
            return unique;
        }
        if (possibleAnswers.size() == 1) {
            answer(possibleAnswers.stream().findFirst().orElse(null));
            return unique;
        }
        return false;
    }

    public void parentMatrixPosition() {

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Square) {
            final Square other = (Square) obj;
            return Objects.equals(getR(), other.getR())
                    && Objects.equals(getC(), other.getC())
                    && Objects.equals(getAnswer(), other.getAnswer());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), answer, unique);
    }

    @Override
    public String toString() {
        return super.toString() + ": " + (hasAnswer() ? answer : possibleAnswers.toString());
    }
}
