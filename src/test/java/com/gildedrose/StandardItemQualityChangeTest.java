package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.Util.repeat;
import static org.assertj.core.api.Assertions.assertThat;

public class StandardItemQualityChangeTest {

    @Test
    void shouldDecreaseQualityByOne() {
        Item item = new Item("Standard item", 5, 10);

        item.sellIn -= 1;
        item.quality = ItemQualityFunctions.calculateQualityForStandardItem(item.quality, item.sellIn);

        assertThat(item.quality).isEqualTo(9);
    }

    @Test
    void shouldDecreaseQualityByDaysPassed() {
        Item item = new Item("Standard item", 5, 10);

        repeat(3, () -> {
            item.sellIn -= 1;
            item.quality = ItemQualityFunctions.calculateQualityForStandardItem(item.quality, item.sellIn);
        });

        assertThat(item.quality).isEqualTo(7);
    }

    @Test
    void shouldDecreaseQualityToZero() {
        Item item = new Item("Standard item", 5, 10);

        repeat(12, () -> {
            item.sellIn -= 1;
            item.quality = ItemQualityFunctions.calculateQualityForStandardItem(item.quality, item.sellIn);
        });

        assertThat(item.quality).isEqualTo(0);
    }

    @Test
    void shouldDecreaseQualityByTwo() {
        Item item = new Item("Standard item", 0, 10);

        item.sellIn -= 1;
        item.quality = ItemQualityFunctions.calculateQualityForStandardItem(item.quality, item.sellIn);

        assertThat(item.quality).isEqualTo(8);
    }

}
