package christmas.service;

import christmas.constant.Constants;
import christmas.model.Menus;
import christmas.model.Orders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MenusService {
    // 샴페인 가격 조회
    public static int getChampagnePrice() {
        return Menus.getDrinks().stream()
                .filter(m -> m.getName().equals("샴페인"))
                .findFirst()
                .map(Menus::getPrice)
                .orElse(0);
    }

    public static String determineGiftedItem(Orders orders) {
        return orders.getTotalCost() >= Constants.CHAMPAGNE_GIFT_MIN_AMOUNT ? "샴페인 1개" : "";
    }

    // 모든 메뉴 목록 조회
    public static List<Menus> getAllMenus() {
        List<Menus> allMenus = new ArrayList<>();
        allMenus.addAll(Menus.getAppetizer());
        allMenus.addAll(Menus.getMainDishes());
        allMenus.addAll(Menus.getDesserts());
        allMenus.addAll(Menus.getDrinks());
        return allMenus;
    }

    // 특정 메뉴 조회
    public static Optional<Menus> getMenuByName(String name) {
        return getAllMenus().stream()
                .filter(m -> m.getName().equals(name))
                .findFirst();
    }
}
