package com.gildedrose.itemsupport.itemstrategies;

import com.gildedrose.Item;

public abstract class AbstractItemStrategy implements ItemStrategy {
    private Item item;

    AbstractItemStrategy(Item item) {
        this.item = item;
    }

    Item getItem() {
        return item;
    }
}
