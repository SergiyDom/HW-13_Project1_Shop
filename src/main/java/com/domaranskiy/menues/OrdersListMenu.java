package com.domaranskiy.menues;

import com.domaranskiy.menues.abs.AbsUserMenu;
import com.domaranskiy.menues.abs.Menu;
import com.domaranskiy.models.order.Order;
import com.domaranskiy.models.order.OrderStatus;
import com.domaranskiy.models.user.User;

import java.util.ArrayList;
import java.util.List;

public class OrdersListMenu extends AbsUserMenu {
    OrderStatus status;

    public OrdersListMenu(User user, OrderStatus status, Menu prevMenu) {
        super(user, prevMenu);
        this.status = status;

        setMenuNamePrefix(status.getDescription());
        setSubMenuItem("-1.back");
    }

    @Override
    protected void navigation() throws Exception {
        int userInput = getMenuItem();
        switch (userInput) {
            case 0 -> System.exit(0);
            case -1 -> prevMenu.run();
            default -> processUserInput(userInput);
        }
    }

    private void processUserInput(int menuItem) {
        int listIndex = menuItem - 1;
        switch (status) {
            case IN_CART -> new InCartOrderMenu(user, getOrderList().get(listIndex), this).run();
            case CLOSED -> new ClosedOrderMenu(user, getOrderList().get(listIndex), this).run();
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

    @Override
    protected void handleCallbacks() throws Exception {
        super.handleCallbacks();
        compileOrdersListMenu();
    }

    private void compileOrdersListMenu() {
        resetMainMenuItem();
        List<Order> orderList = getOrderList();
        int size = orderList.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                int menuItemIndex = i + 1;
                Order order = orderList.get(i);
                setMainMenuItem(
                        menuItemIndex + "."
                        + order.getProductName()+ "/"
                        + order.getProductType().name().toLowerCase() + "/"
                        + order.getQuantity() + "/"
                        + order.getEditStatus().name()
                );
            }
        } else {
            setMainMenuItem("There are no orders in the cart");
        }
    }
}