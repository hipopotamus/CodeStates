package delivery;

import java.util.ArrayList;

public class Restaurant {
    private String name;
    private Menu firstMenu;
    private ArrayList<Menu> menuList = new ArrayList<>();

    public Restaurant(String name, Menu firstMenu) {
        this.name = name;
        this.firstMenu = firstMenu;
        menuList.add(firstMenu);
    }

    public ArrayList<Menu> getMenuList() {
        return menuList;
    }

    public String getName() {
        return name;
    }
}
