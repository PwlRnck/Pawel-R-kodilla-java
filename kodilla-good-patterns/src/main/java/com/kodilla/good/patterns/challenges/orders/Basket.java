package com.kodilla.good.patterns.challenges.orders;

import java.util.HashMap;
import java.util.Map;

public class Basket {
    private Map<Product,Double> basket = new HashMap<>();

   public void addToBasket(Product product,Double quantity){
            this.basket.put(product, quantity);
    }

    public boolean removeFromBasket(Product product){
        if(basket.containsKey(product)){
            basket.remove(product);
            return true;
        } else {
            return false;
        }
    }

    public double basketValue(){
        return basket.entrySet().stream()
                .map(entry -> entry.getKey().getPrice()*entry.getValue())
                .reduce(0.0,(sum,nextItem) -> sum = sum + nextItem);
    }

    public Map<Product, Double> getBasket() {
        return basket;
    }
}