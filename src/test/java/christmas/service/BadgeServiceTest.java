package christmas.service;

import christmas.constant.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BadgeServiceTest {
    @ParameterizedTest
    @DisplayName("금액별 배지 맞는지 확인")
    @ValueSource(ints = {7000, 3000})
    void isSpecialDay(int totalDiscount) {
        String expectedBadge;
        if (totalDiscount >= Constants.SANTA) {
            expectedBadge = "산타";
        } else if (totalDiscount >= Constants.TREE) {
            expectedBadge = "트리";
        } else if (totalDiscount >= Constants.STAR) {
            expectedBadge = "별";
        } else {
            expectedBadge = "없음";
        }

        String badge = BadgeService.determineEventBadge(totalDiscount);
        assertEquals(expectedBadge, badge);
    }
}
