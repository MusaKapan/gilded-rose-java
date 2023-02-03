package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SulfurasQualityChangeTest {

    @Test
    void shouldNotChangeQuality() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 12, 80);

        item.sellIn -= 1;
        item.quality = ItemQualityFunctions.calculateQualityForSulfuras(item.quality, item.sellIn);

        assertThat(item.quality).isEqualTo(80);
    }

    @Test
    void shouldResetQualityToEighty() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 12, 50);

        item.sellIn -= 1;
        item.quality = ItemQualityFunctions.calculateQualityForSulfuras(item.quality, item.sellIn);

        assertThat(item.quality).isEqualTo(80);
    }

}
