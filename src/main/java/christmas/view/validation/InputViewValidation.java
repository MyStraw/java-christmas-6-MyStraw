package christmas.view.validation;

import christmas.view.InputView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputViewValidation {

    public static int getValidVisitDay() {
        while (true) {
            try {
                int day = InputView.getVisitDay();
                // 날짜 유효성 검사: 숫자 범위 확인
                if (day >= 1 && day <= 31) {
                    return day;
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            }
        }
    }

    public static String getValidOrder() {
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
}
