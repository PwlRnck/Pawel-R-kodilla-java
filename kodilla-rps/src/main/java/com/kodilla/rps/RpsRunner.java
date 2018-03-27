package com.kodilla.rps;

public class RpsRunner {

    public static void main(String[] args) {

        InputData inputData = new InputData();
        inputData.input();

        Game game = new Game(inputData, new Score(0,0));
        game.info();
        game.play();
    }
}
