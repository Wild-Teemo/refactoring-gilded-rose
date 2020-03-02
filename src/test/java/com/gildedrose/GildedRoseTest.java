package com.gildedrose;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class GildedRoseTest {

  @Test
  public void foo() {
    Item[] items = new Item[]{new Item("foo", 1, 5)};
    GildedRose gildedRose = new GildedRose(items);
    gildedRose.update_quality();
    assertEquals("foo", gildedRose.items[0].name);
    assertThat(gildedRose.items[0].quality, is(4));
    assertThat(gildedRose.items[0].sell_in, is(0));
  }

}
