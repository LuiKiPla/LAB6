package com.Transport;

import com.Product.Product;

import java.util.List;

public class Ship extends Transport{
    @Override
    public void setDeliverableProducts(List<Product> deliverableProducts) {
        currentProducts = deliverableProducts;
        System.out.println("Товары загрузили в Ship");
    }

    @Override
    public List<Product> deliver() {
        System.out.println("Товары выгрузили с Ship");
        return currentProducts;
    }
}
