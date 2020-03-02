package com.gildedrose;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class GildedRoseTest {

  @Test
  public void should_quality_minus_1_when_update_quality_given_none_of_3_special_roses_and_sell_in_is_more_than_0() {
    Rose[] roses = new Rose[]{new Rose("rose", 2, 2)};
    GildedRose gildedRose = new GildedRose(roses);
    gildedRose.update_quality();
    assertEquals("rose", gildedRose.roses[0].name);
    assertThat(gildedRose.roses[0].quality, is(1));
  }

  @Test
  public void should_quality_minus_2_when_update_quality_given_none_of_3_special_roses_and_sell_in_is_less_than_or_equal_0() {
    Rose[] roses = new Rose[]{new Rose("rose", 0, 5)};
    GildedRose gildedRose = new GildedRose(roses);
    gildedRose.update_quality();
    assertEquals("rose", gildedRose.roses[0].name);
    assertThat(gildedRose.roses[0].quality, is(3));
  }

  @Test
  public void should_quality_add_1_when_updated_quality_given_Aged_Brie_and_quality_less_than_50_and_sell_in_is_more_than_0() {
    Rose[] roses = new Rose[]{new Rose("Aged Brie", 2, 49)};
    GildedRose gildedRose = new GildedRose(roses);
    gildedRose.update_quality();
    assertEquals("Aged Brie", gildedRose.roses[0].name);
    assertThat(gildedRose.roses[0].quality, is(50));
  }

  @Test
  public void should_keep_quality_when_updated_quality_given_Aged_Brie_and_quality_more_than_or_equal_50_and_sell_in_is_more_than_0() {
    Rose[] roses = new Rose[]{new Rose("Aged Brie", 2, 50)};
    GildedRose gildedRose = new GildedRose(roses);
    gildedRose.update_quality();
    assertEquals("Aged Brie", gildedRose.roses[0].name);
    assertThat(gildedRose.roses[0].quality, is(50));
  }

  @Test
  public void should_quality_add_2_when_updated_quality_given_Backstage_passes_to_a_TAFKAL80ETC_concert_and_quality_less_than_49_sell_in_less_than_11_and_more_than_0() {
    Rose[] roses = new Rose[]{new Rose("Backstage passes to a TAFKAL80ETC concert", 10, 4)};
    GildedRose gildedRose = new GildedRose(roses);
    gildedRose.update_quality();
    assertEquals("Backstage passes to a TAFKAL80ETC concert", gildedRose.roses[0].name);
    assertThat(gildedRose.roses[0].quality, is(6));
  }

  @Test
  public void should_quality_add_3_when_updated_quality_given_Backstage_passes_to_a_TAFKAL80ETC_concert_and_quality_less_than_49_sell_less_than_6_and_more_than_0() {
    Rose[] roses = new Rose[]{new Rose("Backstage passes to a TAFKAL80ETC concert", 5, 4)};
    GildedRose gildedRose = new GildedRose(roses);
    gildedRose.update_quality();
    assertEquals("Backstage passes to a TAFKAL80ETC concert", gildedRose.roses[0].name);
    assertThat(gildedRose.roses[0].quality, is(7));
  }

  @Test
  public void should_quality_max_to_50_when_updated_quality_given_Backstage_passes_to_a_TAFKAL80ETC_concert_and_quality_is_49_and_sell_less_than_11_and_more_than_0() {
    Rose[] roses = new Rose[]{new Rose("Backstage passes to a TAFKAL80ETC concert", 10, 49)};
    GildedRose gildedRose = new GildedRose(roses);
    gildedRose.update_quality();
    assertEquals("Backstage passes to a TAFKAL80ETC concert", gildedRose.roses[0].name);
    assertThat(gildedRose.roses[0].quality, is(50));
  }

  @Test
  public void should_quality_max_to_50_when_updated_quality_given_Backstage_passes_to_a_TAFKAL80ETC_concert_and_quality_is_48_sell_less_than_6_and_more_than_0() {
    Rose[] roses = new Rose[]{new Rose("Backstage passes to a TAFKAL80ETC concert", 5, 48)};
    GildedRose gildedRose = new GildedRose(roses);
    gildedRose.update_quality();
    assertEquals("Backstage passes to a TAFKAL80ETC concert", gildedRose.roses[0].name);
    assertThat(gildedRose.roses[0].quality, is(50));
  }

  @Test
  public void should_keep_quality_when_updated_quality_given_Sulfuras_and_of_Ragnaros() {
    Rose[] roses = new Rose[]{new Rose("Sulfuras, Hand of Ragnaros", -2, 50)};
    GildedRose gildedRose = new GildedRose(roses);
    gildedRose.update_quality();
    assertEquals("Sulfuras, Hand of Ragnaros", gildedRose.roses[0].name);
    assertThat(gildedRose.roses[0].quality, is(50));
  }

  @Test
  public void should_sell_in_minus_1_when_update_quality_given_none_of_3_special_roses() {
    Rose[] roses = new Rose[]{new Rose("rose", 4, 50)};
    GildedRose gildedRose = new GildedRose(roses);
    gildedRose.update_quality();
    assertEquals("rose", gildedRose.roses[0].name);
    assertThat(gildedRose.roses[0].sell_in, is(3));
  }

  @Test
  public void should_sell_in_minus_1_when_update_quality_given_Backstage_passes_to_a_TAFKAL80ETC_concert_rose() {
    Rose[] roses = new Rose[]{new Rose("Backstage passes to a TAFKAL80ETC concert", 4, 50)};
    GildedRose gildedRose = new GildedRose(roses);
    gildedRose.update_quality();
    assertThat(gildedRose.roses[0].sell_in, is(3));
  }

  @Test
  public void should_sell_in_minus_1_when_update_quality_given_Aged_Brie() {
    Rose[] roses = new Rose[]{new Rose("Aged Brie", 4, 49)};
    GildedRose gildedRose = new GildedRose(roses);
    gildedRose.update_quality();
    assertEquals("Aged Brie", gildedRose.roses[0].name);
    assertThat(gildedRose.roses[0].sell_in, is(3));
  }

  @Test
  public void should_keep_sell_in_when_updated_quality_given_Sulfuras_and_of_Ragnaros() {
    Rose[] roses = new Rose[]{new Rose("Sulfuras, Hand of Ragnaros", 3, 50)};
    GildedRose gildedRose = new GildedRose(roses);
    gildedRose.update_quality();
    assertEquals("Sulfuras, Hand of Ragnaros", gildedRose.roses[0].name);
    assertThat(gildedRose.roses[0].sell_in, is(3));
  }

  @Test
  public void should_quality_add_2__when_update_quality_given_Aged_Brie_and_quality_less_than_49_and_sell_in_less_than_0() {
    Rose[] roses = new Rose[]{new Rose("Aged Brie", -1, 47)};
    GildedRose gildedRose = new GildedRose(roses);
    gildedRose.update_quality();
    assertEquals("Aged Brie", gildedRose.roses[0].name);
    assertThat(gildedRose.roses[0].quality, is(49));
  }

  @Test
  public void should_keep_quality_when_update_quality_given_Aged_Brie_and_quality_more_than_49_and_sell_in_less_than_0_() {
    Rose[] roses = new Rose[]{new Rose("Aged Brie", -1, 50)};
    GildedRose gildedRose = new GildedRose(roses);
    gildedRose.update_quality();
    assertEquals("Aged Brie", gildedRose.roses[0].name);
    assertThat(gildedRose.roses[0].quality, is(50));
  }

  @Test
  public void should_set_quality_0_when_update_quality_given_Backstage_passes_to_a_TAFKAL80ETC_concert_rose_and_sell_less_than_0() {
    Rose[] roses = new Rose[]{new Rose("Backstage passes to a TAFKAL80ETC concert", -1, 50)};
    GildedRose gildedRose = new GildedRose(roses);
    gildedRose.update_quality();
    assertThat(gildedRose.roses[0].quality, is(0));
  }

}
