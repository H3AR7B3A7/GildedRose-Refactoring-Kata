package com.gildedrose.itemsupport.itemstrategies;

import com.gildedrose.Item;
import static com.gildedrose.itemsupport.itemhelpers.ItemAttributeUpdater.decreaseSellIn;
import static com.gildedrose.itemsupport.itemhelpers.ItemAttributeUpdater.decreaseQualityBy;
import static com.gildedrose.itemsupport.itemhelpers.ItemConditionChecker.isExpired;

public class ConjuredManaCakeStrategy extends AbstractItemStrategy {

    ConjuredManaCakeStrategy(Item item) {
        super(item);
    }

    @Override
    public void handleItem() {
        decreaseQualityBy(getItem(), 2);

        decreaseSellIn(getItem());

        if (isExpired(getItem())) {
            decreaseQualityBy(getItem(), 2);
        }
    }
}
