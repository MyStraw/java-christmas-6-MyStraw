package christmas.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class DayTest {

    private DayTest discountCalculator = new DayTest();

    @Test
    @DisplayName("월요일은 평일이고 토요일은 평일이 아니다")
    void testIsWeekDay() {
        // 월요일은 평일
        assertTrue(discountCalculator.isWeekDay(LocalDate.of(2023, 12, 4)));
        // 토요일은 평일이 아님
        assertFalse(discountCalculator.isWeekDay(LocalDate.of(2023, 12, 2)));
    }

    @Test
    @DisplayName("토요일은 주말이고 일요일은 주말이 아니다")
    void testIsWeekEnd() {
        // 토요일은 주말
        assertTrue(discountCalculator.isWeekEnd(LocalDate.of(2023, 12, 2)));
        // 일요일은 주말이 아님
        assertFalse(discountCalculator.isWeekEnd(LocalDate.of(2023, 12, 3)));
    }

    @Test
    @DisplayName("일요일과 크리스마스는 특별한 날이다")
    void testIsSpecialDay() {
        // 크리스마스는 특별한 날
        assertTrue(discountCalculator.isSpecialDay(LocalDate.of(2023, 12, 25)));
        // 일요일도 특별한 날
        assertTrue(discountCalculator.isSpecialDay(LocalDate.of(2023, 12, 24)));
        // 평범한 날은 특별한 날이 아님
        assertFalse(discountCalculator.isSpecialDay(LocalDate.of(2023, 12, 6)));
    }

    @Test
    @DisplayName("D-day 할인계산, 1일부터 25일까지 하루마다 100원씩")
    void testCalculateDdayDiscount() {
        // D-day 할인 계산
        assertEquals(1200, discountCalculator.calculateDdayDiscount(LocalDate.of(2023, 12, 12)));
        // D-day 범위를 벗어난 날짜
        assertEquals(0, discountCalculator.calculateDdayDiscount(LocalDate.of(2023, 12, 26)));
    }

    @Test
    @DisplayName("평일 할인 디저트 메뉴 1개당 2,023원 할인")
    void testCalculateWeekdayDiscount() {
        // 평일 할인 계산
        assertEquals(4046, discountCalculator.calculateWeekdayDiscount(2));
    }

    @Test
    @DisplayName("주말 할인 메인 메뉴 1개당 2,023원 할인")
    void testCalculateWeekendDiscount() {
        // 주말 할인 계산
        assertEquals(4046, discountCalculator.calculateWeekendDiscount(2));
    }

    @Test
    @DisplayName("특별한 날은 1000원 할인")
    void testCalculateSpecialDiscount() {
        // 특별한 날의 할인
        assertEquals(1000, discountCalculator.calculateSpecialDiscount(LocalDate.of(2023, 12, 25), true));
        // 특별하지 않은 날은 할인 없음
        assertEquals(0, discountCalculator.calculateSpecialDiscount(LocalDate.of(2023, 12, 26), false));
    }
}
