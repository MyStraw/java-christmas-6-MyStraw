package christmas;

import christmas.constant.Constants;
import christmas.controller.BadgeController;
import christmas.controller.DiscountController;
import christmas.controller.MenusController;
import christmas.controller.OrdersController;
import christmas.model.Orders;
import christmas.util.StringUtil;
import christmas.view.OutputView;
import christmas.view.validation.InputViewValidation;

import java.time.LocalDate;


public class Application {
    public static void main(String[] args) {
        InputViewValidation validator = new InputViewValidation();
        int day = validator.getValidVisitDay();
        String order = validator.getValidOrder();

        String[] orderedItems = StringUtil.splitString(order, ",");
        LocalDate visitDate = LocalDate.of(Constants.YEAR, Constants.MONTH, day);

        OrdersController ordersController = new OrdersController();
        DiscountController discountController = new DiscountController();

        BadgeController badgeController = new BadgeController();
        Orders orderResult = ordersController.processOrder(orderedItems, visitDate);
        validator.validateOrder(orderResult);
        // 증정 이벤트 및 할인 계산
        String giftedItem =ordersController.determineGiftedItem(orderResult);
        MenusController menusController = new MenusController();
        int giftedItemValue = menusController.getChampagnePrice();
        int totalDiscount = discountController.calculateTotalDiscount(orderResult, giftedItem, giftedItemValue);
        // 결과 출력
        OutputView.printOrderSummary(day, orderedItems, orderResult, giftedItem, totalDiscount, discountController);
        // 최종 결제 금액 및 이벤트 배지 출력
        OutputView.printFinalPaymentAndBadge(orderResult, totalDiscount, giftedItemValue, badgeController);
    }
}




