package christmas.model;

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
}
