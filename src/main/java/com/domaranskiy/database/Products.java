package com.domaranskiy.database;

import com.domaranskiy.models.product.Product;
import com.domaranskiy.models.product.ProductTypes;

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

    public List<String> getProductNameList() {
        List<String> productNames = new ArrayList<>();
        for (Product product : productList) {
            productNames.add(product.getName());
        }
        return productNames;
    }

    public Product getProductByIndex(int index) throws Exception {
        try {
            return productList.get(index);
        } catch (Exception e) {
            throw new Exception("Invalid product index");
        }
    }

    public Product getProductByName(String name, ProductTypes type) throws Exception {
        for (Product product : productList) {
            if (product.getName().equalsIgnoreCase(name) && product.getTypes().equals(type)) {
                return product;
            }
        }
        throw new Exception("Product not found");
    }
}