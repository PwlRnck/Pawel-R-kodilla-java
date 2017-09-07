package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigMacTestSuite {
    @Test
    public void testBigMacBuilder() {
        //Given
        BigMac bigMac = new BigMac.BigMacBuilder()
                .roll(BigMac.NOSESAMEE)
                .adjustBurgers(3)
                .sauce(BigMac.BARBECUE)
                .adjustBurgers(-1)
                .ingredient(BigMac.ONIONS)
                .ingredient(BigMac.CUCUMBER)
                .build();
        System.out.println(bigMac);
        //When
        int howManyBurgers = bigMac.getBurgers();
        int howManyIngredients = bigMac.getIngredients().size();
        //Then
        Assert.assertEquals(2,howManyBurgers);
        Assert.assertEquals(2,howManyIngredients);
    }
}
