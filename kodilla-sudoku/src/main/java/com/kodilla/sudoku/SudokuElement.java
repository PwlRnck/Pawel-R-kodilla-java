package com.kodilla.sudoku;

import java.util.HashSet;
import java.util.Set;

public class SudokuElement {
    private int value;
    Set<Integer> valueSet;
    public static int EMPTY = -1;

    public SudokuElement() {
        value = EMPTY;
        valueSet = new HashSet<>();
        for(int i = 1; i <= 9; i++) {
            valueSet.add(i);
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Set<Integer> getValueSet() {
        return valueSet;
    }

}
