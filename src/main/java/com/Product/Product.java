package com.Product;

import javax.xml.bind.annotation.XmlElement;

// Абстрактный класс для продукта
public abstract class Product {
    String name;
    double weight;

    public Product(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public Product() {

    }

    public abstract String getDetails();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
