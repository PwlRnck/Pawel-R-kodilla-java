package com.kodilla.rps;

import java.util.HashMap;
import java.util.Map;

public class Game {
    private Score score;
    private InputData inputData;
    private Dialogue dialogue;
    public Map<String, String> functionKeys = new HashMap<>();

    public Game(InputData inputData, Score score) {
        functionKeys.put(FunctionKeys.STONE.key(), FunctionKeys.STONE.keyFunction());
        functionKeys.put(FunctionKeys.PAPER.key(), FunctionKeys.PAPER.keyFunction());
        functionKeys.put(FunctionKeys.SCISSORS.key(), FunctionKeys.SCISSORS.keyFunction());
        functionKeys.put(FunctionKeys.END.key(), FunctionKeys.END.keyFunction());
        functionKeys.put(FunctionKeys.NEW.key(), FunctionKeys.NEW.keyFunction());
        this.inputData = inputData;
        this.score = score;
        dialogue = new Dialogue(inputData);
    }

    public void play() {
        int numberOfRounds = inputData.getNumberOfRounds();
        int roundNumber = Math.max(score.getScorePlayer(), score.getScoreComputer());

        while (roundNumber < numberOfRounds) {
            playARound();
            roundNumber = Math.max(score.getScorePlayer(), score.getScoreComputer());
        }

        String decision = dialogue.finalDialogue();

        if (decision.equals(FunctionKeys.NEW.key())) {
                RpsRunner.main(null);
        } else {
                dialogue.quit();
        }
    }

    public void playARound() {
        Print print = new Print();
        String movePlayer = "";

        String movePlayerCode = dialogue.makeAMoveDialogue();
        movePlayerCode = quitConfirmation(movePlayerCode);

        try {
            movePlayer = inputData.getMove(movePlayerCode, functionKeys);
        } catch (WrongFunctionKeyException e) {
            System.out.println(e);
            play();
        }

        int moveComputerCode = dialogue.computerMove(movePlayerCode);
        String moveComputer = functionKeys.get(Integer.toString(moveComputerCode));
        print.printResult(movePlayer, moveComputer, this);
   }

    private String quitConfirmation(String movePlayerCode) {

        while(movePlayerCode.equals(FunctionKeys.END.key()) || movePlayerCode.equals(FunctionKeys.NEW.key())) {
            if (movePlayerCode.equals(FunctionKeys.END.key()))
                movePlayerCode = dialogue.quitDialogue();
            else
                movePlayerCode = dialogue.restartDialogue();
        }
        return movePlayerCode;
    }

    public void info() {
        System.out.println("\nHere is the list of keys associated with the game's options:");
        functionKeys.entrySet().stream()
                .map(e -> e.getKey() + ": " + e.getValue())
                .forEach(System.out::println);
    }

    public Score getScore() {
        return score;
    }

    public InputData getInputData() {
        return inputData;
    }

    public void setDialogue(Dialogue dialogue) {
        this.dialogue = dialogue;
    }
}