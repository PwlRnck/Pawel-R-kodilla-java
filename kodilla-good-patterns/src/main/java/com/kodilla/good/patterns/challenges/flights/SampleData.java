package com.kodilla.good.patterns.challenges.flights;

import java.util.List;

public class SampleData {
    FlightSchedule newFlightSchedule = new FlightSchedule();
    public SampleData() {
        Flight flight1 = new Flight("Warsaw", "Wroclaw", 9, 30, 1,
                11, 0, 1);
        Flight flight2 = new Flight("Warsaw", "Bydgoszcz", 10, 30, 1,
                11, 30, 1);
        Flight flight3 = new Flight("Wroclaw", "Gdansk", 12, 0, 1,
                13, 0, 1);
        Flight flight4 = new Flight("Bydgoszcz", "Gdansk", 12, 30, 1,
                13, 15, 1);
        Flight flight5 = new Flight("Warsaw", "Poznan", 10, 30, 1,
                12, 0, 1);
        Flight flight6 = new Flight("Warsaw", "Wroclaw", 15, 30, 1,
                17, 0, 1);
        Flight flight7 = new Flight("Warsaw", "Gdansk", 16, 0, 1,
                17, 0, 1);

        newFlightSchedule.add(flight1);
        newFlightSchedule.add(flight2);
        newFlightSchedule.add(flight3);
        newFlightSchedule.add(flight4);
        newFlightSchedule.add(flight5);
        newFlightSchedule.add(flight6);
        newFlightSchedule.add(flight7);
    }

    public FlightSchedule getFlightSchedule(){
        return newFlightSchedule;
    }
}
