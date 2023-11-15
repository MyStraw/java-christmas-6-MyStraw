package christmas.controller;

import christmas.model.Menus;
import christmas.service.MenusService;

import java.util.List;
import java.util.Optional;

public class MenusController {
    private final MenusService menuService;
    public MenusController() {
        this.menuService = new MenusService();
    }
    public List<Menus> getAllMenus() {
        return menuService.getAllMenus();
    }
    public Optional<Menus> getMenuByName(String name) {
        return menuService.getMenuByName(name);
    }
    public int getChampagnePrice() {
        return menuService.getChampagnePrice();
    }
}
