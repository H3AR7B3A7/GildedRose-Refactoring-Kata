package com.gildedrose.itemsupport.itemhelpers;

import com.gildedrose.Item;

public class ItemConditionChecker {
    private static final Integer MAX_QUALITY = 50;
    private static final Integer MIN_QUALITY = 0;

    private static final Integer NEAR_EXPIRY = 10;
    private static final Integer VERY_NEAR_EXPIRY = 5;
    private static final Integer EXPIRED = 0;

    private ItemConditionChecker() {}

    public static boolean isOverMaxQuality(Item item) {
        return item.quality >= MAX_QUALITY;
    }

    public static boolean isUnderMinQuality(Item item) {
        return item.quality <= MIN_QUALITY;
    }


    public static boolean isExpired(Item item) {
        return item.sellIn < EXPIRED;
    }

    public static boolean isVeryNearEventDate(Item item) {
        return item.sellIn <= VERY_NEAR_EXPIRY;
    }

    public static boolean isNearEventDate(Item item) {
        return item.sellIn <= NEAR_EXPIRY;
    }
}
