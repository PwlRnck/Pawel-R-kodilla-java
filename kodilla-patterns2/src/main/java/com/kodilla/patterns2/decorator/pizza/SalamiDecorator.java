package com.kodilla.patterns2.decorator.pizza;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@EnableAspectJAutoProxy
public class SalamiDecorator extends AbstractPizzaOrderDecorator {

    public SalamiDecorator(@Qualifier("basicPizzaOrder") PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(30));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + salami";
    }
}