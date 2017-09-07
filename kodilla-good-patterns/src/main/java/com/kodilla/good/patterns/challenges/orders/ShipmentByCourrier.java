package com.kodilla.good.patterns.challenges.orders;

public class ShipmentByCourrier implements Shipment {

    private Order order;

    public ShipmentByCourrier(Order order) {
        this.order = order;
    }

    public void ship(Order order){
    }

    public Order getOrder() {
        return order;
    }
}
