package com.domaranskiy.entities.menues;

import com.domaranskiy.entities.menues.abs.AbsUserMenu;
import com.domaranskiy.entities.menues.abs.Menu;
import com.domaranskiy.entities.models.user.User;

public class PMAdminMenu extends AbsUserMenu {
    public PMAdminMenu(User user, Menu prevMenu) {
        super(user, prevMenu);
        setMainItem("1.Write to admin");
        setSubItem("-1.back");
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