package com.Fabrics;

import com.Product.Box;
import com.Product.Product;

public class BoxFactory implements ProductFactory{

    @Override
    public Product createProduct() {
        return new Box();
    }
}
