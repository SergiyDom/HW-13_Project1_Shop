package com.domaranskiy.entities.menues;

import com.domaranskiy.entities.menues.abs.AbsAdminMenu;
import com.domaranskiy.entities.menues.abs.Menu;
import com.domaranskiy.entities.models.user.User;

public class AdminMenu extends AbsAdminMenu {
    public AdminMenu(User user, Menu prevMenu) {
        super(user, prevMenu);
    }

    @Override
    protected void navigation() throws Exception {

    }
}