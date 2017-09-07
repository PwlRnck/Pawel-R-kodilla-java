package com.kodilla.good.patterns.challenges.orders;

public class SendSMS implements SendInformation {
    public void sendInfo(Order order){
        System.out.println("SMS: Order number " + Order.getNumber() + " has been sent");
    }
}
