package com.gildedrose.itemsupport.itemhelpers;

import com.gildedrose.Item;
import static com.gildedrose.itemsupport.itemhelpers.ItemConditionChecker.isOverMaxQuality;
import static com.gildedrose.itemsupport.itemhelpers.ItemConditionChecker.isUnderMinQuality;

public class ItemAttributeUpdater {
    private ItemAttributeUpdater() {}

    public static void decreaseQuality(Item item) {
        item.quality--;
    }

    public static void decreaseSellIn(Item item) {
        item.sellIn--;
    }

    public static void increaseQuality(Item item) {
        item.quality++;
    }

    public static void decreaseQualityBy(Item item, int delta) {
        int counter = 0;
        while (counter++ < delta) {
            tryDecreasingQuality(item);
        }
    }

    private static void tryDecreasingQuality(Item item) {
        if (!isUnderMinQuality(item)) {
            decreaseQuality(item);
        }
    }

    public static void increaseQualityBy(Item item, int delta) {
        int counter = 0;
        while (counter++ < delta) {
            tryIncreasingQuality(item);
        }
    }

    private static void tryIncreasingQuality(Item item) {
        if (!isOverMaxQuality(item)) {
            increaseQuality(item);
        }
    }
}
