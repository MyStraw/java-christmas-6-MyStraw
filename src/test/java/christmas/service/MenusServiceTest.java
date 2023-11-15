package christmas.service;

import christmas.model.Menus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
public class MenusServiceTest {
    @Test
    @DisplayName("샴페인 가격 확인")
    void getChampagnePriceReturnsCorrectPrice() {
        int champagnePrice = MenusService.getChampagnePrice();
        assertEquals(25000, champagnePrice);
    }

    @Test
    @DisplayName("모든 메뉴 종류가 4개 이상인지 확인")
    void getAllMenusReturnsAllMenus() {
        List<Menus> allMenus = MenusService.getAllMenus();
        assertFalse(allMenus.isEmpty());
        assertTrue(allMenus.size() > 4); // 최소 4개 이상의 메뉴가 있어야 함
    }

    @Test
    @DisplayName("특정 메뉴의 가격을 조회")
    void getMenuByNameReturnsCorrectMenu() {
        Optional<Menus> menu = MenusService.getMenuByName("티본스테이크");
        assertTrue(menu.isPresent());
        assertEquals(55000, menu.get().getPrice());
    }

}
