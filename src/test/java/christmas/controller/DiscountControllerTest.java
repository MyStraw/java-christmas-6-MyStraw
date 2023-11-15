package christmas.controller;

import christmas.model.Orders;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountControllerTest {
    private DiscountController discountController;
    private Orders orders;
    private String giftedItem;
    private int giftedItemValue;

    @BeforeEach
    void setUp() {
        discountController = new DiscountController();
        orders = new Orders(20000, 3, false, 2023, 2023, 1500, 1000); // 샘플 주문 데이터
        giftedItem = "샴페인";
        giftedItemValue = 25000; // 샘플 샴페인 가격
    }

    @Test
    @DisplayName("예상되는 할인금액 테스트")
    void testCalculateTotalDiscount() {
        int expectedDiscount = 2023 + 2023 + 1500 + 1000 + 25000; // 예상 할인 금액
        int actualDiscount = discountController.calculateTotalDiscount(orders, giftedItem, giftedItemValue);
        assertEquals(expectedDiscount, actualDiscount);
    }

    @Test
    @DisplayName("예상되는 할인금액 테스트2")
    void testCalculateTotalDiscount2() {
        discountController = new DiscountController();
        // 가상의 주문 데이터 설정
        orders = new Orders(50000, 3, false, 2023, 1000, 500, 0);
        String giftedItem = "샴페인 1개";
        int giftedItemValue = 25000; // 샴페인 가격 가정
        int totalDiscount = discountController.calculateTotalDiscount(orders, giftedItem, giftedItemValue);
        assertEquals(28523, totalDiscount); // 예상되는 할인 금액 검증
    }

}
