package com.kodilla.good.patterns.challenges.orders;

public class ProductOrderService {

    private PaymentConfirmation paymentConfirmation;
    private Shipment shipment;
    private SendInformation sendInformation;

    public ProductOrderService(PaymentConfirmation paymentConfirmation, Shipment shipment, SendInformation sendInformation) {
        this.paymentConfirmation = paymentConfirmation;
        this.shipment = shipment;
        this.sendInformation = sendInformation;
    }

    public void processOrder(Order order, Payment payment){
        boolean confirm = paymentConfirmation.confirmPayment();
        if(confirm){
            shipment.ship(order);
            sendInformation.sendInfo(order);
        } else {
            System.out.println("The order could not be processed");
        }
    }
}
