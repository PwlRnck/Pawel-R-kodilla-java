package com.kodilla.good.patterns.challenges.orders;

public class Run {

    public static void main(String[] args){
        CreateSampleData sampleData = new CreateSampleData();
        Payment payment = new Payment("Bank transfer",34.05);
        Order order = sampleData.getOrder();

        ProductOrderService productOrderService =
                new ProductOrderService(new PaymentByBankTransferConfirmation(order,payment),
                                        new ShipmentByCourrier(order),
                                        new SendEMail());

        productOrderService.processOrder(order,payment);

    }

}
