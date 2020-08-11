package com.domaranskiy.models.product;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {
    private String name;
    private ProductTypes types;
    private double price;
    private int quantity;

    public Product(String name, ProductTypes types, double price, int quantity) {
        this.name = name;
        this.types = types;
        this.price = price;
        this.quantity = quantity;
    }
}