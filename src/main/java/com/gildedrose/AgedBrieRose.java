package com.gildedrose;

public class AgedBrieRose extends Rose {
  public AgedBrieRose(String name, int sell_in, int quality) {
    super(name, sell_in, quality);
  }

  @Override
  public void updateQuality() {
    if (this.sellIn < 0 && this.quality < 50) {
      this.quality = this.quality + 1;
    }
    if (this.quality < 50) {
      this.quality = this.quality + 1;
    }
  }
}
