package christmas.controller;

import christmas.model.Orders;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class OrdersControllerTest {

    private OrdersController ordersController;

    @BeforeEach
    void setUp() {
        ordersController = new OrdersController();
    }

    @Test
    @DisplayName("해당 날짜와 주문입력에 대해 할인이 맞게 계산되는지 확인")
    void testProcessOrder() {
        String[] orderedItems = {"해산물파스타-2", "레드와인-1"};
        LocalDate visitDate = LocalDate.of(2023, 12, 15);
        Orders orders = ordersController.processOrder(orderedItems, visitDate);
        assertNotNull(orders);
        assertEquals(130000, orders.getTotalCost());
        assertEquals(3, orders.getTotalItemsCount());
        assertFalse(orders.isOnlyDrink());
    }
}
