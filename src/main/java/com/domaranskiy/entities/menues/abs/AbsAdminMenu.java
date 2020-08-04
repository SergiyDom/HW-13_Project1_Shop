package com.domaranskiy.entities.menues.abs;

import com.domaranskiy.entities.models.user.User;

public abstract class AbsAdminMenu extends Menu {
    protected User user;
    protected Menu prevMenu;

    public AbsAdminMenu(User user, Menu prevMenu) {
        this.user = user;
        this.prevMenu = prevMenu;
    }
}