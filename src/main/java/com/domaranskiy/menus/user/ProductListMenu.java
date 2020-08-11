package com.domaranskiy.menus.user;

import com.domaranskiy.menus.abs.AbsUserMenu;
import com.domaranskiy.menus.abs.Menu;
import com.domaranskiy.models.user.User;

import java.util.List;

public class ProductListMenu extends AbsUserMenu {

    protected ProductListMenu(User user, Menu prevMenu) {
        super(user, prevMenu);

        compileProductsListMenu();
        setSubMenuItem("-1.back");
    }

    @Override
    protected void navigation() throws Exception {
        int userInput = getMenuItem();
        switch (userInput) {
            case 0 -> System.exit(0);
            case -1 -> prevMenu.run();
            default -> processUserInput(userInput);
        }
    }

    private void compileProductsListMenu() {
        List<String> productNameList = products.getProductNameList();
        for (int i = 0; i < productNameList.size(); i++) {
            int menuItemIndex = i + 1;
            setMainMenuItem(menuItemIndex + "." + productNameList.get(i));
        }
    }

    private void processUserInput(int userInput) throws Exception {
        int index = userInput - 1;
        new ProductMenu(user, products.getProductByIndex(index),this).run();
    }
}
