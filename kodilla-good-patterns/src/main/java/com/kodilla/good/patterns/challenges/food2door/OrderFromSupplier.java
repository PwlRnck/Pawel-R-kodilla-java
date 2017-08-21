package com.kodilla.good.patterns.challenges.food2door;

import java.util.HashMap;
import java.util.Map;

public class OrderFromSupplier {
    private Supplier supplier;
    private Map<Product,Double> orderList = new HashMap<>();


    public OrderFromSupplier(Supplier supplier){
        this.supplier = supplier;
    }

    public void addItem(Product product, double quantity){
        orderList.put(product, quantity);
    }

    public void placeOrder() {
        supplier.process(orderList);
    }
}
