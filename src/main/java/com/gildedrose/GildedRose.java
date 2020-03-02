package com.gildedrose;

class GildedRose {

  private static final String AGED_BRIE_ROSE = "Aged Brie";
  private static final String BACKSTAGE_PASSES_ROSE = "Backstage passes to a TAFKAL80ETC concert";
  private static final String SULFURAS_ROSE = "Sulfuras, Hand of Ragnaros";

  public Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void update_quality() {
    for (Item item : items) {
      updateSellIn(item);
      updateQuality(item);
    }
  }

  private void updateQuality(Item item) {
    switch (item.name) {
      case SULFURAS_ROSE:
        return;
      case AGED_BRIE_ROSE:
        if (item.sell_in < 0 && item.quality < 50) {
          item.quality = item.quality + 1;
        }
        if (item.quality < 50) {
          item.quality = item.quality + 1;
        }
        return;
      case BACKSTAGE_PASSES_ROSE:
        if (item.quality < 50) {
          item.quality = item.quality + 1;
        }
        updateBackstageRoseQuality(item);
        return;
      default:
        if (item.quality > 0) {
          item.quality = item.quality - 1;
          if (item.sell_in < 0) {
            item.quality = item.quality - 1;
          }
        }
    }
  }

  private void updateBackstageRoseQuality(Item item) {
    if (item.sell_in < 6) {
      if (item.quality < 50) {
        item.quality = item.quality + 1;
      }
    }

    if (item.sell_in < 11) {
      if (item.quality < 50) {
        item.quality = item.quality + 1;
      }
    }

    if (item.sell_in < 0) {
      item.quality = 0;
    }
  }

  private void updateSellIn(Item item) {
    if (!item.name.equals(SULFURAS_ROSE)) {
      item.sell_in = item.sell_in - 1;
    }
  }
}