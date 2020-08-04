package com.domaranskiy.entities.menues;

import com.domaranskiy.entities.menues.abs.AbsUserMenu;
import com.domaranskiy.entities.menues.abs.Menu;
import com.domaranskiy.entities.models.order.Order;
import com.domaranskiy.entities.models.order.OrderStatus;
import com.domaranskiy.entities.models.user.User;

public class ClosedOrderMenu extends AbsUserMenu {
    final OrderStatus status = OrderStatus.CLOSED;
    Order order;
    public ClosedOrderMenu(User user, Order order, Menu prevMenu) {
        super(user, prevMenu);
        this.order = order;

        setMenuNameSuffix(order.getProductName() + "/" + order.getQuantity());

        setMainItem("You cannot interact with closed orders");
        setSubItem("-1.back");
    }

    @Override
    protected void navigation() throws Exception {

    }
}