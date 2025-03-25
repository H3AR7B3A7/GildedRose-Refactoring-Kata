package com.gildedrose;

import com.gildedrose.itemsupport.itemstrategies.ItemStrategyFactory;

class GildedRose {

    // 🎵 Can't touch this! 🎵
    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemStrategyFactory.strategyByName(item.name)
                    .apply(item)
                    .handleItem();
        };
    }
}
