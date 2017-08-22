package com.kodilla.good.patterns.challenges.flights;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class UserInterface {
    public void userInterface(SampleData sampleData, String searchMode){
        FlightSchedule flightSchedule = sampleData.getFlightSchedule();
        /*
        Scanner userInput = new Scanner(System.in);
        String depAirport;
        String arrAirport;
        boolean onlyDirect;
        int year; int month; int day; int hour; int mins;
        */
        String depAirport = "Warsaw";
        String arrAirport = "Gdansk";
        boolean onlyDirect = false;
        int year = 2017; int month = 8; int day = 23; int hour = 12; int mins = 0;

        if(searchMode.toLowerCase().substring(0,1).equals("a")) {

            /*
            System.out.print("Please select your departure airport (Warsaw,Wroclaw,Poznan,Gdansk): ");
            depAirport = userInput.next();
            System.out.print("\nPlease input the desired time of departure.\nYear: ");
            year = userInput.nextInt();
            System.out.print("\nMonth: ");
            month = userInput.nextInt();
            System.out.print("\nDay: ");
            day = userInput.nextInt();
            System.out.print("\nHour: ");
            hour = userInput.nextInt();
            System.out.print("\nMinutes: ");
            mins = userInput.nextInt();
            */
            flightSchedule.searchFlightsByDepAirport(depAirport,year,month,day,hour,mins);

        } else if(searchMode.toLowerCase().substring(0,1).equals("b")) {
            /*
            System.out.print("Please select your departure airport (Warsaw,Wroclaw,Poznan,Gdansk): ");
            depAirport = userInput.next();
            System.out.print("\nPlease select your arrival airport (Warsaw,Wroclaw,Poznan,Gdansk): ");
            arrAirport = userInput.next();
            System.out.print("\nSearch only direct flights?(y/n): ");
            if(userInput.next().toLowerCase().substring(0,1).equals("y")) {
                onlyDirect = true;
            } else {
                onlyDirect = false;
            }
            System.out.print("\nPlease input the desired time of departure.\nYear: ");
            year = userInput.nextInt();
            System.out.print("\nMonth: ");
            month = userInput.nextInt();
            System.out.print("\nDay: ");
            day = userInput.nextInt();
            System.out.print("\nHour: ");
            hour = userInput.nextInt();
            System.out.print("\nMinutes: ");
            mins = userInput.nextInt();
            */
            flightSchedule.searchFlightsByArrAirport(depAirport,arrAirport,onlyDirect,year,month,day,hour,mins);
        }
    }
}
