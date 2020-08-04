package com.domaranskiy.entities.menues;

import com.domaranskiy.entities.menues.abs.AbsUserMenu;
import com.domaranskiy.entities.menues.abs.Menu;
import com.domaranskiy.entities.models.order.Order;
import com.domaranskiy.entities.models.order.OrderStatus;
import com.domaranskiy.entities.models.user.User;

public class InCartOrderMenu extends AbsUserMenu {
    final OrderStatus status = OrderStatus.IN_CART;
    Order order;
    public InCartOrderMenu(User user, Order order, Menu prevMenu) {
        super(user, prevMenu);
        this.order = order;

        setMenuNameSuffix(order.getProductName() + "/" + order.getQuantity());

        setMainItem("1.Change order quantity");
        setMainItem("2.Confirm order");
        setMainItem("3.Delete order");
        setSubItem("-1.back");
    }

    @Override
    protected void navigation() throws Exception {

    }
}