package christmas.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class DayControllerTest {

    private DayController dayController;

    @BeforeEach
    void setUp() {
        dayController = new DayController();
    }
    @Test
    @DisplayName("월요일은 평일이고 토요일은 평일이 아니다")
    void testIsWeekDay() {
        // 월요일은 평일
        assertTrue(dayController.isWeekDay(LocalDate.of(2023, 12, 4)));
        // 토요일은 평일이 아님
        assertFalse(dayController.isWeekDay(LocalDate.of(2023, 12, 2)));
    }

    @Test
    @DisplayName("토요일은 주말이고 일요일은 주말이 아니다")
    void testIsWeekEnd() {
        // 토요일은 주말
        assertTrue(dayController.isWeekEnd(LocalDate.of(2023, 12, 2)));
        // 월요일은 주말이 아님
        assertFalse(dayController.isWeekEnd(LocalDate.of(2023, 12, 4)));
    }

    @Test
    @DisplayName("일요일과 크리스마스는 특별한 날이다")
    void testIsSpecialDay() {
        // 크리스마스는 특별한 날
        assertTrue(dayController.isSpecialDay(LocalDate.of(2023, 12, 25)));
        // 평범한 날은 특별한 날이 아님
        assertFalse(dayController.isSpecialDay(LocalDate.of(2023, 12, 6)));
    }
}
