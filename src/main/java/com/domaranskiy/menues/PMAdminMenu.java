package com.domaranskiy.menues;

import com.domaranskiy.menues.abs.AbsUserMenu;
import com.domaranskiy.menues.abs.Menu;
import com.domaranskiy.models.user.User;

public class PMAdminMenu extends AbsUserMenu {
    public PMAdminMenu(User user, Menu prevMenu) {
        super(user, prevMenu);
        setMainMenuItem("1.Write to admin");
        setSubMenuItem("-1.back");
    }

    @Override
    protected void navigation() throws Exception {
        switch (getMenuItem()) {
            case 1 -> writeToAdmin();
            case 0 -> System.exit(0);
            case -1 -> prevMenu.run();
            default -> showMenuMessage("Unknown menu item");
        }
    }

    private void writeToAdmin() {

    }
}