package com.kodilla.good.patterns.challenges.orders;

public class Order {
    private User user;
    private Basket basket;
    public static int number;

    public Order(User user, Basket basket) {
        this.user = user;
        this.basket = basket;
        number++;
    }

    public User getUser() {
        return user;
    }

    public Basket getBasket() {
        return basket;
    }

    public static int getNumber() {
        return number;
    }
}
