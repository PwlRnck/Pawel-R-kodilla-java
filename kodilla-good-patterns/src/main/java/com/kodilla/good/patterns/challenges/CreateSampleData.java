package com.kodilla.good.patterns.challenges;

import java.util.HashMap;
import java.util.Map;

public class CreateSampleData {

    private User user;//; = new User("John","Poland");
    private Basket basket;// = new Basket();
    private Order order;// = new Order(user,basket);

    public CreateSampleData(){
        user = new User("John","Poland");
        basket = new Basket();
        basket.addToBasket(new Product("Product1",2.5),10.5);
        basket.addToBasket(new Product("Product2",5.2),1.5);
        order = new Order(user,basket);
     }

    public User getUser() {
        return user;
    }

    public Basket getBasket() {
        return basket;
    }

    public Order getOrder() {
        return order;
    }
}