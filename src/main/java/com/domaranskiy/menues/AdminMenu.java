package com.domaranskiy.menues;

import com.domaranskiy.menues.abs.AbsAdminMenu;
import com.domaranskiy.menues.abs.Menu;
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