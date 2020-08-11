package com.domaranskiy.menus.admin;

import com.domaranskiy.menus.abs.AbsAdminMenu;
import com.domaranskiy.menus.abs.Menu;
import com.domaranskiy.models.user.User;

public class AdminMenu extends AbsAdminMenu {
    public AdminMenu(User user, Menu prevMenu) {
        super(user, prevMenu);
    }

    @Override
    protected void handleCallbacks() {

    }

    @Override
    protected void navigation() throws Exception {

    }
}