package com.kodilla.good.patterns.challenges.flights;

import java.time.*;

import static java.time.temporal.TemporalAdjusters.next;
import static java.time.temporal.TemporalAdjusters.nextOrSame;

public class Flight {
    private String depAirport;
    private String arrAirport;
    private LocalTime depTime;
    private DayOfWeek depDayOfWeek;
    private LocalTime arrTime;
    private DayOfWeek arrDayOfWeek;
    private static int flightNumber;


    public Flight(String depAirport, String arrAirport, int depHour, int depMins, int depDayOfWeek, int arrHour, int arrMins, int arrDayOfWeek) {
        this.depAirport = depAirport;
        this.arrAirport = arrAirport;
        this.depTime = LocalTime.of(depHour, depMins);
        this.depDayOfWeek = DayOfWeek.of(depDayOfWeek);
        this.arrTime = LocalTime.of(arrHour, arrMins);
        this.arrDayOfWeek = DayOfWeek.of(arrDayOfWeek);
        flightNumber += 1;

    }

    public String getDepAirport() {
        return depAirport;
    }

    public String getArrAirport() {
        return arrAirport;
    }

    public LocalTime getDepTime() {
        return depTime;
    }

    public DayOfWeek getDepDayOfWeek() {
        return depDayOfWeek;
    }

    public LocalTime getArrTime() {
        return arrTime;
    }

    public DayOfWeek getArrDayOfWeek() {
        return arrDayOfWeek;
    }

    public static int getFlightNumber() {
        return flightNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (!depAirport.equals(flight.depAirport)) return false;
        if (!arrAirport.equals(flight.arrAirport)) return false;
        if (!depTime.equals(flight.depTime)) return false;
        return depDayOfWeek == flight.depDayOfWeek;
    }

    @Override
    public int hashCode() {
        int result = depAirport.hashCode();
        result = 31 * result + arrAirport.hashCode();
        return result;
    }

    public LocalDateTime nearestFlightDep(int year, int month, int day, int hour, int mins) {
        LocalDateTime timeRef = LocalDateTime.of(year, month, day, hour, mins);
        LocalDate nextFlightDate = timeRef.toLocalDate().with(nextOrSame(depDayOfWeek));
        LocalDateTime nextFlightDateTime = nextFlightDate.atTime(depTime);

        if (nextFlightDateTime.isAfter(timeRef)) {
            return nextFlightDateTime;
        } else {
            nextFlightDate = timeRef.toLocalDate().with(next(depDayOfWeek));
            nextFlightDateTime = nextFlightDate.atTime(depTime);
            return nextFlightDateTime;
        }
    }

    public LocalDateTime nearestFlightArr(int year, int month, int day, int hour, int mins) {
        LocalDateTime timeRef = nearestFlightDep(year, month, day, hour, mins);
        LocalDate nextFlightDate = timeRef.toLocalDate().with(nextOrSame(arrDayOfWeek));
        LocalDateTime nextFlightDateTime = nextFlightDate.atTime(arrTime);

        if (nextFlightDateTime.isAfter(timeRef)) {
            return nextFlightDateTime;
        } else {
            nextFlightDate = timeRef.toLocalDate().with(next(arrDayOfWeek));
            nextFlightDateTime = nextFlightDate.atTime(arrTime);
            return nextFlightDateTime;
        }
    }

    public LocalDateTime nearestFlightDep(LocalDateTime timeRef) {

        LocalDate nextFlightDate = timeRef.toLocalDate().with(nextOrSame(depDayOfWeek));
        LocalDateTime nextFlightDateTime = nextFlightDate.atTime(depTime);

        if (nextFlightDateTime.isAfter(timeRef)) {
            return nextFlightDateTime;
        } else {
            nextFlightDate = timeRef.toLocalDate().with(next(depDayOfWeek));
            nextFlightDateTime = nextFlightDate.atTime(depTime);
            return nextFlightDateTime;
        }
    }

    public LocalDateTime nearestFlightArr(LocalDateTime timeRef) {

        LocalDate nextFlightDate = timeRef.toLocalDate().with(nextOrSame(arrDayOfWeek));
        LocalDateTime nextFlightDateTime = nextFlightDate.atTime(arrTime);

        if (nextFlightDateTime.isAfter(timeRef)) {
            return nextFlightDateTime;
        } else {
            nextFlightDate = timeRef.toLocalDate().with(next(arrDayOfWeek));
            nextFlightDateTime = nextFlightDate.atTime(arrTime);
            return nextFlightDateTime;
        }
    }





}
