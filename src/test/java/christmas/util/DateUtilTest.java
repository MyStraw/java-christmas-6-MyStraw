package christmas.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DateUtilTest {
    @Test
    @DisplayName("평일인지 판단하기")
    void isWeekDay() {
        LocalDate weekday = LocalDate.of(2023, 12, 3); // 일요일
        assertTrue(DateUtil.isWeekDay(weekday));
    }

    @Test
    @DisplayName("주말인지 판단하기")
    void isWeekEnd() {
        LocalDate weekend = LocalDate.of(2023, 12, 2); // 토요일
        assertTrue(DateUtil.isWeekEnd(weekend));
    }


    @ParameterizedTest
    @DisplayName("특별한 날인지 판단하기")
    @ValueSource(strings = {"2023-12-25", "2023-12-24"})
    void isSpecialDay(String date) {
        LocalDate localDate = LocalDate.parse(date);
        assertTrue(DateUtil.isSpecialDay(localDate));
    }
}
