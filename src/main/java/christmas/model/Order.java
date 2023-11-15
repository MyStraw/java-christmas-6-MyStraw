package christmas.model;

import christmas.service.DayService;

import java.time.LocalDate;
import java.util.List;

public class Order {

    int totalCost;
    int totalItemsCount;
    boolean onlyDrink;
    int weekdayDiscount;
    int weekendDiscount;
    int ddayDiscount;
    int specialDiscount;

    public Order(int totalCost, int totalItemsCount, boolean onlyDrink, int weekdayDiscount, int weekendDiscount,
                int ddayDiscount, int specialDiscount) {
        this.totalCost = totalCost;
        this.totalItemsCount = totalItemsCount;
        this.onlyDrink = onlyDrink;
        this.weekdayDiscount = weekdayDiscount;
        this.weekendDiscount = weekendDiscount;
        this.ddayDiscount = ddayDiscount;
        this.specialDiscount = specialDiscount;
    }

    public static Order processOrder(String[] orderedItems, LocalDate visitDate, DayService discountCalculator) {
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

            for (List<Menu> menuList : List.of(Menu.getAppetizer(), Menu.getMainDishes(),
                    Menu.getDesserts(), Menu.getDrinks())) {
                for (Menu menuItem : menuList) {
                    if (menuItem.getName().equals(menuItemName)) {
                        totalCost += menuItem.getPrice() * quantity;
                        if (!menuList.equals(Menu.getDrinks())) {
                            onlyDrink = false;
                        }

                        if (menuList.equals(Menu.getDesserts()) && !isWeekend) {
                            weekdayDiscount += discountCalculator.calculateWeekdayDiscount(quantity);
                        } else if (menuList.equals(Menu.getMainDishes()) && isWeekend) {
                            weekendDiscount += discountCalculator.calculateWeekendDiscount(quantity);
                        }
                        break;
                    }
                }
            }
        }

        return new Order(totalCost, totalItemsCount, onlyDrink, weekdayDiscount, weekendDiscount,
                ddayDiscount, specialDiscount);
    }
}
