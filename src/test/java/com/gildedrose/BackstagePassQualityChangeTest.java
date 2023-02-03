package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.Util.repeat;
import static org.assertj.core.api.Assertions.assertThat;

public class BackstagePassQualityChangeTest {

    @Test
    void shouldIncreaseQualityByOne() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 12, 10);

        item.sellIn -= 1;
        item.quality = ItemQualityFunctions.calculateQualityForBackstagePass(item.quality, item.sellIn);

        assertThat(item.quality).isEqualTo(11);
    }

    @Test
    void shouldIncreaseQualityByTwo() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10);

        item.sellIn -= 1;
        item.quality = ItemQualityFunctions.calculateQualityForBackstagePass(item.quality, item.sellIn);

        assertThat(item.quality).isEqualTo(12);
    }

    @Test
    void shouldIncreaseQualityByThree() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 10);

        item.sellIn -= 1;
        item.quality = ItemQualityFunctions.calculateQualityForBackstagePass(item.quality, item.sellIn);

        assertThat(item.quality).isEqualTo(13);
    }

    @Test
    void shouldSetPriceToZeroUponExpiry() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 10);

        repeat(10, () -> {
            item.sellIn -= 1;
            item.quality = ItemQualityFunctions.calculateQualityForBackstagePass(item.quality, item.sellIn);
        });

        assertThat(item.quality).isEqualTo(0);
    }

}
