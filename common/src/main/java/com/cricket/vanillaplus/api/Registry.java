package com.cricket.vanillaplus.api;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;

import com.cricket.vanillaplus.api.handlers.GuiHandler;
import com.cricket.vanillaplus.tiles.TileEntityAdvancedSmelter;
import com.cricket.vanillaplus.tiles.TileEntityRockCrusher;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Registry {
	
	public static Block BlockRockCrusherIdle;
	public static Block BlockRockCrusherActive;
	public static Block BlockCompressor;
	public static Block BlockCrystalOre;
	public static Block BlockLavaInfusedLog;
	public static Block BlockWaterInfusedLog;
	public static Block BlockLavaInfusedLeaves;
	public static Block BlockWaterInfusedLeaves;
	public static Block BlockAdvancedSmelterIdle;
	public static Block BlockAdvancedSmelterActive;
	public static Block BlockLavaInfusedPlanks;
	public static Block BlockWaterInfusedPlanks;
	public static Block BlockLavaInfusedCraftingTable;
	
	public static int BlockRockCrusherIdleID;
	public static int BlockRockCrusherActiveID;
	public static int BlockCompressorID;
	public static int BlockCrystalOreID;
	public static int BlockLavaInfusedLeavesID;
	public static int BlockLavaInfusedLogID;
	public static int BlockLavaInfusedPlanksID;
	public static int BlockLavaInfusedCraftingTableID;
	public static int BlockWaterInfusedLeavesID;
	public static int BlockWaterInfusedLogID;
	public static int BlockWaterInfusedPlanksID;
	public static int BlockAdvancedSmelterIdleID;
	public static int BlockAdvancedSmelterActiveID;
	
	public static Item ItemPebble;
	public static Item ItemCompressedCoal;
	public static Item ItemCompressedDiamond;
	public static Item ItemSpawnUnicorn;
	
	public static int ItemPebbleid;
	public static int ItemCompressedCoalid;
	public static int ItemCompressedDiamondid;
	public static int ItemSpawnUnicornid;
	
	public static BiomeGenBase biomeLavaForest;
	public static BiomeGenBase biomeWaterForest;
	
	private static void game(){
		blocks();
		items();
		tiles();
	}
	private static void language(){
		languageBlocks();
		languageItems();
	}
	private static void network(){
		NetworkRegistry.instance().registerGuiHandler(BlockRockCrusherIdle, new GuiHandler());
	}
	private static void blocks(){
		GameRegistry.registerBlock(BlockRockCrusherIdle, ItemBlock.class,"RockCrusherIdle");
		GameRegistry.registerBlock(BlockRockCrusherActive, ItemBlock.class,"RockCrusherActive");
		GameRegistry.registerBlock(BlockAdvancedSmelterIdle, ItemBlock.class, "AdvancedSmelterIdle");
		GameRegistry.registerBlock(BlockAdvancedSmelterActive, ItemBlock.class,"AdvancedSmelterActive");
		GameRegistry.registerBlock(BlockCompressor, ItemBlock.class, "Compressor");
		GameRegistry.registerBlock(BlockCrystalOre, ItemBlock.class, "Crystal Ore");
		GameRegistry.registerBlock(BlockLavaInfusedLeaves, ItemBlock.class, "LavaInfusedLeaves");
		GameRegistry.registerBlock(BlockLavaInfusedLog, ItemBlock.class, "LavaInfusedLog");
		GameRegistry.registerBlock(BlockLavaInfusedPlanks, ItemBlock.class, "LavaInfusedPlanks");
		GameRegistry.registerBlock(BlockLavaInfusedCraftingTable, ItemBlock.class, "LavaInfusedCraftingTable");
		GameRegistry.registerBlock(BlockWaterInfusedLeaves, ItemBlock.class, "WaterInfusedLeaves");
		GameRegistry.registerBlock(BlockWaterInfusedLog, ItemBlock.class, "WaterInfusedLog");
		GameRegistry.registerBlock(BlockWaterInfusedPlanks, ItemBlock.class, "WaterInfusedPlanks");
	}
	private static void items(){
		GameRegistry.registerItem(ItemPebble,"Pebble");
		GameRegistry.registerItem(ItemCompressedCoal, "CompressedCoal");
		GameRegistry.registerItem(ItemCompressedDiamond, "CompressedDiamond");
	}
	private static void tiles(){
		GameRegistry.registerTileEntity(TileEntityRockCrusher.class, "RockCrusher");
		GameRegistry.registerTileEntity(TileEntityAdvancedSmelter.class, "AdvancedSmelter");
	}
	private static void languageBlocks(){
		LanguageRegistry.addName(BlockRockCrusherIdle, "Rock Crusher");
		LanguageRegistry.addName(BlockAdvancedSmelterIdle, "Advanced Smelter");
		LanguageRegistry.addName(BlockCompressor, "Compressor");
		LanguageRegistry.addName(BlockCrystalOre, "Crystal Ore");
		LanguageRegistry.addName(BlockLavaInfusedLeaves, "Lava Infused Leaves");
		LanguageRegistry.addName(BlockLavaInfusedLog, "Lava Infused Log");
		LanguageRegistry.addName(BlockLavaInfusedPlanks, "Lava Infused Planks");
		LanguageRegistry.addName(BlockLavaInfusedCraftingTable, "Lava Infused Crafting Table");
		LanguageRegistry.addName(BlockWaterInfusedLeaves, "Water Infused Leaves");
		LanguageRegistry.addName(BlockWaterInfusedLog, "Water Infused Log");
		LanguageRegistry.addName(BlockWaterInfusedPlanks, "Water Infused Planks");
	}
	private static void languageItems(){
		LanguageRegistry.addName(ItemPebble, "Pebble");
		LanguageRegistry.addName(ItemCompressedCoal, "Compressed Coal");
		LanguageRegistry.addName(ItemCompressedDiamond, "Compressed Diamond");
	}
	private static void world(){
		registerBiomes();
		addToBiomeDictionary();
	}
	private static void addToBiomeDictionary(){
		BiomeDictionary.registerBiomeType(biomeLavaForest, new BiomeDictionary.Type[] {BiomeDictionary.Type.FOREST, BiomeDictionary.Type.HILLS});
		BiomeDictionary.registerBiomeType(biomeWaterForest, new BiomeDictionary.Type[] {BiomeDictionary.Type.FOREST, BiomeDictionary.Type.HILLS});
	}
	private static void registerBiomes(){
		GameRegistry.addBiome(biomeLavaForest);
		GameRegistry.addBiome(biomeWaterForest);
	}
	public static void load(){
		game();
		world();
		language();
		network();
	}
}
