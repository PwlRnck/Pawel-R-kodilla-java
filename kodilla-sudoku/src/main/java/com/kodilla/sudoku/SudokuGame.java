package com.kodilla.sudoku;

import java.util.*;

public class SudokuGame {

    private SudokuBoard theBoard;
    private SudokuBoard boardCopy;
    private List<GameState> backtrack;
    private Scanner scanner = new Scanner(System.in);

    public SudokuGame() {
        theBoard = new SudokuBoard();
        backtrack = new ArrayList<>();
    }

    public String[] input() {
        System.out.println("\nPlease enter the data:");
        String data = scanner.nextLine();
        String[] dataExtracted;

        if (data.equals("q")) {
            System.exit(0);
        } else if (data.equals("f")) {
            dataExtracted = new String[1];
            dataExtracted[0] = "0";
            return dataExtracted;
        } else {
            data = data.replaceAll("\\D+", ",");
            dataExtracted = data.split("\\D");

            if (dataExtracted.length != 3) {
                System.out.println("The entered values are not correct. Please try again (a) or quit (q)");
                String decision = scanner.nextLine();
                if (decision.equals("a")) {
                    input();
                } else
                    System.exit(0);
            }
            return dataExtracted;
        }
        return null;
    }

    public SudokuBoard inputFile(SudokuBoard theBoard, SudokuGame theGame) {
        FileReader fileReader = new FileReader();

        try {
            List<String> data = fileReader.readFile();
            String[] dataExtracted;
            int counter = 0;
            for(String line:data) {
                counter++;
                line = line.replaceAll("\\D+", ",");
                dataExtracted = line.split("\\D");

                if (dataExtracted.length != 3) {
                    System.out.println("The values in line " + counter + " are not correct. Please correct the file.");
                    System.exit(0);
                } else {
                    theBoard = theGame.fillTheBoard(dataExtracted, theBoard);
                }
            }
        } catch(FileReaderException e) {
            System.out.println("File not found.");
        }
        return theBoard;
    }

    public SudokuBoard fillTheBoard(String[] dataExtracted, SudokuBoard sudokuBoard) {
        int boardX = Integer.parseInt(dataExtracted[0])-1;
        int boardY = Integer.parseInt(dataExtracted[1])-1;
        int boardValue = Integer.parseInt(dataExtracted[2]);

        sudokuBoard.getRows().get(boardX).getElements().get(boardY).setValue(boardValue);
        return sudokuBoard;
    }

    public SudokuBoard getBoard() {
        return theBoard;
    }

    public boolean resolveSudoku() {
        SudokuElement element;
        int eventCounter;
        int errorCode;
        int iterationCounter = 0;
        int backtrackIndex;
        int backtrackXCoord;
        int backtrackYCoord;
        int valueToRemove;

           do {
               eventCounter = 0;
               errorCode = 0;
               try {
                   boardCopy = theBoard.deepCopy();
               } catch(CloneNotSupportedException e) {
               }

               for (int i = 0; i < 9; i++) {
                   for (int j = 0; j < 9; j++) {
                       Set<Integer> filledInNumbers = new HashSet<>();
                       Set<Integer> availableNumbers = new HashSet<>();

                       element = theBoard.getRows().get(i).getElements().get(j);

                       if (element.getValue() > 0) {
                           continue;
                       } else {
                           checkNumbers(i, j, theBoard.getBlocks()[i / 3][j / 3], filledInNumbers, availableNumbers);
                       }

                       for (Integer number : filledInNumbers) {
                           theBoard.getRows().get(i).getElements().get(j).getValueSet().remove(number);
                       }

                       if(theBoard.getRows().get(i).getElements().get(j).getValueSet().size() == 0) {
                           errorCode = 1;
                           break;
                       }

                       if (theBoard.getRows().get(i).getElements().get(j).getValueSet().size() == 1) {
                           theBoard.getRows().get(i).getElements().get(j)
                                   .setValue(theBoard.getRows().get(i).getElements().get(j)
                                           .getValueSet().iterator().next());
                           theBoard.getRows().get(i).getElements().get(j).getValueSet()
                                   .remove(theBoard.getRows().get(i).getElements().get(j).getValueSet().iterator().next());
                           eventCounter++;
                       } else {
                           for (Integer number : theBoard.getRows().get(i).getElements().get(j).getValueSet()) {
                               if (!availableNumbers.contains(number)) {
                                   theBoard.getRows().get(i).getElements().get(j)
                                           .setValue(number);
                                   theBoard.getRows().get(i).getElements().get(j).getValueSet()
                                           .remove(number);
                                   eventCounter++;
                                   break;
                               }
                           }
                       }
                   }
               }
               if(errorCode == 1) {
                   if(backtrack.size() > 0) {
                       backtrackIndex = backtrack.size()-1;
                       backtrackXCoord = backtrack.get(backtrackIndex).getxCoordinate();
                       backtrackYCoord = backtrack.get(backtrackIndex).getyCoordinate();
                       valueToRemove = backtrack.get(backtrackIndex).getValue();
                       theBoard = backtrack.get(backtrackIndex).getTheBoard();
                       theBoard.getRows().get(backtrackXCoord).getElements().get(backtrackYCoord).getValueSet().remove(valueToRemove);
                       eventCounter = 1;
                   } else {
                       System.out.println("This sudoku has a fatal error and cannot be solved.");
                       return finalQuestion();
                   }
               } else if(eventCounter == 0 && theBoard.countEmpty() > 0) {
                   int initialCount = theBoard.countEmpty();
                   theBoard = randomFill(theBoard);
                   if(theBoard.countEmpty() < initialCount) {
                       eventCounter = 1;
                   } else {
                       eventCounter = 0;
                   }
               }
                iterationCounter++;
           } while (eventCounter > 0 && theBoard.countEmpty() > 0);
        System.out.println("\nThis is the solution reached after " + iterationCounter + " iterations:\n" + theBoard.toString());
        return finalQuestion();
    }

    private boolean finalQuestion() {
        System.out.println("\nWould you like to play again? (y/n)");
        String answer = scanner.nextLine();
        if(answer.equals("y")) {
            return false;
        } else {
            return true;
        }
    }

    private void checkNumbers(int i, int j, SudokuBoard.Block block, Set<Integer> filledInNumbers, Set<Integer> availableNumbers ) {
        for(int k = 0; k < 9; k++) {
            filledInNumbers.add(theBoard.getRows().get(i).getElements().get(k).getValue());
            filledInNumbers.add(theBoard.getRows().get(k).getElements().get(j).getValue());
            filledInNumbers.add(theBoard.getRows().get(block.getCoordinates().get(k).get(0))
                    .getElements().get(block.getCoordinates().get(k).get(1)).getValue());

            availableNumbers.addAll(theBoard.getRows().get(i).getElements().get(k).getValueSet());
            availableNumbers.addAll(theBoard.getRows().get(k).getElements().get(j).getValueSet());
            availableNumbers.addAll(theBoard.getRows().get(block.getCoordinates().get(k).get(0))
                    .getElements().get(block.getCoordinates().get(k).get(1)).getValueSet());
        }
    }

    private SudokuBoard randomFill(SudokuBoard theBoard) {
        SudokuElement element;
        Random generator = new Random();
        int index;
        int valueToFill = -1;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                element = theBoard.getRows().get(i).getElements().get(j);
                if (element.getValue() > 0) {
                    continue;
                } else {
                    Set<Integer> values = element.getValueSet();
                    if(values.size() == 0) {
                        continue;
                    }
                    Iterator<Integer> valuesIterator = values.iterator();
                    index = generator.nextInt(values.size());
                    for (int k = 0; k <= index; k++) {
                        valueToFill = valuesIterator.next();
                    }
                    try {
                        backtrack.add(new GameState(boardCopy.deepCopy(), i, j, valueToFill));
                    } catch(CloneNotSupportedException e) {
                    }

                    theBoard.getRows().get(i).getElements().get(j).setValue(valueToFill);
                    theBoard.getRows().get(i).getElements().get(j).getValueSet()
                            .remove(valueToFill);
                    return theBoard;
                }
            }
        }
        return theBoard;
    }
}