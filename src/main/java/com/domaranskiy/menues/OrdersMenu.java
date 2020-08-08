package com.domaranskiy.menues;

import com.domaranskiy.menues.abs.AbsUserMenu;
import com.domaranskiy.menues.abs.Menu;
import com.domaranskiy.models.order.OrderStatus;
import com.domaranskiy.models.user.User;

public class OrdersMenu extends AbsUserMenu {
    public OrdersMenu(User user, Menu prevMenu) {
        super(user, prevMenu);

        setMainMenuItem("1.Closed Orders");
        setMainMenuItem("2.Orders In Cart");
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
}