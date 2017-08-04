package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class SearchFlights {
       public Boolean findFlight(Flight flight) throws RouteNotFoundException{
           Map<String, Boolean> airports = new HashMap<>();
           airports.put("Airport 1",true);
           airports.put("Airport 2",true);
           airports.put("Airport 3",false);

           if(airports.get(flight.getDepartureAirport())!=null)
               return airports.get(flight.getDepartureAirport());
           throw new RouteNotFoundException("Airport not found in the database");
       }
}
