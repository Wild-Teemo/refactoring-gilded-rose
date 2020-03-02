package com.gildedrose;

public class BackstagePassesRose extends Rose {

  public BackstagePassesRose(String name, int sell_in, int quality) {
    super(name, sell_in, quality);
  }

  @Override
  public void updateQuality() {
    if (this.quality < 50) {
      this.quality ++;
    }
    if (this.sellIn < 6) {
      if (this.quality < 50) {
        this.quality ++;
      }
    }

    if (this.sellIn < 11) {
      if (this.quality < 50) {
        this.quality ++;
      }
    }

    if (this.sellIn < 0) {
      this.quality = 0;
    }
  }

}
