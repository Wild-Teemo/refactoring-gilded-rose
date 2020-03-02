package com.gildedrose;

class GildedRose {

  private static final String AGED_BRIE_ROSE = "Aged Brie";
  private static final String BACKSTAGE_PASSES_ROSE = "Backstage passes to a TAFKAL80ETC concert";
  private static final String SULFURAS_ROSE = "Sulfuras, Hand of Ragnaros";

  public Rose[] roses;

  public GildedRose(Rose[] roses) {
    this.roses = roses;
  }

  public void update_quality() {
    for (Rose rose : roses) {
      updateSellIn(rose);
      updateQuality(rose);
    }
  }

  private void updateQuality(Rose rose) {
    switch (rose.name) {
      case SULFURAS_ROSE:
        return;
      case AGED_BRIE_ROSE:
        if (rose.sell_in < 0 && rose.quality < 50) {
          rose.quality = rose.quality + 1;
        }
        if (rose.quality < 50) {
          rose.quality = rose.quality + 1;
        }
        return;
      case BACKSTAGE_PASSES_ROSE:
        if (rose.quality < 50) {
          rose.quality = rose.quality + 1;
        }
        updateBackstageRoseQuality(rose);
        return;
      default:
        if (rose.quality > 0) {
          rose.quality = rose.quality - 1;
          if (rose.sell_in < 0) {
            rose.quality = rose.quality - 1;
          }
        }
    }
  }

  private void updateBackstageRoseQuality(Rose rose) {
    if (rose.sell_in < 6) {
      if (rose.quality < 50) {
        rose.quality = rose.quality + 1;
      }
    }

    if (rose.sell_in < 11) {
      if (rose.quality < 50) {
        rose.quality = rose.quality + 1;
      }
    }

    if (rose.sell_in < 0) {
      rose.quality = 0;
    }
  }

  private void updateSellIn(Rose rose) {
    if (!rose.name.equals(SULFURAS_ROSE)) {
      rose.sell_in = rose.sell_in - 1;
    }
  }
}