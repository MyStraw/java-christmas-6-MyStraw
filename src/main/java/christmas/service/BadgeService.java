package christmas.service;

import christmas.constant.Constants;

public class BadgeService {
    public static String determineEventBadge(int totalDiscount) {
        if (totalDiscount >= Constants.SANTA) {
            return "산타";
        } else if (totalDiscount >= Constants.TREE) {
            return "트리";
        } else if (totalDiscount >= Constants.STAR) {
            return "별";
        } else {
            return "없음";
        }
    }
}
