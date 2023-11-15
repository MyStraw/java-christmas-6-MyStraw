package christmas.view.validation;

import christmas.constant.Constants;
import christmas.model.Orders;
import christmas.view.InputView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputViewValidation {

    public int getValidVisitDay() {
        while (true) {
            int day = InputView.getVisitDay();
            if (day >= 1 && day <= 31) {
                return day;
            }
            else {
                System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            }
        }
    }

    public String getValidOrder() {
        while (true) {
            String order = InputView.getOrder();
            // 주문 유효성 검사: 정규표현식을 사용하여 형식 확인
            String orderPattern = "^(\\s*\\p{L}+-\\d+\\s*,\\s*)*\\p{L}+-\\d+\\s*$";
            Pattern pattern = Pattern.compile(orderPattern);
            Matcher matcher = pattern.matcher(order);
            if (matcher.matches()) {
                return order;
            } else {
                System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }

    public void validateOrder(Orders orderResult) {
        if (orderResult.getTotalCost() < Constants.MIN_ORDER_AMOUNT) {
            System.out.println("[ERROR] 총주문 금액 10,000원 이상부터 이벤트가 적용됩니다.");
        }
        if (orderResult.isOnlyDrink()) {
            System.out.println("[ERROR] 음료만 주문할 순 없습니다.");
        }
        if (orderResult.getTotalItemsCount() > Constants.MAX_ITEM_COUNT) {
            System.out.println("[ERROR] 메뉴는 최대 20개까지만 주문할 수 있습니다.");
        }
    }
}

