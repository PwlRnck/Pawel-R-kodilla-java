package com.kodilla.good.patterns.challenges.orders;

public class PaymentByBankTransferConfirmation implements PaymentConfirmation {
    private Order order;
    private Payment payment;

    public PaymentByBankTransferConfirmation(Order order, Payment payment) {
        this.order = order;
        this.payment = payment;
    }

    public Order getOrder() {
        return order;
    }

    public Payment getPayment() {
        return payment;
    }

    @Override
    public boolean confirmPayment() {
        if(payment.getPaymentAmount()>=order.getBasket().basketValue()){
            System.out.println("Bank transfer payment confirmed");
            return true;
        } else {
            System.out.println("Bank transfer payment not confirmed");
            return false;
        }
    }
}
