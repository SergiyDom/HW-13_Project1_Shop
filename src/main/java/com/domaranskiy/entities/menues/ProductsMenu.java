package com.domaranskiy.entities.menues;

import com.domaranskiy.entities.menues.abs.AbsUserMenu;
import com.domaranskiy.entities.menues.abs.Menu;
import com.domaranskiy.entities.models.user.User;

public class ProductsMenu extends AbsUserMenu {
    public ProductsMenu(User user, Menu prevMenu) {
        super(user, prevMenu);

        setMainItem("1.Product list");
        setMainItem("2.Search product");
        setMainItem("3.Orders checkout");
        setSubItem("-1.back");
    }

    @Override
    protected void navigation() throws Exception {
        switch (getMenuItem()) {
            case 1 -> showProductListMenu();
            case 2 -> showProductMenu();
            case 3 -> showOrderCheckoutMenu();
            case 0 -> System.exit(0);
            case -1 -> prevMenu.run();
            default -> showMenuMessage("Unknown menu item");
        }
    }

    private void showProductListMenu() {

    }

    private void showProductMenu() {

    }

    private void showOrderCheckoutMenu() {

    }
}