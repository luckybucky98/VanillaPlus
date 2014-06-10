package com.cricket.vanillaplus.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class ItemPebble extends Item{
	
	public ItemPebble(){
		super();
		this.maxStackSize=(64);
		setTextureName("vanillaplus:ItemPebble");
	}
}
