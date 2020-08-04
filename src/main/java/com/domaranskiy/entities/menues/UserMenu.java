package com.domaranskiy.entities.menues;

import com.domaranskiy.entities.menues.abs.AbsUserMenu;
import com.domaranskiy.entities.menues.abs.Menu;
import com.domaranskiy.entities.models.user.User;

public class UserMenu extends AbsUserMenu {

    public UserMenu(User user, Menu prevMenu) {
        super(user, prevMenu);

        setMenuNamePrefix(user.getName());
        setMainItem("1.Products menu");
        setMainItem("2.My orders menu");
        setMainItem("3.PM admin(s)");
        setMainItem("-1.back");
    }

    @Override
    protected void navigation() throws Exception {
        switch (getMenuItem()) {
            case 1 -> showProductsMenu();
            case 2 -> showOrdersMenu();
            case 3 -> showPMAdminMenu();
            case 0 -> System.exit(0);
            case -1 -> prevMenu.run();
            default -> showMenuMessage("Unknown menu item");
        }
    }

    private void showProductsMenu() {
        new ProductsMenu(user,this);
    }

    private void showOrdersMenu() {
        new OrdersMenu(user,this);
    }

    private void showPMAdminMenu() {
        new PMAdminMenu(user,this);
    }
}