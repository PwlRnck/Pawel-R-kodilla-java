package com.kodilla.good.patterns.challenges.orders;

public class ShipmentByMail implements Shipment {

    private Order order;

    public ShipmentByMail(Order order) {
        this.order = order;
    }

    public void ship(Order order){
    }

    public Order getOrder() {
        return order;
    }
}
