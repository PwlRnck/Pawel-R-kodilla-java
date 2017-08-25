package com.kodilla.good.patterns.challenges.flights;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        String again = "y";
        SampleData sampleData = new SampleData();
        UserInterface userInterface = new UserInterface();

        while(again.equals("y")) {
            System.out.println("Welcome to our flight search tool. Please select the search mode:" +
                            " \na - search all flights from a given departure airport or" +
                            "\nb - search flights from a given departure airport to a specified arrival airport.");

            String searchMode = userInput.next();
            userInterface.userInterface(sampleData,searchMode);
            System.out.println("\nThank you for using our tool. Would you like to make another query?(y/n)");
            again = userInput.next().toLowerCase().substring(0,1);
        }
        System.out.println("\nThank you for using our tool. We look forward to seeing you soon again");
    }
}
