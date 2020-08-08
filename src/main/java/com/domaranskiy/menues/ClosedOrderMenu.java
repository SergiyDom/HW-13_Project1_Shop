package com.domaranskiy.menues;

import com.domaranskiy.menues.abs.AbsUserMenu;
import com.domaranskiy.menues.abs.Menu;
import com.domaranskiy.models.order.Order;
import com.domaranskiy.models.order.OrderStatus;
import com.domaranskiy.models.user.User;

public class ClosedOrderMenu extends AbsUserMenu {
    final OrderStatus status = OrderStatus.CLOSED;
    Order order;
    public ClosedOrderMenu(User user, Order order, Menu prevMenu) {
        super(user, prevMenu);
        this.order = order;

        setMenuNameSuffix(order.getProductName() + "/" + order.getQuantity());

        setMainMenuItem("You cannot interact with closed orders");
        setSubMenuItem("-1.back");
    }

    @Override
    protected void navigation() throws Exception {

    }
}