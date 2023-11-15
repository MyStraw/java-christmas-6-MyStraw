package christmas.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BadgeControllerTest {
    private BadgeController badgeController;

    @BeforeEach
    void setUp() {
        badgeController = new BadgeController();
    }

    @Test
    @DisplayName("혜택금액당 알맞은 뱃지인지 확인")
    void testDetermineBadge() {
        assertEquals("산타", badgeController.determineBadge(25000));
        assertEquals("트리", badgeController.determineBadge(15000));
        assertEquals("별", badgeController.determineBadge(6000));
        assertEquals("없음", badgeController.determineBadge(3000));
    }
}
