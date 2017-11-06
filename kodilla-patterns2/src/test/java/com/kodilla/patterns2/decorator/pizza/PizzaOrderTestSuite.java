package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PizzaOrderTestSuite {

    @Autowired
    private BasicPizzaOrder theOrder;

    @Test
        public void testBasicPizzaOrderGetCost() {
            //Given
            System.out.println("Order cost: " + theOrder.getCost());
            //When
            BigDecimal calculatedCost = theOrder.getCost();
            //Then
            assertEquals(new BigDecimal(5), calculatedCost);
        }

        @Test
        public void testBasicPizzaOrderGetDescription() {
            //Given
            System.out.println(theOrder.getDescription());
            //When
            String description = theOrder.getDescription();
            //Then
            assertEquals("Pizza with cheese and ketchup", description);
        }

        @Test
        public void testPizzaWithHamOrderGetCost() {
            //Given
            PizzaOrder theOrder2 = new HamDecorator(theOrder);
            System.out.println("Order cost: " + theOrder2.getCost());
            //When
            BigDecimal calculatedCost = theOrder2.getCost();
            //Then
            assertEquals(new BigDecimal(10), calculatedCost);
        }

        @Test
        public void testPizzaWithHamOrderGetCostGetDescription() {
            //Given
            PizzaOrder theOrder3 = new HamDecorator(theOrder);
            System.out.println(theOrder3.getDescription());
            //When
            String description = theOrder3.getDescription();
            //Then
            assertEquals("Pizza with cheese and ketchup + ham", description);
        }

        @Test
        public void testPizzaWithHamAndOnionsGetCost() {
            //Given
            PizzaOrder theOrder4 = new OnionsDecorator(new HamDecorator(theOrder));
            System.out.println("Order cost: " + theOrder4.getCost());
            //When
            BigDecimal calculatedCost = theOrder4.getCost();
            //Then
            assertEquals(new BigDecimal(12), calculatedCost);
        }

        @Test
        public void testPizzaWithHamAndOnionsGetDescription() {
            //Given
            PizzaOrder theOrder5 = new OnionsDecorator(new HamDecorator(theOrder));
            System.out.println(theOrder5.getDescription());
            //When
            String description = theOrder5.getDescription();
            //Then
            assertEquals("Pizza with cheese and ketchup + ham + onions", description);
        }

        @Test
        public void testPizzaWithHamAndOnionsandSalamiGetCost() {
            //Given
            PizzaOrder theOrder6 = new SalamiDecorator(new OnionsDecorator(new HamDecorator(theOrder)));
            System.out.println("Order cost: " + theOrder6.getCost());
            //When
            BigDecimal calculatedCost = theOrder6.getCost();
            //Then
            assertEquals(new BigDecimal(42), calculatedCost);
        }

        @Test
        public void testPizzaWithHamAndOnionsandSalamiGetDescription() {
            //Given
            PizzaOrder theOrder7 = new SalamiDecorator(new OnionsDecorator(new HamDecorator(theOrder)));
            System.out.println(theOrder7.getDescription());
            //When
            String description = theOrder7.getDescription();
            //Then
            assertEquals("Pizza with cheese and ketchup + ham + onions + salami", description);
        }

    @Test
    public void testContext() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.patterns2.decorator.pizza");

        //When & Then
        System.out.println("===== Beans list: ==== >>");
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
        System.out.println("<< ===== Beans list ====");
    }
}


