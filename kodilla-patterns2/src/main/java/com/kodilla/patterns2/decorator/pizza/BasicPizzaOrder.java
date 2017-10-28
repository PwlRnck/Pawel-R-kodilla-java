package com.kodilla.patterns2.decorator.pizza;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("basicPizzaOrder")
@EnableAspectJAutoProxy
public class BasicPizzaOrder implements PizzaOrder {
    @Override
    public BigDecimal getCost() {
        return new BigDecimal(5);
    }

    @Override
    public String getDescription() {
        return "Pizza with cheese and ketchup";
    }
}
