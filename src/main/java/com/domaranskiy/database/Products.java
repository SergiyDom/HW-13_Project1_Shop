package com.domaranskiy.database;

import com.domaranskiy.entities.models.product.Product;
import com.domaranskiy.entities.models.product.ProductTypes;

import java.util.ArrayList;
import java.util.List;

public class Products {
    private static Products instance;
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product("Milk", ProductTypes.FOOD, 22.15, 3));
        productList.add(new Product("Bread", ProductTypes.FOOD, 12.26, 7));
        productList.add(new Product("Battery", ProductTypes.ELECTRONICS, 82.16, 30));
        productList.add(new Product("lamp", ProductTypes.ELECTRONICS, 122.05, 13));
    }

    public Products() {
    }

    public static synchronized Products getInstance() {
        if (instance == null) {
            instance = new Products();
        }
        return instance;
    }
}