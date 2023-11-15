package christmas.service;

import christmas.model.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MenuService {
    // 샴페인 가격 조회
    public static int getChampagnePrice() {
        return Menu.getDrinks().stream()
                .filter(m -> m.getName().equals("샴페인"))
                .findFirst()
                .map(Menu::getPrice)
                .orElse(0);
    }

    // 모든 메뉴 목록 조회
    public static List<Menu> getAllMenus() {
        List<Menu> allMenus = new ArrayList<>();
        allMenus.addAll(Menu.getAppetizer());
        allMenus.addAll(Menu.getMainDishes());
        allMenus.addAll(Menu.getDesserts());
        allMenus.addAll(Menu.getDrinks());
        return allMenus;
    }

    // 특정 메뉴 조회
    public static Optional<Menu> getMenuByName(String name) {
        return getAllMenus().stream()
                .filter(m -> m.getName().equals(name))
                .findFirst();
    }
}
