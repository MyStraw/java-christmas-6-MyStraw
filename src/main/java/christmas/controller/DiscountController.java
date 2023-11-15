package christmas.controller;

import christmas.model.Orders;
import christmas.service.DiscountService;

public class DiscountController {
    private final DiscountService discountService;
    public DiscountController() {
        this.discountService = new DiscountService();
    }
    public int calculateTotalDiscount(Orders order, String giftedItem, int giftedItemValue) {
        return discountService.calculateTotalDiscount(order, giftedItem, giftedItemValue);
    }
}
