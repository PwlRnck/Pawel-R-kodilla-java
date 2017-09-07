package com.kodilla.good.patterns.challenges.orders;

public class SendEMail implements SendInformation {
    public void sendInfo(Order order){
        System.out.println("EMail: Order number " + Order.getNumber() + " has been sent");
    }
}
