package christmas.controller;

import christmas.service.DayService;

import java.time.LocalDate;

public class DayController {
    private final DayService dayService;
    public DayController() {
        this.dayService = new DayService();
    }
    public boolean isWeekDay(LocalDate date) {
        return dayService.isWeekDay(date);
    }
    public boolean isWeekEnd(LocalDate date) {
        return dayService.isWeekEnd(date);
    }
    public boolean isSpecialDay(LocalDate date) {
        return dayService.isSpecialDay(date);
    }
}