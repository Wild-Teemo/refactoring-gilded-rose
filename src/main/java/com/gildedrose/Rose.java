package com.gildedrose;

public class Rose {

  public String name;

  public int sell_in;

  public int quality;

  public Rose(String name, int sell_in, int quality) {
    this.name = name;
    this.sell_in = sell_in;
    this.quality = quality;
  }

  public void updateQuality() {
    if (this.quality > 0) {
      this.quality = this.quality - 1;
      if (this.sell_in < 0) {
        this.quality = this.quality - 1;
      }
    }
  }

  public void updateSellIn() {
    this.sell_in--;
  }

  @Override
  public String toString() {
    return this.name + ", " + this.sell_in + ", " + this.quality;
  }
}
