package com.kodilla.good.patterns.challenges.food2door;

public class Run {
    public static void main(String[] args){
        Product product1 = new Product("Product1",2.55);
        Product product2 = new Product("Product2",3.22);
        Product product3 = new Product("Product3",5.33);

        OrderFromSupplier orderFromExtraFoodShop = new OrderFromSupplier(new OrderFromExtraFoodShop());
        OrderFromSupplier orderFromGlutenFreeShop = new OrderFromSupplier(new OrderFromGlutenFreeShop());
        OrderFromSupplier orderFromHealthyShop = new OrderFromSupplier(new OrderFromHealthyShop());

        orderFromExtraFoodShop.addItem(product1,3.8);
        orderFromExtraFoodShop.addItem(product2,4.0);
        orderFromExtraFoodShop.placeOrder();

        orderFromGlutenFreeShop.addItem(product2,4.5);
        orderFromGlutenFreeShop.addItem(product3,5.4);
        orderFromGlutenFreeShop.placeOrder();

        orderFromHealthyShop.addItem(product3,0.9);
        orderFromHealthyShop.placeOrder();
    }
}
