package com.domaranskiy.menues;

import com.domaranskiy.menues.abs.AbsUserMenu;
import com.domaranskiy.menues.abs.Menu;
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
        switch (getMenuItem()) {
            case 0 -> System.exit(0);
            case -1 -> prevMenu.run();
            default -> processUserInput(getMenuItem());
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
