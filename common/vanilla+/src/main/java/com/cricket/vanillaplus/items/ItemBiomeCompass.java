package com.cricket.vanillaplus.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;

public class ItemBiomeCompass extends Item{

  private Icon iconIndex;
  
  public ItemBiomeCompass(int id){
    super(id);
    maxStackSize=(64);
  }
  public void registerIcons(IconRegister reg){
    this.itemIcon = reg.registerIcon("vanillaplus:ItemBiomeCompass");
  }

}
