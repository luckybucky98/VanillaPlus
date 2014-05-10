package com.cricket.vanillaplus.api;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import com.cricket.vanillaplus.Reference;
import com.cricket.vanillaplus.VanillaPlus;
import com.cricket.vanillaplus.api.handlers.GuiHandler;
import com.cricket.vanillaplus.tiles.TileEntityRockCrusher;

import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Registry {
	
	
	public static final int guiIDRockCrusher=0;
	
	public static Block BlockRockCrusherIdle;
	public static Block BlockRockCrusherActive;
	public static Block BlockAdvancedSmelter;
	public static Block BlockCompressor;
	public static Block BlockCrystalOre;
	public static Block BlockLavaInfusedTree;
	public static Block BlockWaterInfusedTree;
	public static Block BlockLavaLeaves;
	public static Block BlockWaterInfusedTreeLeaves;
	public static Block BlockAdvancedSmelterIdle;
	public static Block BlockAdvancedSmelterActive;
	public static Block BlockLavaInfusedWood;
	public static Block BlockWaterInfusedWood;
	
	public static Item ItemPebble;
	public static Item ItemCompressedCoal;
	public static Item ItemCompressedDiamond;
	
	public static int ItemPebbleid;
	public static int ItemCompressedCoalid;
	public static int ItemCompressedDiamondid;
	
	
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
		NetworkRegistry.instance().registerGuiHandler(BlockRockCrusherIdle, new GuiHandler());
	}
	public static void blocks(){
		GameRegistry.registerBlock(BlockRockCrusherIdle, ItemBlock.class,"RockCrusherIdle");
		GameRegistry.registerBlock(BlockRockCrusherActive, ItemBlock.class,"RockCrusherActive");
	}
	public static void items(){
		GameRegistry.registerItem(ItemPebble,"Pebble");
		GameRegistry.registerItem(ItemCompressedCoal, "Compressed Coal");
	}
	public static void tiles(){
		GameRegistry.registerTileEntity(TileEntityRockCrusher.class, "RockCrusher");
	}
	public static void languageBlocks(){
		LanguageRegistry.addName(BlockRockCrusherIdle, "Rock Crusher");
	}
	public static void languageItems(){
		LanguageRegistry.addName(ItemPebble, "Pebble");
		LanguageRegistry.addName(ItemCompressedCoal, "Compressed Coal");
	}
	public static void load(){
		game();
		language();
		network();
	}
}
