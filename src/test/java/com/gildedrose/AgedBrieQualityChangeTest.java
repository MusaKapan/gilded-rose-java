package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.Util.repeat;
import static org.assertj.core.api.Assertions.assertThat;

public class AgedBrieQualityChangeTest {

    @Test
    void shouldIncreasePriceByOne() {
        Item item = new Item("Aged Brie", 5, 10);

        item.sellIn -= 1;
        item.quality = ItemQualityFunctions.calculateQualityForAgedBrie(item.quality, item.sellIn);

        assertThat(item.quality).isEqualTo(11);
    }

    @Test
    void shouldIncreasePriceByDaysPassed() {
        Item item = new Item("Aged Brie", 5, 10);

        repeat(3, () -> {
            item.sellIn -= 1;
            item.quality = ItemQualityFunctions.calculateQualityForAgedBrie(item.quality, item.sellIn);
        });

        assertThat(item.quality).isEqualTo(13);
    }

    @Test
    void shouldIncreasePriceToMaximum() {
        Item item = new Item("Aged Brie", 5, 10);

        repeat(30, () -> {
            item.sellIn -= 1;
            item.quality = ItemQualityFunctions.calculateQualityForAgedBrie(item.quality, item.sellIn);
        });

        assertThat(item.quality).isEqualTo(50);
    }

    @Test
    void shouldIncreasePriceByTwo() {
        Item item = new Item("Aged Brie", 0, 10);

        item.sellIn -= 1;
        item.quality = ItemQualityFunctions.calculateQualityForAgedBrie(item.quality, item.sellIn);

        assertThat(item.quality).isEqualTo(12);
    }

}
