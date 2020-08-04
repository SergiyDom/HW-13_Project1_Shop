package com.domaranskiy.entities.menues.abs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Menu {
    private List<String> mainItems = new ArrayList<>();
    private List<String> subItems = new ArrayList<>();
    private List<String> infoFieldItems = new ArrayList<>();

    private String menuName = "";
    private String menuNamePrefix = "";
    private String menuNameSuffix = "";
    private String menuDelimetr = "";
    private String menuEnding = "";
    private String menu = "";

    protected Scanner scanner;

    protected Menu() {
        scanner = new Scanner(System.in);
    }

    {
        subItems.add("0. exit");
    }

    protected void setMainItem(String item) {
        mainItems.add(item);
    }

    protected void setSubItem(String item) {
        subItems.add(item);
    }

    protected void setInfoFieldItem(String item) {
        infoFieldItems.add(item);
    }

    protected void resetInfoFieldItem() {
        infoFieldItems.clear();
    }

    protected void resetMainItem() {
        mainItems.clear();
    }

    protected void setMenuNamePrefix(String prefix) {
        this.menuNamePrefix = prefix;
    }

    protected void setMenuNameSuffix(String suffix) {
        this.menuNameSuffix = suffix;
    }

    private void setMenuName() {
        if (menuNamePrefix.trim().length() > 0) {
            menuName = ">>>" + menuNamePrefix + ": " + this.getClass().getSimpleName();
        } else {
            menuName = ">>>" + this.getClass().getSimpleName();
        }
        if (menuNameSuffix.trim().length() > 0) {
            menuName += ": " + menuNameSuffix + "<<<";
        } else {
            menuName += "<<<";
        }
        menuEnding = "";
        menuDelimetr = "";
        for (int i = 0; i < menuName.length(); i++) {
            menuDelimetr += "-";
            menuEnding += "*";
        }
    }

    private void compileMenu() {
        setMenuName();
        menu = "";
        menu += menuEnding + "\n";
        menu += menuName + "\n";
        for (String item : mainItems) {
            menu += item + "\n";
        }
        if (infoFieldItems.size() > 0) {
            menu += menuDelimetr + "\n";
            for (String item : infoFieldItems) {
                menu += item + "\n";
            }
        }
        menu += menuDelimetr + "\n";
        for (String item : subItems) {
            menu += item + "\n";
        }
    }

    protected void showMenu() {
        System.out.println(menu);
    }

    protected void showMenuMessage(String message) {
        System.out.println("!!!" + message + "!!!");
    }

    abstract protected void navigation() throws Exception;

    public void run() {
        while (true) {
            try {
                compileMenu();
                showMenu();
                navigation();
            } catch (Exception e) {
                showMenuMessage(e.getMessage());
            }
        }
    }

    protected int getMenuItem() throws Exception {
        System.out.println("Your input: ");
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (Exception e) {
            throw new Exception("Error getting menu item, the input must be a number");
        }
    }

    protected String getLogin() {
        System.out.print("Login: ");
        return scanner.nextLine().trim();
    }

    protected String getPassword() {
        System.out.print("Password: ");
        return scanner.nextLine().trim();
    }

    protected String getName() throws Exception {
        System.out.print("Name: ");
        try {
            return scanner.nextLine().trim();
        } catch (Exception e) {
            throw new Exception("Error getting user name");
        }
    }

    protected int getAge() throws Exception {
        System.out.print("Age: ");
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (Exception e) {
            throw new Exception("Error getting user age, the age mast be a number");
        }
    }
}