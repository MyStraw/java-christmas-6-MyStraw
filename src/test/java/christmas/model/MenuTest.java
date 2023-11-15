package christmas.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MenuTest {

    private void testMenuCreation(String name, int price) {
        Menu menuItem = new Menu(name, price);
        assertEquals(name, menuItem.getName());
        assertEquals(price, menuItem.getPrice());
    }

    @Test
    void testAppetizer() {
        testMenuCreation("시저샐러드", 8_000);
    }

    @Test
    void testMainDish() {
        testMenuCreation("해산물파스타", 35_000);
    }

    @Test
    void testDessert() {
        testMenuCreation("아이스크림", 5_000);
    }

    @Test
    void testDrink() {
        testMenuCreation("레드와인", 60_000);
    }



    private void testMenuList(List<Menu> menuList, int expectedSize, String expectedFirstItemName) {
        assertEquals(expectedSize, menuList.size());
        assertEquals(expectedFirstItemName, menuList.get(0).getName());
    }

    @Test
    void testGetAppetizers() {
        testMenuList(Menu.getAppetizer(), 3, "양송이수프");
    }

    @Test
    void testGetMainDishes() {
        testMenuList(Menu.getMainDishes(), 4, "티본스테이크");
    }

    @Test
    void testGetDesserts() {
        testMenuList(Menu.getDesserts(), 2, "초코케이크");
    }

    @Test
    void testGetDrinks() {
        testMenuList(Menu.getDrinks(), 3, "제로콜라");
    }

}
