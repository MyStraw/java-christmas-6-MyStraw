package christmas.model;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String name;
    private int price;

    private static List<Menu> appetizer = new ArrayList<>();
    private static List<Menu> mainDishes = new ArrayList<>();
    private static List<Menu> desserts = new ArrayList<>();
    private static List<Menu> drinks = new ArrayList<>();

    static { //처음 한번 실행
        // 에피타이저
        appetizer.add(new Menu("양송이수프", 6_000));
        appetizer.add(new Menu("타파스", 5_500));
        appetizer.add(new Menu("시저샐러드", 8_000));

        // 메인
        mainDishes.add(new Menu("티본스테이크", 55_000));
        mainDishes.add(new Menu("바비큐립", 54_000));
        mainDishes.add(new Menu("해산물파스타", 35_000));
        mainDishes.add(new Menu("크리스마스파스타", 25_000));

        // 디저트
        desserts.add(new Menu("초코케이크", 15_000));
        desserts.add(new Menu("아이스크림", 5_000));

        // 음료
        drinks.add(new Menu("제로콜라", 3_000));
        drinks.add(new Menu("레드와인", 60_000));
        drinks.add(new Menu("샴페인", 25_000));
    }

    public Menu(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public static List<Menu> getAppetizer() {
        return appetizer;
    }

    public static List<Menu> getMainDishes() {
        return mainDishes;
    }

    public static List<Menu> getDesserts() {
        return desserts;
    }

    public static List<Menu> getDrinks() {
        return drinks;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
