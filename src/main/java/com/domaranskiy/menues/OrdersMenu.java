package com.domaranskiy.menues;

import com.domaranskiy.menues.abs.AbsUserMenu;
import com.domaranskiy.menues.abs.Menu;
import com.domaranskiy.models.order.Order;
import com.domaranskiy.models.order.OrderStatus;
import com.domaranskiy.models.user.User;

import java.util.List;

public class OrdersMenu extends AbsUserMenu {
    public OrdersMenu(User user, Menu prevMenu) {
        super(user, prevMenu);

        setSubMenuItem("-1.back");
    }

    @Override
    protected void navigation() throws Exception {
        switch (getMenuItem()) {
            case 1 -> showClosedOrders();
            case 2 -> showOrdersInCart();
            case 0 -> System.exit(0);
            case -1 -> prevMenu.run();
            default -> showMenuMessage("Unknown menu item");
        }
    }

    private void showClosedOrders() {
        new OrdersListMenu(user, OrderStatus.CLOSED, this).run();
    }

    private void showOrdersInCart() {
        new OrdersListMenu(user, OrderStatus.IN_CART, this).run();
    }

    @Override
    protected void handleCallbacks() throws Exception {
        super.handleCallbacks();
        resetMainMenuItem();
        showClosedOrdersInfo();
        showOrdersInCartInfo();
    }

    private void showClosedOrdersInfo() {
        List<Order> closedOrders = orders.getClosedOrdersByUser(user.getName());
        if (closedOrders.size() > 0) {
            setMainMenuItem("1.View closed order(s) / amount:" + closedOrders.size());
        } else {
            setMainMenuItem("x.You have no closed order(s)");
        }
    }

    private void showOrdersInCartInfo() {
        List<Order> ordersInCart = orders.getOrdersInCartByUser(user.getName());
        if (ordersInCart.size() > 0) {
            setMainMenuItem("2.Viev order(s) in the cart / amount:" + ordersInCart.size());
        } else {
            setMainMenuItem("x.You have no order(s) in the cart");
        }
    }
}