package christmas.service;

import christmas.model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {

    @BeforeEach
    void setUp() {
        OrderService orderService = new OrderService();
    }

    @Test
    void processOrderTest() {
        String[] orderedItems = new String[]{"해산물파스타-2", "레드와인-1"};
        LocalDate visitDate = LocalDate.of(2023, 12, 15);
        DayService dayService = new DayService();
        // OrderService를 이용한 주문 처리
        Order order = OrderService.processOrder(orderedItems, visitDate, dayService);
        assertNotNull(order);
        assertEquals(130000, order.getTotalCost());
        assertEquals(3, order.getTotalItemsCount());
        assertFalse(order.isOnlyDrink());
        assertEquals(0, order.getWeekdayDiscount());
        assertEquals(4046, order.getWeekendDiscount());
        assertEquals(2400, order.getDdayDiscount());
        assertEquals(0, order.getSpecialDiscount());
    }
}
