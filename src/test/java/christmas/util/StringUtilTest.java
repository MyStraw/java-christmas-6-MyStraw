package christmas.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringUtilTest {
    @Test
    @DisplayName("메뉴 입력 전체에서 메뉴별로 나누기")
    void splitString() {
        String testString = "해산물파스타-2,레드와인-1";
        String[] result = StringUtil.splitString(testString, ",");
        assertArrayEquals(new String[]{"해산물파스타-2", "레드와인-1"}, result);
    }

    @Test
    @DisplayName("메뉴별 수량 파악하기")
    void parseMenuItem() {
        String testItem = "해산물파스타-2";
        String[] result = StringUtil.parseMenuItem(testItem);
        assertArrayEquals(new String[]{"해산물파스타", "2"}, result);
    }

    @Test
    @DisplayName("화폐단위 추가 및 1000단위 끊어일기 표시")
    void formatCurrency() {
        int amount = 25000;
        String formatted = StringUtil.formatCurrency(amount);
        assertEquals("25,000원", formatted);
    }
}
