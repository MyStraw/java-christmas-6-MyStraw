package christmas.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderTest {

    @Test
    void testOrderCreation() {
        int totalCost = 10000;
        int totalItemsCount = 5;
        boolean onlyDrink = true;
        int weekdayDiscount = 1000;
        int weekendDiscount = 500;
        int ddayDiscount = 200;
        int specialDiscount = 300;

        Order order = new Order(totalCost, totalItemsCount, onlyDrink,
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
