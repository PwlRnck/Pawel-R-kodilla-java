package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ItemDao itemDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Product product1 = new Product("Apple");
        Product product2 = new Product("Banana");
        Product product3 = new Product("Cocoa");

        Item item1 = new Item(product1,new BigDecimal("1.2"),2);
        Item item2 = new Item(product2,new BigDecimal("2.3"),3);
        Item item3 = new Item(product3,new BigDecimal("3.4"),4);
        Item item4 = new Item(product1,new BigDecimal("1.2"),1);

        product1.getItems().add(item1);
        product1.getItems().add(item4);
        product2.getItems().add(item2);
        product3.getItems().add(item3);

        Invoice invoice = new Invoice("00001");
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);
        invoice.getItems().add(item4);

        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);
        item4.setInvoice(invoice);
        //When
        invoiceDao.save(invoice);
        int id = invoice.getId();

        //Then
        Assert.assertNotEquals(0, id);

        //Clean up
        //invoiceDao.delete(id);
    }

    @Test
    public void testInvoiceDaoSave2() {
        //Given
        Product product1 = new Product("Apple");
        Product product2 = new Product("Banana");
        Product product3 = new Product("Cocoa");

        productDao.save(product1);
        productDao.save(product2);
        productDao.save(product3);

        Item item1 = new Item(product1,new BigDecimal("1.2"),2);
        Item item2 = new Item(product2,new BigDecimal("2.3"),3);
        Item item3 = new Item(product3,new BigDecimal("3.4"),4);
        Item item4 = new Item(product1,new BigDecimal("1.2"),1);

        itemDao.save(item1);
        itemDao.save(item2);
        itemDao.save(item3);
        itemDao.save(item4);

        product1.getItems().add(item1);
        product1.getItems().add(item4);
        product2.getItems().add(item2);
        product3.getItems().add(item3);

        Invoice invoice = new Invoice("00001");
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);
        invoice.getItems().add(item4);

        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);
        item4.setInvoice(invoice);
        //When


        invoiceDao.save(invoice);
        int id = invoice.getId();

        //Then
        Assert.assertNotEquals(0, id);

        //Clean up
        //invoiceDao.delete(id);
    }
}
