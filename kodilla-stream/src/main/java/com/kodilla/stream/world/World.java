package com.kodilla.stream.world;

import sun.awt.image.BufferedImageGraphicsConfig;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class World {
    private final List<Continent> continentList = new ArrayList<>();

    public void addContinent(Continent continent){
        continentList.add(continent);
    }

    public BigDecimal getPeopleQuantity(){
        return continentList.stream().flatMap(continent -> continent.getCountryList().stream())
                .map(country -> country.getCountryPopulation())
                .reduce(BigDecimal.ZERO,(sum,current) -> sum =  sum.add(current));
    }
}
