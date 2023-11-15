package christmas.model;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Day {

    public boolean isWeekDay(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SUNDAY || date.getDayOfWeek() == DayOfWeek.MONDAY
                || date.getDayOfWeek() == DayOfWeek.TUESDAY || date.getDayOfWeek() == DayOfWeek.WEDNESDAY
                || date.getDayOfWeek() == DayOfWeek.THURSDAY;
    }

    public boolean isWeekEnd(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day == DayOfWeek.FRIDAY || day == DayOfWeek.SATURDAY;
    }

    public boolean isSpecialDay(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SUNDAY || date.equals(LocalDate.of(date.getYear(), 12, 25));
    }

    public int calculateDdayDiscount(LocalDate date) {
        int startDayOfMonth = 1;
        int discountPerDay = 100;
        int initialDiscount = 1000;
        int dayOfMonth = date.getDayOfMonth();

        if (dayOfMonth <= 25) {
            return initialDiscount + (dayOfMonth - startDayOfMonth) * discountPerDay;
        }
        return 0;
    }

    // 평일 할인 계산
    public int calculateWeekdayDiscount(int dessertCount) {
        int weekdayDiscountPerDessert = 2023;
        return dessertCount * weekdayDiscountPerDessert;
    }

    // 주말 할인 계산
    public int calculateWeekendDiscount(int mainDishCount) {
        int weekendDiscountPerMainDish = 2023;
        return mainDishCount * weekendDiscountPerMainDish;
    }

    // 특별 할인 계산
    public int calculateSpecialDiscount(LocalDate date, boolean hasStar) {
        if (hasStar) {
            return 1000;
        }
        return 0;
    }
}
