package christmas;

import christmas.constant.Constants;
import christmas.controller.BadgeController;
import christmas.model.Orders;
import christmas.service.DayService;
import christmas.service.DiscountService;
import christmas.service.MenusService;
import christmas.service.OrdersService;
import christmas.util.StringUtil;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {

        int day = InputView.getVisitDay();
        String order = InputView.getOrder();

        String[] orderedItems = StringUtil.splitString(order, ",");
        LocalDate visitDate = LocalDate.of(2023, 12, day);

        OrdersService ordersService = new OrdersService();
        DiscountService discountService = new DiscountService();
        BadgeController badgeController = new BadgeController();
        Orders orderResult = ordersService.processOrder(orderedItems, visitDate, new DayService());
        // 증정 이벤트 및 할인 계산
        String giftedItem = determineGiftedItem(orderResult);
        int giftedItemValue = MenusService.getChampagnePrice();
        int totalDiscount = discountService.calculateTotalDiscount(orderResult, giftedItem, giftedItemValue);
        // 결과 출력
        OutputView.printOrderSummary(day, orderedItems, orderResult, giftedItem, totalDiscount, discountService);
        // 최종 결제 금액 및 이벤트 배지 출력
        OutputView.printFinalPaymentAndBadge(orderResult, totalDiscount, giftedItemValue, badgeController);
    }
    private static String determineGiftedItem(Orders orders) {
        if (orders.getTotalCost() >= Constants.CHAMPAGNE_GIFT_MIN_AMOUNT) {
            return "샴페인 1개";
        }
        return "";
    }
}




