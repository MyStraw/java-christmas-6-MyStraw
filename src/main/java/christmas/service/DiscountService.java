package christmas.service;

import christmas.model.Discount;
import christmas.model.Order;

import java.text.DecimalFormat;

public class DiscountService {
    public int calculateTotalDiscount(Order order, String giftedItem, int giftedItemValue) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        int totalDiscount = 0;
        totalDiscount += Discount.D_DAY_DISCOUNT.applyDiscount(order, giftedItem, giftedItemValue, decimalFormat);
        totalDiscount += Discount.WEEKDAY_DISCOUNT.applyDiscount(order, giftedItem, giftedItemValue, decimalFormat);
        totalDiscount += Discount.WEEKEND_DISCOUNT.applyDiscount(order, giftedItem, giftedItemValue, decimalFormat);
        totalDiscount += Discount.SPECIAL_DISCOUNT.applyDiscount(order, giftedItem, giftedItemValue, decimalFormat);
        totalDiscount += Discount.GIFTED_ITEM.applyDiscount(order, giftedItem, giftedItemValue, decimalFormat);
        return totalDiscount;
    }
}