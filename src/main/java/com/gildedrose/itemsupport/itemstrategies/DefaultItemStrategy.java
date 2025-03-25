package com.gildedrose.itemsupport.itemstrategies;

import com.gildedrose.Item;
import static com.gildedrose.itemsupport.itemhelpers.ItemAttributeUpdater.decreaseQuality;
import static com.gildedrose.itemsupport.itemhelpers.ItemAttributeUpdater.decreaseSellIn;
import static com.gildedrose.itemsupport.itemhelpers.ItemConditionChecker.isExpired;
import static com.gildedrose.itemsupport.itemhelpers.ItemConditionChecker.isUnderMinQuality;

public class DefaultItemStrategy extends AbstractItemStrategy {

    DefaultItemStrategy(Item item) {
        super(item);
    }

    @Override
    public void handleItem() {
        if (!isUnderMinQuality(getItem())) {
            decreaseQuality(getItem());
        }

        decreaseSellIn(getItem());

        if (isExpired(getItem())) {
            if (!isUnderMinQuality(getItem())) {
                decreaseQuality(getItem());
            }
        }
    }
}
