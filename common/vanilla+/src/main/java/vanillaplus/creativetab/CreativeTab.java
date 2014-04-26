package com.cricket.vanillaplus.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.cricket.vanillaplus.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativeTab {
	
	public static final CreativeTabs VANILLAPLUS_TAB = new CreativeTabs(Reference.MODID){
		
		@Override
		public Item getTabIconItem(){
			return Item.bakedPotato;
		}
		
		@Override
		@SideOnly(Side.CLIENT)
		public String getTranslatedTabLabel(){
			return "Vanilla Plus";
		}
	};

}