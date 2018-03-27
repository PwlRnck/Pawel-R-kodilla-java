package com.kodilla.rps;

public class Print {

    public void printResult(String movePlayer, String moveComputer, Game game) {
        System.out.println("\nYour move: " + movePlayer + ". | Computer's move: " + moveComputer + ".");

        printRoundResult(movePlayer, moveComputer, game);
        printCurrentResult(game);
    }

    private void printRoundResult(String movePlayer, String moveComputer, Game game) {
        Score score = game.getScore();
        int scorePlayer = score.getScorePlayer();
        int scoreComputer = score.getScoreComputer();
        String name = game.getInputData().getName();

        if(score.evaluate(movePlayer,moveComputer) == 1) {
            System.out.println("\n" + name + ", you won this round!");
            score.setScorePlayer(scorePlayer + 1);
        } else if(score.evaluate(moveComputer,movePlayer) == 1) {
            System.out.println("\n" + name + ", you lost this round.");
            score.setScoreComputer(scoreComputer + 1);
        } else {
            System.out.println("This round ended in a draw.");
        }
    }

    private void printCurrentResult(Game game) {
        int scorePlayer = game.getScore().getScorePlayer();
        int scoreComputer = game.getScore().getScoreComputer();
        int roundNumber = Math.max(scorePlayer,scoreComputer);
        int numberOfRounds = game.getInputData().getNumberOfRounds();
        String name = game.getInputData().getName();

        if(roundNumber == numberOfRounds) {
            System.out.println("\nThe final result is:");
            System.out.println(name + "-Computer   " + scorePlayer + ":" + scoreComputer);
            if(scorePlayer>scoreComputer) {
                System.out.println("\n" + name + ", you won this game! Congrats!!!");
            } else {
                System.out.println("\n" + name + ", unfortunately this time you lost. Have another try.");
            }
        } else {
            System.out.println("\nThe current result is:");
            System.out.println(name + "-Computer   " + scorePlayer + ":" + scoreComputer);
        }
    }
}
