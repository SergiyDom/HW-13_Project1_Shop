package com.domaranskiy.menus.user;

import com.domaranskiy.menus.abs.AbsUserMenu;
import com.domaranskiy.menus.abs.Menu;
import com.domaranskiy.models.order.Order;
import com.domaranskiy.models.order.OrderEditStatus;
import com.domaranskiy.models.order.OrderStatus;
import com.domaranskiy.models.user.User;

public class InCartOrderMenu extends AbsUserMenu {
    final OrderStatus status = OrderStatus.IN_CART;
    Order order;

    public InCartOrderMenu(User user, Order order, Menu prevMenu) {
        super(user, prevMenu);
        this.order = order;

        menuNameSuffix();

        setMainMenuItem("1.Change order quantity");
        setMainMenuItem("2.Confirm order");
        setMainMenuItem("3.Delete order");
        setSubMenuItem("-1.back");
    }

    @Override
    protected void navigation() throws Exception {
        switch (getMenuItem()) {
            case 1 -> changeProductQuantity();
            case 2 -> confirmOrder();
            case 3 -> deleteOrder();
            case 0 -> System.exit(0);
            case -1 -> prevMenu.run();
            default -> showMenuMessage("Unknown menu item");
        }
    }

    private void changeProductQuantity() throws Exception {
        int quantity = getProductQuantity();
        order.setQuantity(quantity);
    }

    private void confirmOrder() {
        order.setEditStatus(OrderEditStatus.COMPLETED);
    }

    private void deleteOrder() {
        orders.deleteOrder(order);
    }

    @Override
    protected void handleCallbacks() throws Exception {
        super.handleCallbacks();
        menuNameSuffix();
        updateOrderInfo();
    }

    private void updateOrderInfo() {
        if (!orders.checkIfActiveOrderExists(order.getUserName(), order.getProductName(), order.getProductType())) {
            prevMenu.run();
        }
    }

    private void menuNameSuffix() {
        setMenuNameSuffix(
                order.getProductName() + "/"
                        + order.getQuantity() + "/"
                        + order.getEditStatus().name()
        );
    }
}