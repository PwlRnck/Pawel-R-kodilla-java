package com.kodilla.rps;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private String movePlayerCode;
    private String movePlayer;
    private int moveComputerCode;
    private String moveComputer;
    private int roundNumber;
    private int scorePlayer;
    private int scoreComputer;
    private String decision;
    private InputData inputData;
    private int numberOfRounds;
    private String name;
    public Map<String, String> functionKeys = new HashMap<>();

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    public Game() {
        functionKeys.put(FunctionKeys.STONE.key(), FunctionKeys.STONE.keyFunction());
        functionKeys.put(FunctionKeys.PAPER.key(), FunctionKeys.PAPER.keyFunction());
        functionKeys.put(FunctionKeys.SCISSORS.key(), FunctionKeys.SCISSORS.keyFunction());
        functionKeys.put(FunctionKeys.END.key(), FunctionKeys.END.keyFunction());
        functionKeys.put(FunctionKeys.NEW.key(), FunctionKeys.NEW.keyFunction());
        scorePlayer = 0;
        scoreComputer = 0;
    }

    public void play(InputData inputData, int scorePlayer, int scoreComputer) {

        this.scorePlayer = scorePlayer;
        this.scoreComputer = scoreComputer;
        this.inputData = inputData;
        numberOfRounds = inputData.getNumberOfRounds();
        name = inputData.getName();
        roundNumber = Math.max(scorePlayer, scoreComputer);

        while (roundNumber < numberOfRounds) {
            playARound();
        }

        System.out.println("\nWould you like to play another game (" + FunctionKeys.NEW.key() + ") or quit the game (" + FunctionKeys.END.key() + ")?");
        decision = scanner.nextLine().toString();

        if (decision.equals(FunctionKeys.NEW.key())) {
                RpsRunner.main(null);
        } else {
                quit();
        }
    }

    private void playARound() {

        System.out.println("\n" + name + ", please make a move.");

        movePlayerCode = scanner.nextLine().toString();
        quitConfirmation(movePlayerCode);

        try {
            getMove(movePlayerCode);
        } catch (WrongFunctionKeyException e) {
            System.out.println(e);
            play(this.inputData,this.scorePlayer,this.scoreComputer);
        }

        //fair play case
        //moveComputerCode = random.nextInt(3) + 1;

        //foul play case
        int[] options = {
                Integer.parseInt(movePlayerCode),
                Integer.parseInt(movePlayerCode) + 1 <= 3 ? Integer.parseInt(movePlayerCode) + 1 : 1,
                Integer.parseInt(movePlayerCode) + 1 <= 3 ? Integer.parseInt(movePlayerCode) + 1 : 1,
                Integer.parseInt(movePlayerCode) + 2 > 3 ? Integer.parseInt(movePlayerCode) - 1 : 1
        };
        moveComputerCode = options[random.nextInt(4)];

        //all cases
        moveComputer = functionKeys.get(Integer.toString(moveComputerCode));
        printResults(movePlayer, moveComputer, this.scorePlayer, this.scoreComputer);

    }


    private int score(String resultA, String resultB) {
        if(resultA.equals(FunctionKeys.SCISSORS.keyFunction()) && resultB.equals(FunctionKeys.PAPER.keyFunction()))
                 return 1;
        if(resultA.equals(FunctionKeys.PAPER.keyFunction()) && resultB.equals(FunctionKeys.STONE.keyFunction()))
            return 1;
        if(resultA.equals(FunctionKeys.STONE.keyFunction()) && resultB.equals(FunctionKeys.SCISSORS.keyFunction()))
            return 1;
        return 0;
    }

    private String quitConfirmation(String movePlayerCode) {

        while(movePlayerCode.equals(FunctionKeys.END.key()) || movePlayerCode.equals(FunctionKeys.NEW.key())) {
            if (movePlayerCode.equals(FunctionKeys.END.key())) {
                System.out.println(name + ", do you really want to quit (y/n)?");
                movePlayerCode = scanner.nextLine().toString();
                if (movePlayerCode.equals(FunctionKeys.NEW.key())) {
                    System.out.println("\n" + name + ", please make a move.");
                    movePlayerCode = scanner.nextLine();
                } else {
                    quit();
                }
            } else {
                System.out.println(name + ", do you really want to restart the game (y/n)?");
                movePlayerCode = scanner.nextLine().toString();
                if (movePlayerCode.equals(FunctionKeys.NEW.key())) {
                    System.out.println("\n" + name + ", please make a move.");
                    movePlayerCode = scanner.nextLine();
                } else {
                    RpsRunner.main(null);
                }
            }
        }
        return movePlayerCode;
    }

    private String getMove(String movePlayerCode) throws WrongFunctionKeyException {
            movePlayer = functionKeys.get(movePlayerCode);
            if(movePlayer!=null) {
                return movePlayer;
            }
            throw new WrongFunctionKeyException("The key \"" + movePlayerCode + "\" is not a valid function key. Please try again.");
    }

    private void printResults(String movePlayer, String moveComputer, int scorePlayer, int scoreComputer) {

            System.out.println("\nYour move: " + movePlayer + ". | Computer's move: " + moveComputer + ".");

            this.scorePlayer = scorePlayer;
            this.scoreComputer = scoreComputer;

            printRoundResult();
            roundNumber = Math.max(this.scorePlayer,this.scoreComputer);
            printCurrentResult();
    }

    private void printRoundResult() {
        if(score(movePlayer,moveComputer) == 1) {
            System.out.println("\n" + name + ", you won this round!");
            this.scorePlayer++;
        } else if(score(moveComputer,movePlayer) == 1) {
            System.out.println("\n" + name + ", you lost this round.");
            this.scoreComputer++;
        } else {
            System.out.println("This round ended in a draw.");
        }
    }

    private void printCurrentResult() {
        if(roundNumber == numberOfRounds) {
            System.out.println("\nThe final result is:");
            System.out.println(name + "-Computer   " + this.scorePlayer + ":" + this.scoreComputer);
            if(this.scorePlayer>this.scoreComputer) {
                System.out.println("\n" + name + ", you won this game! Congrats!!!");
            } else {
                System.out.println("\n" + name + ", unfortunately this time you lost. Have another try.");
            }
        } else {
            System.out.println("\nThe current result is:");
            System.out.println(name + "-Computer   " + this.scorePlayer + ":" + this.scoreComputer);

        }
    }

    private void quit() {
        System.out.println("Thank you " + name + " for playing the game.");
        System.exit(0);
    }

    public void info() {
        System.out.println("\nHere is the list of keys associated with the game's options:");
        functionKeys.entrySet().stream()
                .map(e -> e.getKey() + ": " + e.getValue())
                .forEach(System.out::println);
    }
}