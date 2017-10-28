package com.kodilla.patterns2.decorator.taxiportal;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class TaxiOrderTestSuite {
    @Test
    public void testBasicTaxiOrderGetCost() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        //When
        BigDecimal calculatedCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(5), calculatedCost);
    }

    @Test
    public void testBasicTaxiOrderGetDescription() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Drive a course", description);
    }

    @Test
    public void testTaxiNetworkOrderGetCost() {
        //Given
        TaxiOrder theOrder = new TaxiNetworkOrderDecorator(new BasicTaxiOrder());
        //When
        BigDecimal calculatedCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(40), calculatedCost);
    }

    @Test
    public void testTaxiNetworkOrderGetDescription() {
        //Given
        TaxiOrder theOrder = new TaxiNetworkOrderDecorator(new BasicTaxiOrder());
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Drive a course by Taxi Network", description);
    }

    @Test
    public void testMyTaxiNetworkWithChildSeatGetCost() {
        //Given
        TaxiOrder theOrder = new ChildSeatDecorator(new MyTaxiNetworkOrderDecorator(new BasicTaxiOrder()));
        //When
        BigDecimal calculatedCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(37), calculatedCost);
    }

    @Test
    public void testMyTaxiNetworkWithChildSeatGetDescription() {
        //Given
        TaxiOrder theOrder = new ChildSeatDecorator(new MyTaxiNetworkOrderDecorator(new BasicTaxiOrder()));
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Drive a course by MyTaxi Network + child seat", description);
    }

    @Test
    public void testVipTaxiWithChildSeatExpressGetCost() {
        //Given
        TaxiOrder theOrder = new ChildSeatDecorator(new VipDecorator(new TaxiNetworkOrderDecorator(new BasicTaxiOrder())));
        System.out.println(theOrder.getCost());
        //When
        BigDecimal calculatedCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(52), calculatedCost);
    }

    @Test
    public void testVipTaxiWithChildSeatExpressGetDescription() {
        //Given
        TaxiOrder theOrder = new ChildSeatDecorator(new VipDecorator(new TaxiNetworkOrderDecorator(new BasicTaxiOrder())));
        System.out.println(theOrder.getDescription());
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Drive a course by Taxi Network + variant VIP + child seat", description);
    }
}
