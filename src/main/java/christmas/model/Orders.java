package christmas.model;

public class Orders {

    int totalCost;
    int totalItemsCount;
    boolean onlyDrink;
    int weekdayDiscount;
    int weekendDiscount;
    int ddayDiscount;
    int specialDiscount;

    public Orders(int totalCost, int totalItemsCount, boolean onlyDrink, int weekdayDiscount, int weekendDiscount,
                  int ddayDiscount, int specialDiscount) {
        this.totalCost = totalCost;
        this.totalItemsCount = totalItemsCount;
        this.onlyDrink = onlyDrink;
        this.weekdayDiscount = weekdayDiscount;
        this.weekendDiscount = weekendDiscount;
        this.ddayDiscount = ddayDiscount;
        this.specialDiscount = specialDiscount;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public int getTotalItemsCount() {
        return totalItemsCount;
    }

    public boolean isOnlyDrink() {
        return onlyDrink;
    }

    public int getWeekendDiscount(){
        return weekendDiscount;
    }

    public int getDdayDiscount() {
        return ddayDiscount;
    }

    public int getSpecialDiscount() {
        return specialDiscount;
    }

    public int getWeekdayDiscount() {
        return weekdayDiscount;
    }
}
