package com.cricket.vanillaplus.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.cricket.vanillaplus.Registry;
import com.cricket.vanillaplus.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativeTab {
	
	public static final CreativeTabs VP_MACHINES = new CreativeTabs("VP Machines"){
		
		@Override
		public Item getTabIconItem(){
			return Item.getItemFromBlock(Registry.BlockRockCrusherIdle);
		}
		
		@Override
		@SideOnly(Side.CLIENT)
		public String getTranslatedTabLabel(){
			return "VP Machines";
		}
	};
	
	public static final CreativeTabs VP_DECORATION = new CreativeTabs("VP Decoration"){
		
		@Override
		public Item getTabIconItem(){
			return Item.getItemFromBlock(Registry.BlockWaterInfusedPlanks);
		}
		
		@Override
		@SideOnly(Side.CLIENT)
		public String getTranslatedTabLabel(){
			return "VP Decoration";
		}
	};
	
	public static final CreativeTabs VP_NATURE = new CreativeTabs("VP Nature"){
		
		@Override
		public Item getTabIconItem(){
			return Registry.ItemPebble;
		}
		
		@Override
		@SideOnly(Side.CLIENT)
		public String getTranslatedTabLabel(){
			return "VP Nature";
		}
	};
}
