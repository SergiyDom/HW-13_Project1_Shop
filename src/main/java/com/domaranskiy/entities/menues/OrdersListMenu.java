package com.domaranskiy.entities.menues;

import com.domaranskiy.entities.menues.abs.AbsUserMenu;
import com.domaranskiy.entities.menues.abs.Menu;
import com.domaranskiy.entities.models.order.Order;
import com.domaranskiy.entities.models.order.OrderStatus;
import com.domaranskiy.entities.models.user.User;

import java.util.ArrayList;

public class OrdersListMenu extends AbsUserMenu {
    OrderStatus status;

    public OrdersListMenu(User user, OrderStatus status, Menu prevMenu) {
        super(user, prevMenu);
        this.status = status;

        setMenuNamePrefix(status.getDescription());
        setSubItem("-1.back");
    }

    @Override
    protected void navigation() throws Exception {
        switch (getMenuItem()) {
            case 0 -> System.exit(0);
            case -1 -> prevMenu.run();
            default -> prcessUserInput(getMenuItem()); //чи потрібно було getMenuItem() замінити на int
        }
    }

    private void prcessUserInput(int menuItem) {
        int listIndex = menuItem - 1;
        switch (status) {
            case IN_CART -> new InCartOrderMenu(user, getOrderList().get(listIndex), this);
            case CLOSED -> new ClosedOrderMenu(user, getOrderList().get(listIndex), this);
        }
    }

    private ArrayList<Order> getOrderList() {
        ArrayList<Order> ordersList = new ArrayList<>();
        switch (status) {
            case IN_CART -> ordersList = orders.getOrdersInCartByUser(user.getName());
            case CLOSED -> ordersList = orders.getClosedOrdersByUser(user.getName());
        }
        return ordersList;
    }
}