package com.Warehouse;

import com.Product.Product;
import java.util.ArrayList;
import java.util.List;

// Класс для склада
public class Warehouse {
    public List<Product> products = new ArrayList<>();
    public void getDeliver(List<Product> deliverableProducts) {
        products.addAll(deliverableProducts);
        System.out.println("Товары прибыли на склад!");
    }

    public void showProducts() {
        for(Product product: products) {
            System.out.println(product.getDetails());
        }
    }
}
