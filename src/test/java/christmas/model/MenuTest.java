package christmas.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MenuTest {

    @Test
    void testMenuItemCreation() {
        Menu menuItem = new Menu("시저샐러드", 8_000);
        assertEquals("시저샐러드", menuItem.getName());
        assertEquals(8000, menuItem.getPrice());
    }

    @Test
    void testGetters() {
        Menu menuItem = new Menu("해산물파스타", 35_000);
        assertEquals("해산물파스타", menuItem.getName());
        assertEquals(35_000, menuItem.getPrice());
    }

    @Test
    void testGetAppetizers() {
        List<Menu> appetizers = Menu.getAppetizer();
        // 예시: 에피타이저 목록의 크기를 테스트
        assertEquals(3, appetizers.size());
        // 예시: 특정 에피타이저의 이름을 테스트
        assertEquals("양송이수프", appetizers.get(0).getName());
    }

    @Test
    void testGetMainDishes() {
        List<Menu> mainDishes = Menu.getMainDishes();
        // 메인 요리 목록의 크기를 테스트
        assertEquals(4, mainDishes.size());
        // 특정 메인 요리의 이름을 테스트
        assertEquals("티본스테이크", mainDishes.get(0).getName());
    }

    @Test
    void testGetDesserts() {
        List<Menu> desserts = Menu.getDesserts();
        // 디저트 목록의 크기를 테스트
        assertEquals(2, desserts.size());
        // 특정 디저트의 이름을 테스트
        assertEquals("초코케이크", desserts.get(0).getName());
    }

    @Test
    void testGetDrinks() {
        List<Menu> drinks = Menu.getDrinks();
        // 음료 목록의 크기를 테스트
        assertEquals(3, drinks.size());
        // 특정 음료의 이름을 테스트
        assertEquals("제로콜라", drinks.get(0).getName());
    }

}
