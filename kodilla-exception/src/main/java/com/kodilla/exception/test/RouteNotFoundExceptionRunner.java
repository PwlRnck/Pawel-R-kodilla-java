package com.kodilla.exception.test;

public class RouteNotFoundExceptionRunner {
    public static void main(String[] args){
        SearchFlights searchFlights = new SearchFlights();
        try {
            searchFlights.findFlight(new Flight("Airport 4"));
        }catch(RouteNotFoundException e){
            System.out.println(e.getMessage());
        }finally{
            System.out.println("End of the program");
        }
    }
}
