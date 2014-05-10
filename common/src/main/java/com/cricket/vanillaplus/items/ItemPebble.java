package com.cricket.vanillaplus.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;

public class ItemPebble extends Item{
	private Icon iconIndex;
	
	public ItemPebble(int id){
		super(id);
		this.maxStackSize=(64);
	}
	public void registerIcons(IconRegister reg){
		this.itemIcon = reg.registerIcon("vanillaplus:ItemPebble");
	}

}
