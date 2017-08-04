package com.kodilla.exception.test;

public class Flight {
    private String departureAirport;

    public Flight(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        return departureAirport.equals(flight.departureAirport);
    }

    @Override
    public int hashCode() {
        return departureAirport.hashCode();
    }
}
