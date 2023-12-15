package com.Transport;

import com.Product.Product;

import java.util.List;

// Класс для грузовика, который реализует интерфейс main.java.com.Transport.main.java.com.Transport
public class Truck extends Transport {
    @Override
    public void setDeliverableProducts(List<Product> deliverableProducts) {
        currentProducts = deliverableProducts;
        System.out.println("Товары загрузили в Truck");
    }

    @Override
    public List<Product> deliver() {
        System.out.println("Товары выгрузили с Truck");
        return currentProducts;
    }


}
