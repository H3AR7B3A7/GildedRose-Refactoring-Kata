package com.gildedrose;

public enum ItemType {
	AGED_BRIE("Aged Brie"),
	SULFURAS("Sulfuras, Hand of Ragnaros"),
	BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert"),
	CONJURED_MANA_CAKE("Conjured Mana Cake");

	private final String name;

	ItemType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}
}
