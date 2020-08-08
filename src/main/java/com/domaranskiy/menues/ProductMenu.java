package com.domaranskiy.menues;

import com.domaranskiy.menues.abs.AbsUserMenu;
import com.domaranskiy.menues.abs.Menu;
import com.domaranskiy.models.product.Product;
import com.domaranskiy.models.user.User;

public class ProductMenu extends AbsUserMenu {
    protected Product product;
    public ProductMenu(User user, Product product, Menu prevMenu) {
        super(user, prevMenu);
        this.product = product;
    }

    @Override
    protected void navigation() throws Exception {

    }
}
