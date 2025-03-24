package com.gildedrose;

import static com.gildedrose.ItemType.*;

import java.util.stream.Stream;

class GildedRose {
    // Can't touch this
    Item[] items;

    private static final Integer MAX_QUALITY = 50;
    private static final Integer MIN_QUALITY = 0;

    private static final Integer NEAR_EXPIRY = 10;
    private static final Integer VERY_NEAR_EXPIRY = 5;
    private static final Integer EXPIRED = 0;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (isPerishable(item)) {
                changeQuality(item, getExpiryRate(item));
            }

            if (item.name.equals(AGED_BRIE.getName())) {
                int qualityIncrease = isExpired(item) ? 2 : 1;
                changeQuality(item, qualityIncrease);
            }

            if (item.name.equals(BACKSTAGE_PASSES.getName())) {
                changeBackstagePassQuality(item);
            }

            if (hasSellIn(item)) {
                item.sellIn = item.sellIn - 1;
            }
        };
    }

    private void changeQuality(Item item, int delta) {
        int updatedQuality = item.quality + delta;
        item.quality = isOverMaxQuality(updatedQuality) ?
                MAX_QUALITY : isUnderMinQuality(updatedQuality) ?
                MIN_QUALITY : updatedQuality;
    }

    private void changeBackstagePassQuality(Item item) {
        int qualityIncrease = isVeryNearEventDate(item) ?
                3 : isNearEventDate(item) ?
                2 : isExpired(item) ?
                item.quality = MIN_QUALITY : 1;
        changeQuality(item, qualityIncrease);
    }

    private boolean isPerishable(Item item) {
        return Stream.of(AGED_BRIE.getName(), BACKSTAGE_PASSES.getName(), SULFURAS.getName())
                .noneMatch(specialItem -> specialItem.equals(item.name));
    }

    private int getExpiryRate(Item item) {
        int baseRate = isExpired(item) ? -2 : -1;
        return isConjured(item) ? baseRate * 2 : baseRate;
    }

    private boolean hasSellIn(Item item) {
        return !item.name.equals(SULFURAS.getName());
    }

    private boolean isNearEventDate(Item backstagePasses) {
        return backstagePasses.sellIn <= NEAR_EXPIRY && backstagePasses.sellIn > VERY_NEAR_EXPIRY;
    }

    private boolean isVeryNearEventDate(Item backstagePasses) {
        return backstagePasses.sellIn <= VERY_NEAR_EXPIRY && backstagePasses.sellIn > 0;
    }

    private boolean isExpired(Item item) {
        return item.sellIn <= EXPIRED;
    }

    private boolean isOverMaxQuality(int quality) {
        return quality > MAX_QUALITY;
    }

    private boolean isUnderMinQuality(int quality) {
        return quality < MIN_QUALITY;
    }

    private boolean isConjured(Item item) {
        return item.name.equals(CONJURED_MANA_CAKE.getName());
    }
}
