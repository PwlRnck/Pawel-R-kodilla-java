package com.kodilla.testing.weather.stub;

import java.util.HashMap;

/**
 * Created by PR on 20.07.2017.
 */
public interface Temperatures {
    //first element of the map is an identifier of weather station
    //second element of the map is a temperature in Celsius degrees

    HashMap<Integer, Double> getTemperatures();
}
