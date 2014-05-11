package com.cricket.vanillaplus.api;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import com.cricket.vanillaplus.Reference;
import com.cricket.vanillaplus.VanillaPlus;
import com.cricket.vanillaplus.api.handlers.GuiHandler;
import com.cricket.vanillaplus.tiles.TileEntityAdvancedSmelter;
import com.cricket.vanillaplus.tiles.TileEntityRockCrusher;

import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Registry {
	
	
	
	public static Block BlockRockCrusherIdle;
	public static Block BlockRockCrusherActive;
	public static Block BlockCompressor;
	public static Block BlockCrystalOre;
	public static Block BlockLavaInfusedTree;
	public static Block BlockWaterInfusedTree;
	public static Block BlockLavaInfusedLeaves;
	public static Block BlockWaterInfusedLeaves;
	public static Block BlockAdvancedSmelterIdle;
	public static Block BlockAdvancedSmelterActive;
	public static Block BlockLavaInfusedWood;
	public static Block BlockWaterInfusedWood;
	
	public static int BlockRockCrusherIdleID;
	public static int BlockRockCrusherActiveID;
	public static int BlockCompressorID;
	public static int BlockCrystalOreID;
	public static int BlockLavaInfusedLeavesID;
	public static int BlockLavaInfusedTreeID;
	public static int BlockLavaInfusedWoodID;
	public static int BlockWaterInfusedLeavesID;
	public static int BlockWaterInfusedTreeID;
	public static int BlockWaterInfusedWoodID;
	public static int BlockAdvancedSmelterIdleID;
	public static int BlockAdvancedSmelterActiveID;
	
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
		GameRegistry.registerBlock(BlockAdvancedSmelterIdle, ItemBlock.class, "AdvancedSmelterIdle");
		GameRegistry.registerBlock(BlockAdvancedSmelterActive, ItemBlock.class,"AdvancedSmelterActive");
		GameRegistry.registerBlock(BlockCompressor, ItemBlock.class, "Compressor");
		GameRegistry.registerBlock(BlockCrystalOre, ItemBlock.class, "Crystal Ore");
		GameRegistry.registerBlock(BlockLavaInfusedLeaves, ItemBlock.class, "LavaInfusedLeaves");
		GameRegistry.registerBlock(BlockLavaInfusedTree, ItemBlock.class, "LavaInfusedTree");
		GameRegistry.registerBlock(BlockLavaInfusedWood, ItemBlock.class, "LavaInfusedWood");
		GameRegistry.registerBlock(BlockWaterInfusedLeaves, ItemBlock.class, "WaterInfusedLeaves");
		GameRegistry.registerBlock(BlockWaterInfusedTree, ItemBlock.class, "WaterInfusedTree");
		GameRegistry.registerBlock(BlockWaterInfusedWood, ItemBlock.class, "WaterInfusedWood");
	}
	public static void items(){
		GameRegistry.registerItem(ItemPebble,"Pebble");
		GameRegistry.registerItem(ItemCompressedCoal, "CompressedCoal");
		GameRegistry.registerItem(ItemCompressedDiamond, "CompressedDiamond");
	}
	public static void tiles(){
		GameRegistry.registerTileEntity(TileEntityRockCrusher.class, "RockCrusher");
		GameRegistry.registerTileEntity(TileEntityAdvancedSmelter.class, "AdvancedSmelter");
	}
	public static void languageBlocks(){
		LanguageRegistry.addName(BlockRockCrusherIdle, "Rock Crusher");
		LanguageRegistry.addName(BlockAdvancedSmelterIdle, "Advanced Smelter");
		LanguageRegistry.addName(BlockCompressor, "Compressor");
		LanguageRegistry.addName(BlockCrystalOre, "Crystal Ore");
		LanguageRegistry.addName(BlockLavaInfusedLeaves, "Lava Infused Leaves");
		LanguageRegistry.addName(BlockLavaInfusedTree, "Lava Infused Tree");
		LanguageRegistry.addName(BlockLavaInfusedWood, "Lava Infused Wood");
		LanguageRegistry.addName(BlockWaterInfusedLeaves, "Water Infused Leaves");
		LanguageRegistry.addName(BlockWaterInfusedTree, "Water Infused Tree");
		LanguageRegistry.addName(BlockWaterInfusedWood, "Water Infused Wood");
	}
	public static void languageItems(){
		LanguageRegistry.addName(ItemPebble, "Pebble");
		LanguageRegistry.addName(ItemCompressedCoal, "Compressed Coal");
		LanguageRegistry.addName(ItemCompressedDiamond, "Compressed Diamond");
	}
	public static void load(){
		game();
		language();
		network();
	}
}
