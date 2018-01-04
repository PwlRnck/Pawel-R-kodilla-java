package com.kodilla.rps;

import java.util.Scanner;

public class InputData {
    private Scanner scanner = new Scanner(System.in);
    private String name;
    private int numberOfRounds;

    public void input() {
        System.out.println("Hello. Please enter your name:");
        name = scanner.nextLine();
        System.out.println("\n" + name + ", how many rounds is required to win the game?");
        numberOfRounds = scanner.nextInt();
    }

    public String getName() {
        return name;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }
}
