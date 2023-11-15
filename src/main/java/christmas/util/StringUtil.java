package christmas.util;

import java.text.DecimalFormat;

public class StringUtil {
    public static String[] splitString(String input, String delimiter) {
        return input.split(delimiter);
    }

    public static String[] parseMenuItem(String orderItem) {
        return orderItem.trim().split("-");
    }

    public static String formatCurrency(int amount) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(amount) + "원";
    }
}
