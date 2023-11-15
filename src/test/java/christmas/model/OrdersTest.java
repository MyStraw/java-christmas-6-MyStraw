package christmas.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrdersTest {

    @Test
    @DisplayName("주문이 잘 입력되는지 확인")
    void testOrderCreation() {
        int totalCost = 10000;
        int totalItemsCount = 5;
        boolean onlyDrink = true;
        int weekdayDiscount = 1000;
        int weekendDiscount = 500;
        int ddayDiscount = 200;
        int specialDiscount = 300;

        Orders order = new Orders(totalCost, totalItemsCount, onlyDrink,
                weekdayDiscount, weekendDiscount, ddayDiscount, specialDiscount);

        assertEquals(totalCost, order.totalCost);
        assertEquals(totalItemsCount, order.totalItemsCount);
        assertTrue(order.onlyDrink);
        assertEquals(weekdayDiscount, order.weekdayDiscount);
        assertEquals(weekendDiscount, order.weekendDiscount);
        assertEquals(ddayDiscount, order.ddayDiscount);
        assertEquals(specialDiscount, order.specialDiscount);
    }

}
