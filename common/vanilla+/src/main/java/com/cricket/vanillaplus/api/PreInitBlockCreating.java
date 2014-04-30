package com.cricket.vanillaplus.api;

import com.cricket.vanillaplus.blocks.BlockRockCrusher;
import com.cricket.vanillaplus.creativetab.CreativeTab;
import com.cricket.vanillaplus.items.ItemPebble;
import com.cricket.vanillaplus.items.ItemBiomeCompass;

public class PreInitBlockCreating {
	public static void load(){
		items();
		blocks();
	}
	public static void items(){
		Registry.ItemPebble = new ItemPebble(Registry.ItemPebbleid).setCreativeTab(CreativeTab.VANILLAPLUS_TAB);
		Registry.ItemBiomeCompass = new ItemBiomeCompass(Registry.ItemBiomeCompassid).setCreativeTab(CreativeTab.VANILLAPLUS_TAB);
	}
	public static void blocks(){
		Registry.BlockRockCrusherIdle = new BlockRockCrusher(1002,false).setUnlocalizedName("rockCrusherIdle").setHardness(3.5F).setCreativeTab(CreativeTab.VANILLAPLUS_TAB);
		Registry.BlockRockCrusherActive = new BlockRockCrusher(1003,true).setUnlocalizedName("rockCrusherActive").setHardness(3.5F).setLightValue(0.9F);
	}
}
