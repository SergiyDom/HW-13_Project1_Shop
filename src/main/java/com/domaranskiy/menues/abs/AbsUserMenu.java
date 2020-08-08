package com.domaranskiy.menues.abs;

import com.domaranskiy.database.Orders;
import com.domaranskiy.database.Products;
import com.domaranskiy.models.user.User;

public abstract class AbsUserMenu extends Menu{
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
}