package com.Transport;

import com.Product.Product;

import java.util.List;

// Интерфейс для транспортного средства
interface Transportable {
    void setDeliverableProducts(List<Product> deliverableProducts);
    List<Product> deliver();
}
