package com.kodilla.good.patterns.challenges.food2door;

import java.util.Map;

public class OrderFromGlutenFreeShop implements Supplier {
    public boolean process(Map<Product,Double> orderList){
        double value = 0.0;
        for(Map.Entry<Product,Double> entry:orderList.entrySet()){
            value += entry.getKey().getPrice()*entry.getValue();
        }
        System.out.println("The order at " + getClass().getName().substring(getClass().getName().indexOf("From")+4) + " has been successfully placed." +
                "The total value of the order is " + String.format("%.2f",value));
        return true;
    }
}
