package com.kodilla.good.patterns.challenges.flights;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class FlightSchedule {
    private List<Flight> flightSchedule = new ArrayList<>();


    public void add(Flight flight){
        flightSchedule.add(flight);
    }

    public List<Flight> getFlightSchedule() {
        return flightSchedule;
    }

    private String directFlightInfo(Flight flight, String depAirport, int year, int month, int day, int hour, int mins) {
        return ":\nDeparture Airport: " + depAirport
                + ", Arrival Airport: " + flight.getArrAirport()
                + ", Departure date: " + flight.nearestFlightDep(year,month,day,hour,mins)
                + ", Arrival Date: " + flight.nearestFlightArr(year,month,day,hour,mins);
    }

    private String transferFlightInfo(Flight flight, String arrAirport, int year, int month, int day, int hour, int mins) {
        return "\nDeparture Airport: " + flight.getArrAirport() + ", Arrival Airport: " + arrAirport
                + ", Departure date: "
                + flightSchedule.stream()
                                .filter(g -> (g.getDepAirport().equals(flight.getArrAirport())) && (g.getArrAirport().equals(arrAirport)))
                                .map(g -> g.nearestFlightDep(flight.nearestFlightArr(year, month, day, hour, mins)))
                                .min(LocalDateTime::compareTo)
                + ", Arrival Date: "
                + flightSchedule.stream()
                                .filter(g -> (g.getDepAirport().equals(flight.getArrAirport())) && (g.getArrAirport().equals(arrAirport)))
                                .map(g -> g.nearestFlightArr(flight.nearestFlightArr(year, month, day, hour, mins)))
                                .min(LocalDateTime::compareTo);
    }

    private Stream<Flight> getConnections(String from, String to) {
        return flightSchedule.stream().filter(f -> ((f.getDepAirport().equals(from)) && (f.getArrAirport().equals(to))));
    }

    public void searchFlightsByDepAirport(String depAirport, int year, int month, int day, int hour, int mins) {
        AtomicInteger counter = new AtomicInteger();
        flightSchedule.stream()
                      .filter(f -> f.getDepAirport().equals(depAirport))
                      .map(f -> "Option no. " + counter.incrementAndGet()
                              + directFlightInfo(f, depAirport, year, month, day, hour, mins))
                      .forEach(System.out::println);
        if(counter.get()==0) {
            System.out.println("We are sorry. There are no flights for this query.");
        }
    }

    public void searchFlightsByArrAirport(String depAirport, String arrAirport, boolean onlyDirect, int year, int month, int day, int hour, int mins) {
        AtomicInteger counter = new AtomicInteger();
        if(onlyDirect) {
            flightSchedule.stream()
                          .filter(f -> (f.getDepAirport().equals(depAirport)) && (f.getArrAirport().equals(arrAirport)))
                          .map(f -> "DIRECT FLIGHT\nOption no. " + counter.incrementAndGet()
                                  + directFlightInfo(f, depAirport, year, month, day, hour, mins))
                          .forEach(System.out::println);

            if(counter.get() == 0) {
                System.out.println("We are sorry. There are no flights for this query.");
            }

        } else {
            flightSchedule.stream()
                          .filter(f -> (f.getDepAirport().equals(depAirport)) && (f.getArrAirport().equals(arrAirport)))
                          .map(f -> "DIRECT FLIGHT\nOption no. " + counter.incrementAndGet()
                                     + directFlightInfo(f, depAirport, year, month, day, hour, mins))
                          .forEach(System.out::println);

            flightSchedule.stream()
                          .filter(f -> (f.getDepAirport().equals(depAirport)))
                          .map(f -> f.getArrAirport())
                          .distinct()
                          .flatMap(a -> getConnections(a,arrAirport))
                          .flatMap(f -> getConnections(depAirport,f.getDepAirport()))
                          .map(f -> "\nTRANSFER FLIGHT\nOption no. " + counter.incrementAndGet()
                                    + directFlightInfo(f, depAirport, year, month, day, hour, mins)
                                    + ":\n(transfer)"
                                    + transferFlightInfo(f,arrAirport,year,month,day,hour,mins))
                          .forEach(System.out::println);

            if(counter.get() == 0) {
                System.out.println("We are sorry. There are no flights for this query.");
            }
        }
    }
}