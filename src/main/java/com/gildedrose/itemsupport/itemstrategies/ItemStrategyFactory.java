package com.gildedrose.itemsupport.itemstrategies;

import com.gildedrose.Item;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum ItemStrategyFactory {
	AGED_BRIE("Aged Brie", AgedBrieStrategy::new),
	SULFURAS("Sulfuras, Hand of Ragnaros", SulfurasStrategy::new),
	BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert", BackstagePassesStrategy::new),
	CONJURED_MANA_CAKE("Conjured Mana Cake", ConjuredManaCakeStrategy::new),
	DEFAULT("Default Item", DefaultItemStrategy::new);

	private final String name;
	private final Function<Item, ItemStrategy> strategy;

	private static final Map<String, Function<Item, ItemStrategy>> ITEM_STRATEGY_MAP =
			java.util.Arrays.stream(values())
					.collect(Collectors.toMap(ItemStrategyFactory::getName, itemType -> itemType.strategy));

	ItemStrategyFactory(String name, Function<Item, ItemStrategy> strategy) {
		this.name = name;
		this.strategy = strategy;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}

	public static Function<Item, ItemStrategy> strategyByName(String name) {
		return ITEM_STRATEGY_MAP.getOrDefault(name, DEFAULT.strategy);
	}
}
