package christmas.controller;

import christmas.model.Orders;
import christmas.service.DayService;
import christmas.service.OrdersService;

import java.time.LocalDate;

public class OrdersController {
    private final OrdersService ordersService;
    private final DayService dayService;

    public OrdersController() {
        this.ordersService = new OrdersService();
        this.dayService = new DayService();
    }

    // 주문 처리
    public Orders processOrder(String[] orderedItems, LocalDate visitDate) {
        return ordersService.processOrder(orderedItems, visitDate, dayService);
    }

}
