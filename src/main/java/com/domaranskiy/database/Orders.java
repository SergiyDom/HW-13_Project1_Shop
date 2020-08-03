package com.domaranskiy.database;

import com.domaranskiy.entities.models.order.Order;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private static Orders instance;
    private static List<Order> orderList = new ArrayList<>();

    public Orders() {
    }

    public static synchronized Orders getInstance() {
        if (instance == null){
            instance = new Orders();
        }
        return instance;
    }
}