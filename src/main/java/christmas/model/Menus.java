package christmas.model;

import christmas.constant.Constants;

import java.util.ArrayList;
import java.util.List;

public class Menus {
    private String name;
    private int price;

    private static List<Menus> appetizer = new ArrayList<>();
    private static List<Menus> mainDishes = new ArrayList<>();
    private static List<Menus> desserts = new ArrayList<>();
    private static List<Menus> drinks = new ArrayList<>();

    static { //처음 한번 실행
        appetizer.add(new Menus("양송이수프", 6_000));
        appetizer.add(new Menus("타파스", 5_500));
        appetizer.add(new Menus("시저샐러드", 8_000));
        mainDishes.add(new Menus("티본스테이크", 55_000));
        mainDishes.add(new Menus("바비큐립", 54_000));
        mainDishes.add(new Menus("해산물파스타", 35_000));
        mainDishes.add(new Menus("크리스마스파스타", 25_000));
        desserts.add(new Menus("초코케이크", 15_000));
        desserts.add(new Menus("아이스크림", 5_000));
        drinks.add(new Menus("제로콜라", 3_000));
        drinks.add(new Menus("레드와인", 60_000));
        drinks.add(new Menus("샴페인", Constants.CHAMPAGNE_PRICE));
    }

    public Menus(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public static List<Menus> getAppetizer() {
        return appetizer;
    }

    public static List<Menus> getMainDishes() {
        return mainDishes;
    }

    public static List<Menus> getDesserts() {
        return desserts;
    }

    public static List<Menus> getDrinks() {
        return drinks;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
