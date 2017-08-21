package com.kodilla.good.patterns.challenges.food2door;

import java.util.Map;

public interface Supplier {
    boolean process(Map<Product,Double> orderList);
}
