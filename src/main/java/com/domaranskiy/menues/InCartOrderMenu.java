package com.domaranskiy.menues;

import com.domaranskiy.menues.abs.AbsUserMenu;
import com.domaranskiy.menues.abs.Menu;
import com.domaranskiy.models.order.Order;
import com.domaranskiy.models.order.OrderStatus;
import com.domaranskiy.models.user.User;

public class InCartOrderMenu extends AbsUserMenu {
    final OrderStatus status = OrderStatus.IN_CART;
    Order order;
    public InCartOrderMenu(User user, Order order, Menu prevMenu) {
        super(user, prevMenu);
        this.order = order;

        setMenuNameSuffix(order.getProductName() + "/" + order.getQuantity());

        setMainMenuItem("1.Change order quantity");
        setMainMenuItem("2.Confirm order");
        setMainMenuItem("3.Delete order");
        setSubMenuItem("-1.back");
    }

    @Override
    protected void navigation() throws Exception {

    }
}