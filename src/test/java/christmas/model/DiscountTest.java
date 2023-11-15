package christmas.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountTest {

    private DecimalFormat decimalFormat = new DecimalFormat("#,###");

    @Test
    @DisplayName("D-day 할인 금액 계산")
    void testDdayDiscount() {
        Order order = new Order(10000, 5, false, 0, 0, 2000, 0);
        int discount = Discount.D_DAY_DISCOUNT.applyDiscount(order, "", 0, decimalFormat);
        assertEquals(2000, discount);
    }

    @Test
    @DisplayName("평일 할인 금액 계산")
    void testWeekdayDiscount() {
        Order order = new Order(10000, 5, false, 1000, 0, 0, 0);
        int discount = Discount.WEEKDAY_DISCOUNT.applyDiscount(order, "", 0, decimalFormat);
        assertEquals(1000, discount);
    }

    @Test
    @DisplayName("주말 할인 금액 계산")
    void testWeekendDiscount() {
        Order order = new Order(10000, 5, false, 0, 1500, 0, 0);
        int discount = Discount.WEEKEND_DISCOUNT.applyDiscount(order, "", 0, decimalFormat);
        assertEquals(1500, discount);
    }

    @Test
    @DisplayName("특별한 날 할인 금액 계산")
    void testSpecialDiscount() {
        Order order = new Order(10000, 5, false, 0, 0, 0, 1000);
        int discount = Discount.SPECIAL_DISCOUNT.applyDiscount(order, "", 0, decimalFormat);
        assertEquals(1000, discount);
    }

    @Test
    @DisplayName("증정 이벤트 금액 계산")
    void testGiftedItem() {
        Order order = new Order(120000, 5, false, 0, 0, 0, 0);
        int discount = Discount.GIFTED_ITEM.applyDiscount(order, "샴페인 1개", 25000, decimalFormat);
        assertEquals(25000, discount);
    }

}
