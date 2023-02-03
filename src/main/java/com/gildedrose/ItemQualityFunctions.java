package com.gildedrose;

import static com.gildedrose.Util.clamp;

public final class ItemQualityFunctions {

    public static int calculateQualityForStandardItem(int currentQuality, int sellIn) {
        return clamp(0, 50, currentQuality - (sellIn > 0 ? 1 : 2));
    }

    public static int calculateQualityForAgedBrie(int currentQuality, int sellIn) {
        return clamp(0, 50, currentQuality + (sellIn > 0 ? 1 : 2));
    }

    public static int calculateQualityForSulfuras(int currentQuality, int sellIn) {
        return 80;
    }

    public static int calculateQualityForBackstagePass(int currentQuality, int sellIn) {
        if (sellIn < 0) return 0;
        if (sellIn <= 5) return clamp(0, 50, currentQuality + 3);
        if (sellIn <= 10) return clamp(0, 50, currentQuality + 2);
        return clamp(0, 50, currentQuality + 1);
    }

    public static int calculateQualityForConjuredItem(int currentQuality, int sellIn) {
        return clamp(0, 50, currentQuality - (sellIn > 0 ? 2 : 4));
    }



}
