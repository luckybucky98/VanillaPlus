package com.cricket.vanillaplus.api;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import com.cricket.vanillaplus.api.handlers.GuiHandler;
import com.cricket.vanillaplus.tiles.TileEntityRockCrusher;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Registry {
	
	public static final int guiIDRockCrusher=0;
	
	public static Block BlockRockCrusherIdle;
	public static Block BlockRockCrusherActive;
	
	public static Item ItemPebble;
	
	
	public static int ItemPebbleid;
	
	
	public static void game(){
		blocks();
		items();
		tiles();
	}
	public static void language(){
		languageBlocks();
		languageItems();
	}
	public static void network(){
		
	}
	public static void blocks(){
		GameRegistry.registerBlock(BlockRockCrusherIdle, ItemBlock.class,"RockCrusherIdle");
		GameRegistry.registerBlock(BlockRockCrusherActive, ItemBlock.class,"RockCrusherActive");
	}
	public static void items(){
		GameRegistry.registerItem(ItemPebble,"Pebble");
	}
	public static void tiles(){
		GameRegistry.registerTileEntity(TileEntityRockCrusher.class, "RockCrusher");
	}
	public static void languageBlocks(){
		LanguageRegistry.addName(BlockRockCrusherIdle, "Rock Crusher");
	}
	public static void languageItems(){
		LanguageRegistry.addName(ItemPebble, "Pebble");
	}
	public static void GUI(){
		GuiHandler guiHandler = new GuiHandler();
	}
	public static void load(){
		game();
		language();
		network();
		GUI();
	}
}
