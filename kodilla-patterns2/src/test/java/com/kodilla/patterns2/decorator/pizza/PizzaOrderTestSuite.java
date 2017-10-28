package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PizzaOrderTestSuite {
    
        @Test
        public void testBasicPizzaOrderGetCost() {
            //Given
            PizzaOrder theOrder = new BasicPizzaOrder();
            System.out.println("Order cost: " + theOrder.getCost());
            //When
            BigDecimal calculatedCost = theOrder.getCost();
            //Then
            assertEquals(new BigDecimal(5), calculatedCost);
        }

        @Test
        public void testBasicPizzaOrderGetDescription() {
            //Given
            PizzaOrder theOrder = new BasicPizzaOrder();
            System.out.println(theOrder.getDescription());
            //When
            String description = theOrder.getDescription();
            //Then
            assertEquals("Pizza with cheese and ketchup", description);
        }

        @Test
        public void testPizzaWithHamOrderGetCost() {
            //Given
            PizzaOrder theOrder = new HamDecorator(new BasicPizzaOrder());
            System.out.println("Order cost: " + theOrder.getCost());
            //When
            BigDecimal calculatedCost = theOrder.getCost();
            //Then
            assertEquals(new BigDecimal(10), calculatedCost);
        }

        @Test
        public void testPizzaWithHamOrderGetCostGetDescription() {
            //Given
            PizzaOrder theOrder = new HamDecorator(new BasicPizzaOrder());
            System.out.println(theOrder.getDescription());
            //When
            String description = theOrder.getDescription();
            //Then
            assertEquals("Pizza with cheese and ketchup + ham", description);
        }

        @Test
        public void testPizzaWithHamAndOnionsGetCost() {
            //Given
            PizzaOrder theOrder = new OnionsDecorator(new HamDecorator(new BasicPizzaOrder()));
            System.out.println("Order cost: " + theOrder.getCost());
            //When
            BigDecimal calculatedCost = theOrder.getCost();
            //Then
            assertEquals(new BigDecimal(12), calculatedCost);
        }

        @Test
        public void testPizzaWithHamAndOnionsGetDescription() {
            //Given
            PizzaOrder theOrder = new OnionsDecorator(new HamDecorator(new BasicPizzaOrder()));
            System.out.println(theOrder.getDescription());
            //When
            String description = theOrder.getDescription();
            //Then
            assertEquals("Pizza with cheese and ketchup + ham + onions", description);
        }

        @Test
        public void testPizzaWithHamAndOnionsandSalamiGetCost() {
            //Given
            PizzaOrder theOrder = new SalamiDecorator(new OnionsDecorator(new HamDecorator(new BasicPizzaOrder())));
            System.out.println("Order cost: " + theOrder.getCost());
            //When
            BigDecimal calculatedCost = theOrder.getCost();
            //Then
            assertEquals(new BigDecimal(42), calculatedCost);
        }

        @Test
        public void testPizzaWithHamAndOnionsandSalamiGetDescription() {
            //Given
            PizzaOrder theOrder = new SalamiDecorator(new OnionsDecorator(new HamDecorator(new BasicPizzaOrder())));
            System.out.println(theOrder.getDescription());
            //When
            String description = theOrder.getDescription();
            //Then
            assertEquals("Pizza with cheese and ketchup + ham + onions + salami", description);
        }
}


