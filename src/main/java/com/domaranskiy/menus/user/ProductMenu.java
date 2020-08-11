package com.domaranskiy.menus.user;

import com.domaranskiy.menus.abs.AbsUserMenu;
import com.domaranskiy.menus.abs.Menu;
import com.domaranskiy.models.product.Product;
import com.domaranskiy.models.user.User;

public class ProductMenu extends AbsUserMenu {
    protected Product product;
    public ProductMenu(User user, Product product, Menu prevMenu) {
        super(user, prevMenu);
        this.product = product;

        setMenuNamePrefix(product.getName());
        setMainMenuItem("1.Add to cart");
        setSubMenuItem("-1.back");
    }

    @Override
    protected void navigation() throws Exception {
        switch (getMenuItem()){
            case 1 -> performAddToCart();
            case 0 -> System.exit(0);
            case -1 -> prevMenu.run();
            default -> showMenuMessage("Unknown menu item");
        }
    }

    private void performAddToCart() throws Exception {
        orders.addOrder(user.getName(),product.getName(),product.getTypes(),1);
    }
}
