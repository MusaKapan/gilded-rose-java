package com.gildedrose;

import java.util.function.BiFunction;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            item.sellIn -= getSellInDecreaseForItem(item.name);
            item.quality = getQualityCalculatorForItem(item.name).apply(item.quality, item.sellIn);
        }
    }

    private BiFunction<Integer, Integer, Integer> getQualityCalculatorForItem(String itemName) {
        if ("Aged Brie".equals(itemName)) return ItemQualityFunctions::calculateQualityForAgedBrie;
        if ("Backstage passes to a TAFKAL80ETC concert".equals(itemName)) return ItemQualityFunctions::calculateQualityForBackstagePass;
        if ("Sulfuras, Hand of Ragnaros".equals(itemName)) return ItemQualityFunctions::calculateQualityForSulfuras;
        if (itemName.contains("Conjured")) return ItemQualityFunctions::calculateQualityForConjuredItem;
        return ItemQualityFunctions::calculateQualityForStandardItem;
    }

    private int getSellInDecreaseForItem(String itemName) {
        return "Sulfuras, Hand of Ragnaros".equals(itemName) ? 0 : 1;
    }
}
