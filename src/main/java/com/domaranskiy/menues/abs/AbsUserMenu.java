package com.domaranskiy.menues.abs;

import com.domaranskiy.database.Orders;
import com.domaranskiy.database.Products;
import com.domaranskiy.models.order.Order;
import com.domaranskiy.models.user.User;

import java.util.List;

public abstract class AbsUserMenu extends Menu {
    protected User user;
    protected Menu prevMenu;
    protected Products products;
    protected Orders orders;

    public AbsUserMenu(User user, Menu prevMenu) {
        this.user = user;
        this.prevMenu = prevMenu;
        this.products = Products.getInstance();
        this.orders = Orders.getInstance();
    }

    @Override
    protected void handleCallbacks() throws Exception {
        showOrdersInCartDetailedInfo();
    }

    private void showOrdersInCartDetailedInfo() {
        resetInfoFieldItem();
        List<Order> ordersInCart = orders.getOrdersInCartByUser(user.getName());
        if (ordersInCart.size() > 0) {
            int productsQuantity = 0;
            for (Order order : ordersInCart) {
                productsQuantity += order.getQuantity();
            }
            setInfoFieldItem("You have: " + ordersInCart.size() + " orders (" + productsQuantity + "products) in the cart");
        }
    }
}