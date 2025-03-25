package com.gildedrose.itemsupport.itemstrategies;

import com.gildedrose.Item;
import static com.gildedrose.itemsupport.itemhelpers.ItemAttributeUpdater.decreaseSellIn;
import static com.gildedrose.itemsupport.itemhelpers.ItemAttributeUpdater.increaseQuality;
import static com.gildedrose.itemsupport.itemhelpers.ItemAttributeUpdater.increaseQualityBy;
import static com.gildedrose.itemsupport.itemhelpers.ItemConditionChecker.isExpired;
import static com.gildedrose.itemsupport.itemhelpers.ItemConditionChecker.isNearEventDate;
import static com.gildedrose.itemsupport.itemhelpers.ItemConditionChecker.isVeryNearEventDate;


public class BackstagePassesStrategy extends AbstractItemStrategy {

    BackstagePassesStrategy(Item item) {
        super(item);
    }

    @Override
    public void handleItem() {
        if (isVeryNearEventDate(getItem())) {
            increaseQualityBy(getItem(), 3);
        } else if (isNearEventDate(getItem())) {
            increaseQualityBy(getItem(), 2);
        } else {
            increaseQuality(getItem());
        }

        decreaseSellIn(getItem());

        if (isExpired(getItem())) {
            getItem().quality = 0;
        }
    }
}
