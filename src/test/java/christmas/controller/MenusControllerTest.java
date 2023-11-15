package christmas.controller;

import christmas.model.Menus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class MenusControllerTest {
    private MenusController menusController;

    @BeforeEach
    void setUp() {
        menusController = new MenusController();
    }

    @Test
    @DisplayName("특정 메뉴가 있는지 확인")
    void testGetMenuByName() {
        String menuName = "티본스테이크";
        Optional<Menus> foundMenu = menusController.getMenuByName(menuName);
        assertTrue(foundMenu.isPresent());
        assertEquals(menuName, foundMenu.get().getName());
    }

    @Test
    @DisplayName("전메뉴 테스트")
    void testGetAllMenus() {
        List<Menus> allMenus = menusController.getAllMenus();
        assertFalse(allMenus.isEmpty());
    }

}
