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

    // 모든 메뉴 목록 조회
    public List<Menus> getAllMenus() {
        return menuService.getAllMenus();
    }

    // 특정 메뉴 조회
    public Optional<Menus> getMenuByName(String name) {
        return menuService.getMenuByName(name);
    }

    // 샴페인 가격 조회
    public int getChampagnePrice() {
        return menuService.getChampagnePrice();
    }
}
