package com.kodilla.stream.world;

import java.math.BigDecimal;

public final class Country {
    private final String countryName;
    private final BigDecimal countryPopulation;

    public Country(String countryName, BigDecimal countryPopulation) {
        this.countryName = countryName;
        this.countryPopulation = countryPopulation;
    }

    public String getCountryName() {
        return countryName;
    }

    public BigDecimal getCountryPopulation() {
        return countryPopulation;
    }
}
