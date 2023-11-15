package christmas.model;

import java.text.DecimalFormat;

public enum Discount {
    D_DAY_DISCOUNT {
        @Override
        public int applyDiscount(Orders orderResult, String giftedItem, int giftedItemValue,
                                 DecimalFormat decimalFormat) {
            if (orderResult.ddayDiscount > 0) {
                System.out.println("크리스마스 디데이 할인: -" + decimalFormat.format(orderResult.ddayDiscount) + "원");
                return orderResult.ddayDiscount;
            }
            return 0;
        }
    },
    WEEKDAY_DISCOUNT {
        @Override
        public int applyDiscount(Orders orderResult, String giftedItem, int giftedItemValue,
                                 DecimalFormat decimalFormat) {
            if (orderResult.weekdayDiscount > 0) {
                System.out.println("평일 할인: -" + decimalFormat.format(orderResult.weekdayDiscount) + "원");
                return orderResult.weekdayDiscount;
            }
            return 0;
        }
    },

    WEEKEND_DISCOUNT {
        @Override
        public int applyDiscount(Orders orderResult, String giftedItem, int giftedItemValue,
                                 DecimalFormat decimalFormat) {
            if (orderResult.weekendDiscount > 0) {
                System.out.println("주말 할인: -" + decimalFormat.format(orderResult.weekendDiscount) + "원");
                return orderResult.weekendDiscount;
            }
            return 0;
        }
    },

    SPECIAL_DISCOUNT {
        @Override
        public int applyDiscount(Orders orderResult, String giftedItem, int giftedItemValue,
                                 DecimalFormat decimalFormat) {
            if (orderResult.specialDiscount > 0) {
                System.out.println("특별 할인: -" + decimalFormat.format(orderResult.specialDiscount) + "원");
                return orderResult.specialDiscount;
            }
            return 0;
        }
    },

    GIFTED_ITEM {
        @Override
        public int applyDiscount(Orders orderResult, String giftedItem, int giftedItemValue,
                                 DecimalFormat decimalFormat) {
            if (giftedItem.isEmpty()) {
                System.out.println("증정 이벤트: 없음");
                return 0;
            } else {
                System.out.println("증정 이벤트: -" + decimalFormat.format(giftedItemValue) + "원");
                return giftedItemValue;
            }
        }
    };

    public abstract int applyDiscount(Orders orderResult, String giftedItem, int giftedItemValue,
                                      DecimalFormat decimalFormat);
}
