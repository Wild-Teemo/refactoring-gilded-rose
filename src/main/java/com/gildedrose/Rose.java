package com.gildedrose;

public class Rose {

  public String name;

  public int sellIn;

  public int quality;

  public Rose(String name, int sellIn, int quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }

  public void updateQuality() {
    if (this.quality > 0) {
      this.quality--;
      if (this.sellIn < 0) {
        this.quality--;
      }
    }
  }

  public void updateSellIn() {
    this.sellIn--;
  }

  @Override
  public String toString() {
    return this.name + ", " + this.sellIn + ", " + this.quality;
  }
}
