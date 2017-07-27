package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public class Continent {
    private final List<Country> countryList = new ArrayList<>();
    private final String continentName;

    public Continent(String continentName) {
        this.continentName = continentName;
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public String getContinentName() {
        return continentName;
    }

    public void addCountry(Country country){
        countryList.add(country);
    }


}
