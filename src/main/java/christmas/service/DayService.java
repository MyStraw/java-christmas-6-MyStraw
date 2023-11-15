package christmas.service;

import christmas.constant.Constants;
import christmas.util.DateUtil;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DayService {

    // 월요일부터 금요일까지를 평일로 판단
    public boolean isWeekDay(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return !(day == DayOfWeek.FRIDAY || day == DayOfWeek.SATURDAY);
    }

    // 토요일과 일요일을 주말로 판단
    public boolean isWeekEnd(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day == DayOfWeek.FRIDAY || day == DayOfWeek.SATURDAY;
    }

    // 특별한 날을 판단 (일요일 또는 크리스마스)
    public boolean isSpecialDay(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SUNDAY || date.equals(LocalDate.of(date.getYear(), 12, Constants.CHRISTMAS));
    }

    // D-day 할인 계산
    public int calculateDdayDiscount(LocalDate date) {
        int startDayOfMonth = 1;
        int discountPerDay = Constants.DISCOUNT_PER_DAY;
        int initialDiscount = Constants.SPECIAL_INITIAL_DISCOUNT;
        int dayOfMonth = date.getDayOfMonth();

        if (dayOfMonth <= Constants.CHRISTMAS) {
            return initialDiscount + (dayOfMonth - startDayOfMonth) * discountPerDay;
        }
        return 0;
    }

    // 평일 할인 계산 (디저트 메뉴)
    public int calculateWeekdayDiscount(int dessertCount) {
        int weekdayDiscountPerDessert = Constants.WEEKDAY_DISCOUNT_PER_DESSERT;
        return dessertCount * weekdayDiscountPerDessert;
    }

    // 주말 할인 계산 (메인 메뉴)
    public int calculateWeekendDiscount(int mainDishCount) {
        int weekendDiscountPerMainDish = Constants.WEEKEND_DISCOUNT_PER_MAIN_DISH;
        return mainDishCount * weekendDiscountPerMainDish;
    }

    // 특별할인 계산
    public int calculateSpecialDiscount(LocalDate date, boolean hasStar) {
        if (hasStar) {
            return Constants.SPECIAL_INITIAL_DISCOUNT;
        }
        return 0;
    }
}
