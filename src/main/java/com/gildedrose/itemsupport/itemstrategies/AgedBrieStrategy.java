package com.gildedrose.itemsupport.itemstrategies;

import com.gildedrose.Item;
import static com.gildedrose.itemsupport.itemhelpers.ItemAttributeUpdater.decreaseSellIn;
import static com.gildedrose.itemsupport.itemhelpers.ItemAttributeUpdater.increaseQuality;
import static com.gildedrose.itemsupport.itemhelpers.ItemConditionChecker.isExpired;
import static com.gildedrose.itemsupport.itemhelpers.ItemConditionChecker.isOverMaxQuality;

public class AgedBrieStrategy extends AbstractItemStrategy {

    AgedBrieStrategy(Item item) {
        super(item);
    }

    @Override
    public void handleItem() {
        if (!isOverMaxQuality(getItem())) {
            increaseQuality(getItem());
        }

        decreaseSellIn(getItem());

        if (isExpired(getItem())) {
            if (!isOverMaxQuality(getItem())) {
                increaseQuality(getItem());
            }
        }
    }
}
