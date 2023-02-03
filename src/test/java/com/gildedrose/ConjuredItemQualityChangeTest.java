package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.Util.repeat;
import static org.assertj.core.api.Assertions.assertThat;

public class ConjuredItemQualityChangeTest {

    @Test
    void shouldDecreaseQualityByTwo() {
        Item item = new Item("Conjured item", 5, 10);

        item.sellIn -= 1;
        item.quality = ItemQualityFunctions.calculateQualityForConjuredItem(item.quality, item.sellIn);

        assertThat(item.quality).isEqualTo(8);
    }

    @Test
    void shouldDecreaseQualityByFour() {
        Item item = new Item("Conjured item", 0, 10);

        item.sellIn -= 1;
        item.quality = ItemQualityFunctions.calculateQualityForConjuredItem(item.quality, item.sellIn);

        assertThat(item.quality).isEqualTo(6);
    }

    @Test
    void shouldDecreaseQualityToZero() {
        Item item = new Item("Conjured item", 5, 10);

        repeat(5, () -> {
            item.sellIn -= 1;
            item.quality = ItemQualityFunctions.calculateQualityForConjuredItem(item.quality, item.sellIn);
        });

        assertThat(item.quality).isEqualTo(0);
    }

}
