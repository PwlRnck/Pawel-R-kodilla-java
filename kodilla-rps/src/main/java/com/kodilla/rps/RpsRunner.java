package com.kodilla.rps;

public class RpsRunner {

    public static void main(String[] args) {
        InputData inputData = new InputData();
        inputData.input();

        Game game = new Game();
        game.info();
        game.play(inputData,0,0);
    }
}
