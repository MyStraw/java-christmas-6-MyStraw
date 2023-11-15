package christmas.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MenusTest {

    private void testMenuCreation(String name, int price) {
        Menus menuItem = new Menus(name, price);
        assertEquals(name, menuItem.getName());
        assertEquals(price, menuItem.getPrice());
    }

    @Test
    @DisplayName("에피타이저 메뉴 확인")
    void testAppetizer() {
        testMenuCreation("시저샐러드", 8_000);
    }

    @Test
    @DisplayName("메인 메뉴 확인")
    void testMainDish() {
        testMenuCreation("해산물파스타", 35_000);
    }

    @Test
    @DisplayName("디저트 메뉴 확인")
    void testDessert() {
        testMenuCreation("아이스크림", 5_000);
    }

    @Test
    @DisplayName("음료 메뉴 확인")
    void testDrink() {
        testMenuCreation("레드와인", 60_000);
    }



    private void testMenuList(List<Menus> menuList, int expectedSize, String expectedFirstItemName) {
        assertEquals(expectedSize, menuList.size());
        assertEquals(expectedFirstItemName, menuList.get(0).getName());
    }

    @Test
    @DisplayName("에피타이저 메뉴 개수 확인")
    void testGetAppetizers() {
        testMenuList(Menus.getAppetizer(), 3, "양송이수프");
    }

    @Test
    @DisplayName("메인 메뉴 개수 확인")
    void testGetMainDishes() {
        testMenuList(Menus.getMainDishes(), 4, "티본스테이크");
    }

    @Test
    @DisplayName("디저트 메뉴 개수 확인")
    void testGetDesserts() {
        testMenuList(Menus.getDesserts(), 2, "초코케이크");
    }

    @Test
    @DisplayName("음료 메뉴 개수 확인")
    void testGetDrinks() {
        testMenuList(Menus.getDrinks(), 3, "제로콜라");
    }

}
