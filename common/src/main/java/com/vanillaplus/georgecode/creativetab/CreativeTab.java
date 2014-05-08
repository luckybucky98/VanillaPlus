package com.vanillaplus.georgecode.creativetab;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.vanillaplus.georgecode.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import com.vanillaplus.georgecode.VanillaplusMain;
public class CreativeTab {
	
	public static final CreativeTabs VANILLAPLUS_TAB = new CreativeTabs(com.vanillaplus.georgecode.Reference.MODID){
		
		@Override
		public Item getTabIconItem(){
			return Item.book;
		}
		
		@Override
		@SideOnly(Side.CLIENT)
		public String getTranslatedTabLabel(){
			return "Vanilla Plus";
		}
	};

}
