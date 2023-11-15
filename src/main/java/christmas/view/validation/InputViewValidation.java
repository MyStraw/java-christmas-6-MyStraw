package christmas.view.validation;

import christmas.constant.Constants;
import christmas.model.Orders;
import christmas.view.InputView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputViewValidation {

    public static int day = 0;
    public int getValidVisitDay() {
        while (true) {
            try {
                day = InputView.getVisitDay(); // 사용자 입력을 문자열로 받음
                // 문자열을 정수로 변환
                if (day >= 1 && day <= 31) {
                    return day;
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            }
        }
    }

    public String getValidOrder() {
        while (true) {
            String order = InputView.getOrder();
            String orderPattern = "^(\\s*\\p{L}+-\\d+\\s*,\\s*)*\\p{L}+-\\d+\\s*$";
            Pattern pattern = Pattern.compile(orderPattern);
            Matcher matcher = pattern.matcher(order);
            if (matcher.matches()) {
                return order;
            }
            System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public void validateOrder(Orders orderResult) {
        if (orderResult.getTotalCost() < Constants.MIN_ORDER_AMOUNT) {
            System.out.println("[ERROR] 총주문 금액 10,000원 이상부터 이벤트가 적용됩니다.");
        }
        if (orderResult.isOnlyDrink()) {
            System.out.println("[ERROR] 음료만 주문할 순 없습니다.");
            return; // 음료만 주문한 경우 추가 검증 필요 없음
        }
        if (orderResult.getTotalItemsCount() > Constants.MAX_ITEM_COUNT) {
            System.out.println("[ERROR] 메뉴는 최대 20개까지만 주문할 수 있습니다.");
            return; // 주문 항목 수가 초과된 경우 추가 검증 필요 없음
        }
    }

    public int getDay() {
        return day;
    }
}

