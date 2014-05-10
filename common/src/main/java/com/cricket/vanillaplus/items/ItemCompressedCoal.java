package com.cricket.vanillaplus.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemCompressedCoal extends Item{

	public ItemCompressedCoal(int ID) {
		super(ID);
		this.maxStackSize=64;
	}
	public void registerIcons(IconRegister reg){
		this.itemIcon = reg.registerIcon("vanillaplus:ItemCompressedCoal");
	}
}
