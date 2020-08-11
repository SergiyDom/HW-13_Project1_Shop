package com.domaranskiy.database;

import com.domaranskiy.models.order.Order;
import com.domaranskiy.models.order.OrderEditStatus;
import com.domaranskiy.models.order.OrderStatus;
import com.domaranskiy.models.product.ProductTypes;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private static Orders instance;
    private static List<Order> orderList = new ArrayList<>();

    public Orders() {
    }

    public static synchronized Orders getInstance() {
        if (instance == null) {
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

    public void addOrder(String userName, String productName, ProductTypes productTypes, int quantity) throws Exception {
        if (checkIfActiveOrderExists(userName, productName, productTypes)) {
            Order order = getOrder(userName, productName, productTypes);
            order.setQuantity(order.getQuantity() + quantity);
        } else {
            orderList.add(new Order(userName, productName, productTypes, quantity, OrderStatus.IN_CART, OrderEditStatus.EDITABLE));
        }
    }

    public boolean checkIfActiveOrderExists(String userName, String productName, ProductTypes productTypes) {
        for (Order order : orderList) {
            if (order.getUserName().equals(userName)
                    && order.getProductName().equals(productName)
                    && order.getProductType().equals(productTypes)
                    && order.getOrderStatus().equals(OrderStatus.IN_CART)
            ) {
                return true;
            }
        }
        return false;
    }

    public Order getOrder(String userName, String productName, ProductTypes productTypes) throws Exception {
        for (Order order : orderList) {
            if (order.getUserName().equals(userName)
                    && order.getProductName().equals(productName)
                    && order.getProductType().equals(productTypes)
                    && order.getOrderStatus().equals(OrderStatus.IN_CART)
            ) {
                return order;
            }
        }
        throw new Exception("Order not found");
    }

    public void deleteOrder(Order order) {
        for (Order previousOrder : orderList) {
            if (previousOrder.equals(order)) {
                orderList.remove(order);
                return;
            }
        }
    }
}