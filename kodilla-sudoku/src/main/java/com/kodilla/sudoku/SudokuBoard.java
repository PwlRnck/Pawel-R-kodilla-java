package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SudokuBoard extends Prototype {
    List<SudokuRow> rows;
    private Block[][] blocks;

    public SudokuBoard() {
        rows = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
            rows.add(new SudokuRow());
        }

        blocks = new Block[3][3];
        for(int i = 0; i <3; i++) {
            for (int j = 0; j < 3; j++) {
                blocks[i][j] = new Block(i,j);
            }
        }
    }

    public int countEmpty() {
        int c = 0;
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(getRows().get(i).getElements().get(j).getValue() < 0) {
                    c++;
                }
            }
        }
        return c;
    }

    public SudokuBoard deepCopy() throws CloneNotSupportedException {
        SudokuBoard clonedBoard = (SudokuBoard)super.clone();
        clonedBoard.rows = new ArrayList<>( );

        for(SudokuRow row : rows) {
            SudokuRow clonedRow = new SudokuRow();
            clonedRow.elements= new ArrayList<>();

            for(SudokuElement element : row.getElements()) {
                SudokuElement clonedElement = new SudokuElement();
                clonedElement.setValue(element.getValue());
                clonedElement.valueSet = new HashSet<>();

                for(Integer value : element.getValueSet()) {
                    clonedElement.getValueSet().add(value);
                }
                clonedRow.getElements().add(clonedElement);
            }
            clonedBoard.getRows().add(clonedRow);
        }
        return clonedBoard;
    }


    public List<SudokuRow> getRows() {
        return rows;
    }

    public Block[][] getBlocks() {
        return blocks;
    }

    class Block {
        private List<List<Integer>> coordinates = new ArrayList<>();

        public Block(int x, int y) {
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(3*x + i);
                    pair.add(3*y + j);
                    coordinates.add(pair);
                }
            }
        }

        public List<List<Integer>> getCoordinates() {
            return coordinates;
        }
    }

    public String toString() {
        String output = "";

        for(int i = 0; i < 9; i++) {
            output = output + "\n";
            if(i > 0) {
                if(i % 3 == 0) {
                    output = output + "===|===|===||===|===|===||===|===|===\n";
                } else {
                    output = output + "---|---|---||---|---|---||---|---|---\n";
                }
            }
            for (int j = 0; j < 9; j++) {
                if(rows.get(i).getElements().get(j).getValue()>0) {
                    if(j < 8) {
                        if((j + 1) % 3 == 0) {
                            output = output + " " + rows.get(i).getElements().get(j).getValue() + " ||";
                        } else {

                            output = output + " " + rows.get(i).getElements().get(j).getValue() + " |";
                        }
                    } else {
                        output = output + " " + rows.get(i).getElements().get(j).getValue();
                    }
                } else {
                    if(j < 8) {
                        if((j + 1) % 3 == 0) {
                            output = output + "   ||";
                        } else {
                            output = output + "   |";
                        }
                    }
                }
            }
        }
        return output;
    }
}