package com.domaranskiy.database;

import com.domaranskiy.entities.models.order.Order;
import com.domaranskiy.entities.models.order.OrderStatus;

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
    public static ArrayList<Order> getOrdersInCartByUser(String userName) {
        ArrayList<Order> ordersInCart = new ArrayList<>();
        for (Order order : orderList) {
            if (order.getUserName().equals(userName) && order.getOrderStatus().equals(OrderStatus.IN_CART)) {
                ordersInCart.add(order);
            }
        }
        return ordersInCart;
    }
    public static ArrayList<Order> getClosedOrdersByUser(String userName) {
        ArrayList<Order> ordersInCart = new ArrayList<>();
        for (Order order : orderList) {
            if (order.getUserName().equals(userName) && order.getOrderStatus().equals(OrderStatus.CLOSED)) {
                ordersInCart.add(order);
            }
        }
        return ordersInCart;
    }
}