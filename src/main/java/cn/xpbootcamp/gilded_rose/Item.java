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

        sellIn = sellIn - 1;

        if (name.equals(BACKSTAGE_PASSES)) {
            updateBackstagePassesQuality();
            return;
        }

        if (name.equals(AGED_BRIE)) {
            updateAgedBrieQuality();
            return;
        }

        updateNormalItemQuality();
    }

    private void updateNormalItemQuality() {
        quality = quality - 1;
        if (sellIn < 0) {
            quality = quality - 1;
        }
        quality = Math.max(0, quality);
    }

    private void updateAgedBrieQuality() {
        quality = quality + 1;
        if (sellIn < 0) {
            quality = quality + 1;
        }
        quality = Math.min(50, quality);
    }

    private void updateBackstagePassesQuality() {
        if (sellIn < 0) {
            quality = 0;
        } else if (sellIn < 5) {
            quality = quality + 3;
        } else if (sellIn < 10) {
            quality = quality + 2;
        } else {
            quality = quality + 1;
        }
        quality = Math.min(50, quality);
    }
}
