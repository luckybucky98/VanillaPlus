package com.cricket.vanillaplus.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemCrystal extends ItemMultiple{
	
	public static final String[] types = new String[] {"red", "orange", "yellow", "green", "blue", "purple"};
	
	public ItemCrystal(){
		super(types);
		this.maxStackSize = 64;
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list){
		for(int c = 0; c < ItemCrystal.types.length; c++){
			list.add(new ItemStack(this, 1, c));
		}
	}
}
