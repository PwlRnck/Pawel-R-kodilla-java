package com.kodilla.sudoku;

import java.util.Scanner;

public class RunSudoku {

    public static void main(String[] args) {

        boolean gameFinished = false;
        String[] input;
        Scanner scanner = new Scanner(System.in);
        String answer;

        while(!gameFinished) {
            SudokuGame theGame = new SudokuGame();
            SudokuBoard theBoard = theGame.getBoard();

            System.out.println("Hello. How would you like to enter the sudoku data? By keyboard (k) or from file (f)?");
            answer = scanner.nextLine();

            if(answer.equals("k")) {
                System.out.println("Please enter sudoku numbers in the form: \"x,y,z\", where:" +
                        "\nx - number of sudoku board row [1-9];" +
                        "\ny - number of sudoku board column [1-9];" +
                        "\nz - number to be entered to field (x,y) of the board [1-9]." +
                        "\nOr else \"f\" to finish the input and move to solving the sudoku" +
                        "\nor \"q\" if you want to quit");

                do {
                    input = theGame.input();
                    if (!input[0].equals("0")) {
                        theBoard = theGame.fillTheBoard(input, theBoard);
                    }
                    System.out.println(theBoard.toString());
                } while (!input[0].equals("0"));
            } else {
                theBoard = theGame.inputFile(theBoard, theGame);
                System.out.println("\nThis is the initial sudoku board:\n" + theBoard.toString());
            }
            gameFinished = theGame.resolveSudoku();
        }
    }
}
