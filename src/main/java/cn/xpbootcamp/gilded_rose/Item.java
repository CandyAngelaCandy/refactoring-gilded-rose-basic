package cn.xpbootcamp.gilded_rose;

public class Item {

    private final String name;

    private int sellIn;

    private int quality;

    public Item(String name, int sell_in, int quality) {
        this.name = name;
        this.sellIn = sell_in;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void updateItemQuality() {
        final String SULFURAS = "Sulfuras, Hand of Ragnaros";
        final String AGED_BRIE = "Aged Brie";
        final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

        if (name.equals(SULFURAS)) {
            return;
        }

        if (!name.equals(AGED_BRIE)
                && !name.equals(BACKSTAGE_PASSES)) {
            quality = quality - 1;
        } else {
            quality = quality + 1;

            if (name.equals(BACKSTAGE_PASSES)) {
                if (sellIn < 11) {
                    quality = quality + 1;
                }

                if (sellIn < 6) {
                    quality = quality + 1;
                }
            }
        }

        sellIn = sellIn - 1;

        if (sellIn < 0) {
            if (!name.equals(AGED_BRIE)) {
                if (!name.equals(BACKSTAGE_PASSES)) {
                    quality = quality - 1;
                } else {
                    quality = 0;
                }
            } else {
                quality = quality + 1;
            }
        }

        quality = Math.max(0, quality);
        if (quality > 50) {
            quality = 50;
        }
    }
}
