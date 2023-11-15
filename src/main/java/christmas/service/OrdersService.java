package christmas.service;

import christmas.model.Menus;
import christmas.model.Orders;

import java.time.LocalDate;
import java.util.List;

public class OrdersService {
    public static Orders processOrder(String[] orderedItems, LocalDate visitDate, DayService discountCalculator) {
        int totalCost = 0;
        int totalItemsCount = 0;
        boolean onlyDrink = true;
        int weekdayDiscount = 0;
        int weekendDiscount = 0;
        int ddayDiscount = discountCalculator.calculateDdayDiscount(visitDate);
        int specialDiscount = 0;

        if (discountCalculator.isSpecialDay(visitDate)) {
            specialDiscount = discountCalculator.calculateSpecialDiscount(visitDate, true);
        }

        boolean isWeekend = discountCalculator.isWeekEnd(visitDate);

        for (String item : orderedItems) {
            String[] parts = item.trim().split("-");
            String menuItemName = parts[0];
            int quantity = Integer.parseInt(parts[1]);
            totalItemsCount += quantity;

            for (List<Menus> menuList : List.of(Menus.getAppetizer(), Menus.getMainDishes(),
                    Menus.getDesserts(), Menus.getDrinks())) {
                for (Menus menuItem : menuList) {
                    if (menuItem.getName().equals(menuItemName)) {
                        totalCost += menuItem.getPrice() * quantity;
                        if (!menuList.equals(Menus.getDrinks())) {
                            onlyDrink = false;
                        }

                        if (menuList.equals(Menus.getDesserts()) && !isWeekend) {
                            weekdayDiscount += discountCalculator.calculateWeekdayDiscount(quantity);
                        } else if (menuList.equals(Menus.getMainDishes()) && isWeekend) {
                            weekendDiscount += discountCalculator.calculateWeekendDiscount(quantity);
                        }
                        break;
                    }
                }
            }
        }

        return new Orders(totalCost, totalItemsCount, onlyDrink, weekdayDiscount, weekendDiscount,
                ddayDiscount, specialDiscount);
    }
}
