package com.kodilla.good.patterns.challenges.flights;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FlightSchedule {
    private List<Flight> flightSchedule = new ArrayList<>();


    public void add(Flight flight){
        flightSchedule.add(flight);
    }

    public List<Flight> getFlightSchedule() {
        return flightSchedule;
    }

    public void searchFlightsByDepAirport(String depAirport, int year, int month, int day, int hour, int mins){
        AtomicInteger counter = new AtomicInteger();
        flightSchedule.stream().filter(f -> f.getDepAirport() == depAirport)
                               .map(f -> "Option no. " + counter.incrementAndGet() + ": Departure Airport: " + depAirport + ", Arrival Airport: "
                                                        + f.getArrAirport() + ", Departure date: " + f.nearestFlightDep(year,month,day,hour,mins)
                                                        + ", Arrival Date: " + f.nearestFlightArr(year,month,day,hour,mins))
                               .forEach(System.out::println);
    }

    public void searchFlightsByArrAirport(String depAirport, String arrAirport, boolean onlyDirect, int year, int month, int day, int hour, int mins){
        AtomicInteger counter = new AtomicInteger();
        if(onlyDirect) {
            flightSchedule.stream().filter(f -> (f.getDepAirport() == depAirport) && (f.getArrAirport() == arrAirport))
                                   .map(f -> "DIRECT FLIGHTS\nOption no. " + counter.incrementAndGet() + ": Departure Airport: " + depAirport + ", Arrival Airport: "
                                                           + f.getArrAirport() + ", Departure date: " + f.nearestFlightDep(year, month, day, hour, mins)
                                                           + ", Arrival Date: " + f.nearestFlightArr(year, month, day, hour, mins))
                                   .forEach(System.out::println);
        } else {
            flightSchedule.stream().filter(f -> (f.getDepAirport() == depAirport) && (f.getArrAirport() == arrAirport))
                    .map(f -> "DIRECT FLIGHT\nOption no. " + counter.incrementAndGet() + ": Departure Airport: " + depAirport + ", Arrival Airport: "
                            + f.getArrAirport() + ", Departure date: " + f.nearestFlightDep(year, month, day, hour, mins)
                            + ", Arrival Date: " + f.nearestFlightArr(year, month, day, hour, mins))
                    .forEach(System.out::println);

            flightSchedule.stream().filter(f -> (f.getDepAirport() == depAirport))
                    .map(f -> f.getArrAirport())
                    .filter(a -> flightSchedule.stream().filter(f -> (f.getDepAirport() == a) && (f.getArrAirport() == arrAirport)).count()>0)
                    .distinct()
                    .flatMap(a -> flightSchedule.stream().filter(f -> ((f.getDepAirport() == a) && (f.getArrAirport() == arrAirport))))
                    .flatMap(f -> flightSchedule.stream().filter(g -> (g.getDepAirport() == depAirport) && (g.getArrAirport() == f.getDepAirport())))
                    .map(f -> "\nTRANSFER FLIGHT\nOption no. " + counter.incrementAndGet() + ":\nDeparture Airport: " + depAirport + ", Arrival Airport: "
                            + f.getArrAirport() + ", Departure date: " + f.nearestFlightDep(year,month,day,hour,mins)
                            + ", Arrival Date: " + f.nearestFlightArr(year,month,day,hour,mins)
                            + ":\n(transfer)\nDeparture Airport: " + f.getArrAirport() + ", Arrival Airport: "
                            + arrAirport + ", Departure date: "
                            + flightSchedule.stream().filter(g -> (g.getDepAirport() == f.getArrAirport()) && (g.getArrAirport() == arrAirport))
                            .map(g -> g.nearestFlightDep(f.nearestFlightArr(year,month,day,hour,mins)))
                            .min(LocalDateTime::compareTo)
                            + ", Arrival Date: "
                            + flightSchedule.stream().filter(g -> (g.getDepAirport() == f.getArrAirport()) && (g.getArrAirport() == arrAirport))
                            .map(g -> g.nearestFlightArr(f.nearestFlightArr(year,month,day,hour,mins)))
                            .min(LocalDateTime::compareTo))
                    .forEach(System.out::println);
        }
    }
}
