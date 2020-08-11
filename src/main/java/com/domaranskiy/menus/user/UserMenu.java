package com.domaranskiy.menus.user;

import com.domaranskiy.menus.abs.AbsUserMenu;
import com.domaranskiy.menus.abs.Menu;
import com.domaranskiy.models.user.User;

public class UserMenu extends AbsUserMenu {

    public UserMenu(User user, Menu prevMenu) {
        super(user, prevMenu);

        setMenuNamePrefix(user.getName());
        setMainMenuItem("1.Products menu");
        setMainMenuItem("2.My orders menu");
        setMainMenuItem("3.PM admin(s)");
        setSubMenuItem("-1.back");
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
        new ProductsMenu(user,this).run();
    }

    private void showOrdersMenu() {
        new OrdersMenu(user,this).run();
    }

    private void showPMAdminMenu() {
        new PMAdminMenu(user,this).run();
    }
}