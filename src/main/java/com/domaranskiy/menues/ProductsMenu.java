package com.domaranskiy.menues;

import com.domaranskiy.menues.abs.AbsUserMenu;
import com.domaranskiy.menues.abs.Menu;
import com.domaranskiy.models.order.OrderStatus;
import com.domaranskiy.models.product.ProductTypes;
import com.domaranskiy.models.user.User;

public class ProductsMenu extends AbsUserMenu {
    protected ProductsMenu(User user, Menu prevMenu) {
        super(user, prevMenu);

        setMainMenuItem("1.Product list");
        setMainMenuItem("2.Search product");
        setMainMenuItem("3.Orders checkout");
        setSubMenuItem("-1.back");
    }

    @Override
    protected void navigation() throws Exception {
        switch (getMenuItem()) {
            case 1 -> showProductListMenu();
            case 2 -> showSearchProductMenu();
            case 3 -> showOrderCheckoutMenu();
            case 0 -> System.exit(0);
            case -1 -> prevMenu.run();
            default -> showMenuMessage("Unknown menu item");
        }
    }

    private void showProductListMenu() {
        new ProductListMenu(user, this).run();
    }

    private void showSearchProductMenu() throws Exception {
        ProductTypes type = getProductType();
        String productName = getProductName();
        new ProductMenu(user, products.getProductByName(productName, type), this).run();
    }

    private void showOrderCheckoutMenu() {
        new OrdersListMenu(user, OrderStatus.IN_CART,this).run();
    }
}