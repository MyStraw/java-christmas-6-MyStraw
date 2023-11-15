package christmas.service;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class DayServiceTest {

    private DayService dayCalculation = new DayService();

    @ParameterizedTest
    @CsvSource({
            "2023-12-4, true",  // 월요일은 평일
            "2023-12-2, false"  // 토요일은 평일이 아님
    })
    @DisplayName("월요일은 평일이고 토요일은 평일이 아니다")
    void testIsWeekDay(LocalDate date, boolean expected) {
        assertEquals(expected, dayCalculation.isWeekDay(date));
    }

    @ParameterizedTest
    @CsvSource({
            "2023-12-2, true",  // 토요일은 주말
            "2023-12-3, false"  // 일요일은 주말이 아님
    })
    @DisplayName("토요일은 주말이고 일요일은 주말이 아니다")
    void testIsWeekEnd(LocalDate date, boolean expected) {
        assertEquals(expected, dayCalculation.isWeekEnd(date));
    }

    @ParameterizedTest
    @CsvSource({
            "2023-12-25, true",  // 크리스마스는 특별한 날
            "2023-12-24, true",  // 일요일도 특별한 날
            "2023-12-6, false"   // 평범한 날은 특별한 날이 아님
    })
    @DisplayName("일요일과 크리스마스는 특별한 날이다")
    void testIsSpecialDay(LocalDate date, boolean expected) {
        assertEquals(expected, dayCalculation.isSpecialDay(date));
    }

    @ParameterizedTest
    @CsvSource({
            "2023-12-12, 2100", // D-day 할인 계산
            "2023-12-26, 0"     // D-day 범위를 벗어난 날짜
    })
    @DisplayName("D-day 할인계산")
    void testCalculateDdayDiscount(LocalDate date, int expectedDiscount) {
        assertEquals(expectedDiscount, dayCalculation.calculateDdayDiscount(date));
    }

    @Test
    @DisplayName("평일 할인 디저트 메뉴 1개당 2,023원 할인")
    void testCalculateWeekdayDiscount() {
        // 평일 할인 계산
        assertEquals(4046, dayCalculation.calculateWeekdayDiscount(2));
    }

    @Test
    @DisplayName("주말 할인 메인 메뉴 1개당 2,023원 할인")
    void testCalculateWeekendDiscount() {
        // 주말 할인 계산
        assertEquals(4046, dayCalculation.calculateWeekendDiscount(2));
    }

    @ParameterizedTest
    @CsvSource({
            "2023-12-25, true, 1000",  // 특별한 날의 할인
            "2023-12-26, false, 0"     // 특별하지 않은 날은 할인 없음
    })
    @DisplayName("특별한 날은 1000원 할인")
    void testCalculateSpecialDiscount(LocalDate date, boolean hasStar, int expectedDiscount) {
        assertEquals(expectedDiscount, dayCalculation.calculateSpecialDiscount(date, hasStar));
    }
}
