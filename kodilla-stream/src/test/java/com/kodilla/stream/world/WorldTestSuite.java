package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {

    @Test
    public void testGetPeopleQuantity() {
        //Given
        Country usa = new Country("USA", new BigDecimal("350000000"));
        Country canada = new Country("Canada", new BigDecimal("25000000"));
        Country china = new Country("China", new BigDecimal("1500000000"));
        Country india = new Country("India", new BigDecimal("1000000000"));

        Continent america = new Continent("America");
        Continent asia = new Continent("Asia");

        america.addCountry(usa);
        america.addCountry(canada);
        asia.addCountry(china);
        asia.addCountry(india);

        World world = new World();
        world.addContinent(america);
        world.addContinent(asia);

        //When
        BigDecimal worldPopulation = world.getPeopleQuantity();

        //Then
        BigDecimal expectedResult = new BigDecimal("2875000000");
        Assert.assertEquals(expectedResult, worldPopulation);
    }
}
