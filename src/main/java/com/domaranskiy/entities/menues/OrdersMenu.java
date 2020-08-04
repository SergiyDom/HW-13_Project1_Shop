package com.domaranskiy.entities.menues;

import com.domaranskiy.entities.menues.abs.AbsUserMenu;
import com.domaranskiy.entities.menues.abs.Menu;
import com.domaranskiy.entities.models.order.OrderStatus;
import com.domaranskiy.entities.models.user.User;

public class OrdersMenu extends AbsUserMenu {
    public OrdersMenu(User user, Menu prevMenu) {
        super(user, prevMenu);

        setSubItem("-1.back");
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
        new OrdersListMenu(user, OrderStatus.CLOSED, this);
    }

    private void showOrdersInCart() {
        new OrdersListMenu(user, OrderStatus.IN_CART, this).run();
    }
}