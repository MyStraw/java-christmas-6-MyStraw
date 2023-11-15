package christmas.view;

import christmas.constant.Constants;
import christmas.controller.BadgeController;
import christmas.model.Orders;
import christmas.service.DiscountService;
import christmas.service.MenusService;
import christmas.util.StringUtil;

public class OutputView {
    public static void printOrderSummary(int day, String[] orderedItems, Orders orders, String giftedItem, int totalDiscount, DiscountService discountService) {
        System.out.println("12월 " + day + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");
        System.out.println("<주문 메뉴>");
        for (String item : orderedItems) {
            String[] parts = StringUtil.parseMenuItem(item);
            System.out.println(parts[0] + " " + Integer.parseInt(parts[1]) + "개");
        }
        System.out.println("\n<할인 전 총주문 금액>");
        System.out.println(StringUtil.formatCurrency(orders.getTotalCost()));

        System.out.println("\n<증정 메뉴>");
        printGiftedItem(giftedItem);

        System.out.println("\n<혜택 내역>");
        if (orders.getTotalCost() >= Constants.MIN_ORDER_AMOUNT) {
            totalDiscount = discountService.calculateTotalDiscount(orders, giftedItem, MenusService.getChampagnePrice());
        } else {
            System.out.println("없음");
        }
        System.out.println("\n<총혜택 금액>");
        printTotalDiscount(totalDiscount);

    }

    public static void printFinalPaymentAndBadge(Orders orders, int totalDiscount, int giftedItemValue, BadgeController badgeController) {
        int predictedPayment = orders.getTotalCost() - totalDiscount + giftedItemValue;
        System.out.println("\n<할인 후 예상 결제 금액>");
        System.out.println(StringUtil.formatCurrency(predictedPayment));
        String eventBadge = badgeController.determineBadge(totalDiscount);
        System.out.println("\n<12월 이벤트 배지>");
        System.out.println(eventBadge);
    }

    private static void printGiftedItem(String giftedItem) {
        if (giftedItem.isEmpty()) {
            System.out.println("없음");
            return;
        }
        System.out.println(giftedItem);
    }

    private static void printTotalDiscount(int totalDiscount) {
        if (totalDiscount != 0) {
            System.out.println("-" + StringUtil.formatCurrency(totalDiscount));
            return;
        }
        System.out.println("없음");
    }
}
