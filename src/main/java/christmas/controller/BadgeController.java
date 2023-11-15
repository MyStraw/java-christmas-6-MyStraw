package christmas.controller;

import christmas.service.BadgeService;

public class BadgeController {
    private final BadgeService badgeService;
    public BadgeController() {
        this.badgeService = new BadgeService();
    }
    public String determineBadge(int totalDiscount) {
        return badgeService.determineEventBadge(totalDiscount);
    }
}
