package christmas.util;

import christmas.constant.Constants;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DateUtil {
    public static boolean isWeekDay(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return !(day == DayOfWeek.FRIDAY ||  day == DayOfWeek.SATURDAY);
    }

    public static boolean isWeekEnd(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day == DayOfWeek.FRIDAY ||  day == DayOfWeek.SATURDAY;
    }

    public static boolean isSpecialDay(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SUNDAY
                || date.equals(LocalDate.of(date.getYear(), 12, Constants.CHRISTMAS));
    }
}
