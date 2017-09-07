package com.kodilla.good.patterns.challenges.orders;

public class Payment {
    private String paymentMethod;
    private double paymentAmount;

    public Payment(String paymentMethod, double paymentAmount) {
        this.paymentMethod = paymentMethod;
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }
}
