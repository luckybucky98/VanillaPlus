package com.cricket.vanillaplus;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;

import com.cricket.vanillaplus.blocks.*;
import com.cricket.vanillaplus.blocks.decoration.*;
import com.cricket.vanillaplus.blocks.nature.*;
import com.cricket.vanillaplus.creativetab.CreativeTab;
import com.cricket.vanillaplus.handlers.EntityHandler;
import com.cricket.vanillaplus.handlers.GuiHandler;
import com.cricket.vanillaplus.items.*;
import com.cricket.vanillaplus.mobs.EntityPigCarcass;
import com.cricket.vanillaplus.reference.BiomeIDReference;
import com.cricket.vanillaplus.tiles.TileEntityAdvancedSmelter;
import com.cricket.vanillaplus.tiles.TileEntityRockCrusher;
import com.cricket.vanillaplus.worldgen.VPWorldGen;
import com.cricket.vanillaplus.worldgen.base.CaveBase;
import com.cricket.vanillaplus.worldgen.biomes.BiomeGenLavaForest;
import com.cricket.vanillaplus.worldgen.biomes.BiomeGenWaterForest;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class Registry {
	
	public static final BiomeGenBase waterForest = new BiomeGenWaterForest(BiomeIDReference.waterForest).setBiomeName("Water Forest");
	public static final BiomeGenBase lavaForest = new BiomeGenLavaForest(BiomeIDReference.lavaForest).setBiomeName("Lava Forest");
	
	public static Block BlockRockCrusherIdle;
	public static Block BlockRockCrusherActive;
	public static Block BlockCompressorActive;
	public static Block BlockCompressorIdle;
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
	public static Block BlockWaterInfusedCraftingTable;
	public static Block BlockGrinderIdle;
	public static Block BlockGrinderActive;
	public static Block BlockSapling;
	public static Block BlockWaterInfusedDoor;
	public static Block BlockLavaInfusedDoor;
	
	public static Item ItemPebble;
	public static Item ItemCompressedCoal;
	public static Item ItemCompressedDiamond;
	public static Item ItemParticleTester;
	public static Item ItemCrystalOre;
	public static Item ItemCrystal;
	public static Item ItemFertilizer;
	public static Item ItemWaterInfusedDoor;
	public static Item ItemLavaInfusedDoor;
	
	public static String pig = "pigCarcass";
	
	public static VPWorldGen worldGen = new VPWorldGen();
	
	public static List<CaveBase> caveBase = new ArrayList();
	
	private static void preInit(){
		preBlocks();
		preItems();
	}
	
	private static void preBlocks(){
		BlockRockCrusherIdle = new BlockRockCrusher(Material.rock, false).setHardness(3.5F).setBlockName("rockCrusherIdle").setCreativeTab(CreativeTab.VP_MACHINES);
		BlockRockCrusherActive = new BlockRockCrusher(Material.rock, true).setHardness(3.5F).setBlockName("rockCrusherActive");
		BlockCrystalOre = new BlockCrystalOre().setBlockName("crystalOre");
		BlockLavaInfusedLeaves = new BlockLavaInfusedLeaves(Material.leaves).setLightLevel(1000).setBlockName("lavaInfusedLeaves");
		BlockLavaInfusedLog = new BlockLavaInfusedLog(Material.wood).setBlockName("lavaInfusedLog");
		BlockLavaInfusedPlanks = new BlockLavaInfusedPlanks(Material.wood).setBlockName("lavaInfusedPlanks");
		BlockWaterInfusedLeaves = new BlockWaterInfusedLeaves(Material.leaves).setBlockName("waterInfusedLeaves");
		BlockWaterInfusedLog = new BlockWaterInfusedLog(Material.wood).setBlockName("waterInfusedLog");
		BlockWaterInfusedPlanks = new BlockWaterInfusedPlanks(Material.wood).setBlockName("waterInfusedPlanks");
		BlockCompressorIdle = new BlockCompressor(Material.rock).setBlockName("compressorIdle").setCreativeTab(CreativeTab.VP_MACHINES);
		BlockCompressorActive = new BlockCompressor(Material.rock).setBlockName("compressorActive");
		BlockAdvancedSmelterIdle = new BlockAdvancedSmelter(Material.rock).setBlockName("advancedSmelterIdle").setCreativeTab(CreativeTab.VP_MACHINES);
		BlockAdvancedSmelterActive = new BlockAdvancedSmelter(Material.rock).setBlockName("advancedSmelterActive").setLightLevel(500);
		BlockLavaInfusedCraftingTable = new BlockLavaInfusedCraftingTable(Material.wood).setBlockName("lavaInfusedCraftingTable");
		BlockWaterInfusedCraftingTable = new BlockWaterInfusedCraftingTable(Material.wood).setBlockName("waterInfusedCraftingTable");
		BlockGrinderIdle = new BlockGrinder().setHardness(3.5F).setBlockName("grinderIdle").setCreativeTab(CreativeTab.VP_MACHINES);
		BlockGrinderActive = new BlockGrinder().setHardness(3.5F).setBlockName("grinderActive");
		BlockSapling = new BlockSapling();
		BlockWaterInfusedDoor = new BlockWaterInfusedDoor(Material.wood).setBlockName("waterInfusedDoor");
	}
	
	private static void preItems(){
		ItemPebble = new ItemPebble().setUnlocalizedName("pebble");
		ItemCompressedCoal = new ItemCompressedCoal().setUnlocalizedName("compressedCoal");
		ItemCompressedDiamond = new ItemCompressedDiamond().setUnlocalizedName("compressedDiamond");
		ItemParticleTester = new ItemParticleTester().setUnlocalizedName("particleTester");
		ItemCrystalOre = new ItemCrystalOre().setUnlocalizedName("crystalOre");
		ItemCrystal = new ItemCrystal().setUnlocalizedName("crystalOre");
		ItemFertilizer = new ItemFertilizer().setUnlocalizedName("fertilizer");
		ItemWaterInfusedDoor = new ItemWaterInfusedDoor(Material.wood).setUnlocalizedName("waterInfusedDoor");	
	}
	
	private static void game(){
		blocks();
		items();
		tiles();
		mobs();
		world();
	}
	
	@EventHandler
	private static void network(){
		new GuiHandler();
		NetworkRegistry.INSTANCE.registerGuiHandler(VanillaPlus.instance, new GuiHandler());
	}
	private static void blocks(){
		GameRegistry.registerBlock(BlockRockCrusherIdle, ItemBlock.class, BlockRockCrusherIdle.getUnlocalizedName());
		GameRegistry.registerBlock(BlockRockCrusherActive, ItemBlock.class,BlockRockCrusherActive.getUnlocalizedName());
		GameRegistry.registerBlock(BlockAdvancedSmelterIdle, ItemBlock.class, BlockAdvancedSmelterIdle.getUnlocalizedName());
		GameRegistry.registerBlock(BlockAdvancedSmelterActive, ItemBlock.class, BlockAdvancedSmelterActive.getUnlocalizedName());
		GameRegistry.registerBlock(BlockCompressorIdle, ItemBlock.class, BlockCompressorIdle.getUnlocalizedName());
		GameRegistry.registerBlock(BlockCompressorActive, ItemBlock.class, BlockCompressorActive.getUnlocalizedName());
		GameRegistry.registerBlock(BlockCrystalOre, ItemBlock.class, BlockCrystalOre.getUnlocalizedName());
		GameRegistry.registerBlock(BlockLavaInfusedLeaves, ItemBlock.class, BlockLavaInfusedLeaves.getUnlocalizedName());
		GameRegistry.registerBlock(BlockLavaInfusedLog, ItemBlock.class, BlockLavaInfusedLog.getUnlocalizedName());
		GameRegistry.registerBlock(BlockLavaInfusedPlanks, ItemBlock.class, BlockLavaInfusedPlanks.getUnlocalizedName());
		GameRegistry.registerBlock(BlockLavaInfusedCraftingTable, ItemBlock.class, BlockLavaInfusedCraftingTable.getUnlocalizedName());
		GameRegistry.registerBlock(BlockWaterInfusedCraftingTable, ItemBlock.class, BlockWaterInfusedCraftingTable.getUnlocalizedName());
		GameRegistry.registerBlock(BlockWaterInfusedLeaves, ItemBlock.class, BlockWaterInfusedLeaves.getUnlocalizedName());
		GameRegistry.registerBlock(BlockWaterInfusedLog, ItemBlock.class, BlockWaterInfusedLog.getUnlocalizedName());
		GameRegistry.registerBlock(BlockWaterInfusedPlanks, ItemBlock.class, BlockWaterInfusedPlanks.getUnlocalizedName());
		GameRegistry.registerBlock(BlockSapling, ItemSapling.class, "sapling");
		GameRegistry.registerBlock(BlockGrinderIdle, ItemBlock.class, BlockGrinderIdle.getUnlocalizedName());
		GameRegistry.registerBlock(BlockGrinderActive, ItemBlock.class, BlockGrinderActive.getUnlocalizedName());
		GameRegistry.registerBlock(BlockWaterInfusedDoor, ItemBlock.class, BlockWaterInfusedDoor.getUnlocalizedName());
	}
	private static void items(){
		GameRegistry.registerItem(ItemPebble,"Pebble");
		GameRegistry.registerItem(ItemCompressedCoal, "CompressedCoal");
		GameRegistry.registerItem(ItemCompressedDiamond, "CompressedDiamond");
		GameRegistry.registerItem(ItemParticleTester, "ParticleTester");
		GameRegistry.registerItem(ItemCrystal, "Crystal");
		GameRegistry.registerItem(ItemCrystalOre, "CrystalOre");
		GameRegistry.registerItem(ItemFertilizer, "Fertilizer");
		GameRegistry.registerItem(ItemWaterInfusedDoor, "WaterInfusedDoor");
	}
	private static void tiles(){
		GameRegistry.registerTileEntity(TileEntityRockCrusher.class, "RockCrusher");
		GameRegistry.registerTileEntity(TileEntityAdvancedSmelter.class, "AdvancedSmelter");
	}
	
	private static void world(){
		GameRegistry.registerWorldGenerator(worldGen, 1);
		
		BiomeDictionary.registerBiomeType(waterForest, Type.FOREST);
		BiomeDictionary.registerBiomeType(lavaForest, Type.FOREST);
		
		BiomeManager.addSpawnBiome(waterForest);
		BiomeManager.addSpawnBiome(lavaForest);
		
		BiomeManager.addStrongholdBiome(waterForest);
		BiomeManager.addStrongholdBiome(lavaForest);
		
		BiomeManager.addVillageBiome(waterForest, true);
		BiomeManager.addVillageBiome(lavaForest, true);
	}
	
	private static void mobs(){
		EntityHandler.createNewEntity(EntityPigCarcass.class, pig);
	}
	
	public static void load(){
		preInit();
		game();
		network();
	}
}
