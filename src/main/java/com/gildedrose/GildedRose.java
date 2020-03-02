package com.gildedrose;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class GildedRose {

  private static final String AGED_BRIE_ROSE = "Aged Brie";
  private static final String BACKSTAGE_PASSES_ROSE = "Backstage passes to a TAFKAL80ETC concert";
  private static final String SULFURAS_ROSE = "Sulfuras, Hand of Ragnaros";

  List<Rose> roses;

  public GildedRose(Rose[] roses) {
    this.roses = Arrays.stream(roses)
        .map(this::createRose)
        .collect(Collectors.toList());
  }

  public void update_quality() {
    roses.stream()
        .forEach(rose -> {
          rose.updateSellIn();
          rose.updateQuality();
        });
  }

  private Rose createRose(Rose rose) {
    switch (rose.name) {
      case SULFURAS_ROSE:
        return new SulfurasRose(rose.name, rose.sellIn, rose.quality);
      case AGED_BRIE_ROSE:
        return new AgedBrieRose(rose.name, rose.sellIn, rose.quality);
      case BACKSTAGE_PASSES_ROSE:
        return new BackstagePassesRose(rose.name, rose.sellIn, rose.quality);
      default:
        return new Rose(rose.name, rose.sellIn, rose.quality);
    }
  }
}