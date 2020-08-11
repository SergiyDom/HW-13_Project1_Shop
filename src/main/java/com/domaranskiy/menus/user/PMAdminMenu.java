package com.domaranskiy.menus.user;

import com.domaranskiy.menus.abs.AbsUserMenu;
import com.domaranskiy.menus.abs.Menu;
import com.domaranskiy.models.message.Message;
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
        String message = getMessageBody();
        messages.addMessage(new Message(user.getName(),message));
    }
}