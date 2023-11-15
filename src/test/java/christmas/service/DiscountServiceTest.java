package christmas.service;

import christmas.model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountServiceTest {

    private DiscountService discountService;


    @BeforeEach
    void setUp() {
        discountService = new DiscountService();
    }

    @Test
    @DisplayName("총 할인 금액 계산 테스트")
    void testCalculateTotalDiscount() {
        Order order = new Order(100000, 5, false, 2023, 4046, 1000, 1000);
        String giftedItem = "샴페인 1개";
        int giftedItemValue = 25000;

        int expectedTotalDiscount = 2023 + 4046 + 1000 + 1000 + 25000; // 각 할인 항목의 합
        int actualTotalDiscount = discountService.calculateTotalDiscount(order, giftedItem, giftedItemValue);

        assertEquals(expectedTotalDiscount, actualTotalDiscount, "총 할인 금액이 올바르게 계산되어야 합니다.");
    }


}
