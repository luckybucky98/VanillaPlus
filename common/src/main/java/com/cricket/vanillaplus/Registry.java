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

import com.cricket.vanillaplus.blocks.BlockAdvancedSmelter;
import com.cricket.vanillaplus.blocks.BlockCompressor;
import com.cricket.vanillaplus.blocks.BlockCrystalOre;
import com.cricket.vanillaplus.blocks.BlockGrinder;
import com.cricket.vanillaplus.blocks.BlockLavaInfusedCraftingTable;
import com.cricket.vanillaplus.blocks.BlockRockCrusher;
import com.cricket.vanillaplus.blocks.decoration.BlockLavaInfusedPlanks;
import com.cricket.vanillaplus.blocks.decoration.BlockWaterInfusedPlanks;
import com.cricket.vanillaplus.blocks.nature.BlockLavaInfusedLeaves;
import com.cricket.vanillaplus.blocks.nature.BlockLavaInfusedLog;
import com.cricket.vanillaplus.blocks.nature.BlockSapling;
import com.cricket.vanillaplus.blocks.nature.BlockWaterInfusedLeaves;
import com.cricket.vanillaplus.blocks.nature.BlockWaterInfusedLog;
import com.cricket.vanillaplus.creativetab.CreativeTabMain;
import com.cricket.vanillaplus.creativetab.CreativeTabNature;
import com.cricket.vanillaplus.handlers.EntityHandler;
import com.cricket.vanillaplus.handlers.GuiHandler;
import com.cricket.vanillaplus.items.ItemBlockMultiple;
import com.cricket.vanillaplus.items.ItemCompressedCoal;
import com.cricket.vanillaplus.items.ItemCompressedDiamond;
import com.cricket.vanillaplus.items.ItemCrystal;
import com.cricket.vanillaplus.items.ItemCrystalOre;
import com.cricket.vanillaplus.items.ItemParticleTester;
import com.cricket.vanillaplus.items.ItemPebble;
import com.cricket.vanillaplus.items.ItemSapling;
import com.cricket.vanillaplus.mobs.EntityPigCarcass;
import com.cricket.vanillaplus.reference.BiomeIDReference;
import com.cricket.vanillaplus.reference.Reference;
import com.cricket.vanillaplus.tiles.TileEntityAdvancedSmelter;
import com.cricket.vanillaplus.tiles.TileEntityRockCrusher;
import com.cricket.vanillaplus.worldgen.VPWorldGen;
import com.cricket.vanillaplus.worldgen.base.CaveBase;
import com.cricket.vanillaplus.worldgen.biomes.BiomeGenLavaForest;
import com.cricket.vanillaplus.worldgen.biomes.BiomeGenWaterForest;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class Registry {
	
	public static final BiomeGenBase waterForest = new BiomeGenWaterForest(BiomeIDReference.waterForest).setBiomeName("Water Forest");
	public static final BiomeGenBase lavaForest = new BiomeGenLavaForest(BiomeIDReference.lavaForest).setBiomeName("Lava Forest");
	
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
	public static Block BlockGrinder;
	public static Block BlockSapling;
	
	public static Item ItemPebble;
	public static Item ItemCompressedCoal;
	public static Item ItemCompressedDiamond;
	public static Item ItemParticleTester;
	public static Item ItemCrystalOre;
	public static Item ItemCrystal;
	
	public static String pig = "pigCarcass";
	
	public static VPWorldGen worldGen = new VPWorldGen();
	
	public static List<CaveBase> caveBase = new ArrayList();
	
	private static void preInit(){
		preBlocks();
		preItems();
	}
	
	private static void preBlocks(){
		BlockRockCrusherIdle = new BlockRockCrusher(Material.rock, false).setHardness(3.5F).setCreativeTab(CreativeTabMain.VANILLAPLUS_TAB).setBlockName("rockCrusherIdle");
		BlockRockCrusherActive = new BlockRockCrusher(Material.rock, true).setHardness(3.5F).setBlockName("rockCrusherActive");
		BlockCrystalOre = new BlockCrystalOre().setCreativeTab(CreativeTabMain.VANILLAPLUS_TAB).setBlockName("crystalOre");
		BlockLavaInfusedLeaves = new BlockLavaInfusedLeaves(Material.leaves).setCreativeTab(CreativeTabMain.VANILLAPLUS_TAB).setLightLevel(1000).setBlockName("lavaInfusedLeaves");
		BlockLavaInfusedLog = new BlockLavaInfusedLog(Material.wood).setCreativeTab(CreativeTabMain.VANILLAPLUS_TAB).setBlockName("lavaInfusedLog");
		BlockLavaInfusedPlanks = new BlockLavaInfusedPlanks(Material.wood).setCreativeTab(CreativeTabMain.VANILLAPLUS_TAB).setBlockName("lavaInfusedPlanks");
		BlockWaterInfusedLeaves = new BlockWaterInfusedLeaves(Material.leaves).setCreativeTab(CreativeTabMain.VANILLAPLUS_TAB).setBlockName("waterInfusedLeaves");
		BlockWaterInfusedLog = new BlockWaterInfusedLog(Material.wood).setCreativeTab(CreativeTabMain.VANILLAPLUS_TAB).setBlockName("waterInfusedLog");
		BlockWaterInfusedPlanks = new BlockWaterInfusedPlanks(Material.wood).setCreativeTab(CreativeTabMain.VANILLAPLUS_TAB).setBlockName("waterInfusedPlanks");
		BlockCompressor = new BlockCompressor(Material.rock).setCreativeTab(CreativeTabMain.VANILLAPLUS_TAB).setBlockName("compressor");
		BlockAdvancedSmelterIdle = new BlockAdvancedSmelter(Material.rock).setCreativeTab(CreativeTabMain.VANILLAPLUS_TAB).setBlockName("advancedSmelterIdle");
		BlockAdvancedSmelterActive = new BlockAdvancedSmelter(Material.rock).setBlockName("advancedSmelterActive").setLightLevel(500);
		BlockLavaInfusedCraftingTable = new BlockLavaInfusedCraftingTable(Material.wood).setCreativeTab(CreativeTabMain.VANILLAPLUS_TAB).setBlockName("lavaInfusedCraftingTable");
		BlockGrinder = new BlockGrinder().setHardness(3.5F).setCreativeTab(CreativeTabMain.VANILLAPLUS_TAB).setBlockName("grinder");
		BlockSapling = new BlockSapling().setCreativeTab(CreativeTabNature.VP_NATURE);
	}
	
	private static void preItems(){
		ItemPebble = new ItemPebble().setCreativeTab(CreativeTabMain.VANILLAPLUS_TAB).setUnlocalizedName("pebble");
		ItemCompressedCoal = new ItemCompressedCoal().setCreativeTab(CreativeTabMain.VANILLAPLUS_TAB).setUnlocalizedName("compressedCoal");
		ItemCompressedDiamond = new ItemCompressedDiamond().setCreativeTab(CreativeTabMain.VANILLAPLUS_TAB).setUnlocalizedName("compressedDiamond");
		ItemParticleTester = new ItemParticleTester().setCreativeTab(CreativeTabMain.VANILLAPLUS_TAB).setUnlocalizedName("particleTester");
		ItemCrystalOre = new ItemCrystalOre().setCreativeTab(CreativeTabMain.VANILLAPLUS_TAB).setUnlocalizedName("crystalOre");
		ItemCrystal = new ItemCrystal().setCreativeTab(CreativeTabMain.VANILLAPLUS_TAB).setUnlocalizedName("crystalOre");
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
		GameRegistry.registerBlock(BlockCompressor, ItemBlock.class, BlockCompressor.getUnlocalizedName());
		GameRegistry.registerBlock(BlockCrystalOre, ItemBlockMultiple.class, BlockCrystalOre.getUnlocalizedName());
		GameRegistry.registerBlock(BlockLavaInfusedLeaves, ItemBlock.class, BlockLavaInfusedLeaves.getUnlocalizedName());
		GameRegistry.registerBlock(BlockLavaInfusedLog, ItemBlock.class, BlockLavaInfusedLog.getUnlocalizedName());
		GameRegistry.registerBlock(BlockLavaInfusedPlanks, ItemBlock.class, BlockLavaInfusedPlanks.getUnlocalizedName());
		GameRegistry.registerBlock(BlockLavaInfusedCraftingTable, ItemBlock.class, BlockLavaInfusedCraftingTable.getUnlocalizedName());
		GameRegistry.registerBlock(BlockWaterInfusedLeaves, ItemBlock.class, BlockWaterInfusedLeaves.getUnlocalizedName());
		GameRegistry.registerBlock(BlockWaterInfusedLog, ItemBlock.class, BlockWaterInfusedLog.getUnlocalizedName());
		GameRegistry.registerBlock(BlockWaterInfusedPlanks, ItemBlock.class, BlockWaterInfusedPlanks.getUnlocalizedName());
		GameRegistry.registerBlock(BlockSapling, ItemSapling.class, "sapling");
		GameRegistry.registerBlock(BlockGrinder, ItemBlock.class, BlockGrinder.getUnlocalizedName());
	}
	private static void items(){
		GameRegistry.registerItem(ItemPebble,"Pebble");
		GameRegistry.registerItem(ItemCompressedCoal, "CompressedCoal");
		GameRegistry.registerItem(ItemCompressedDiamond, "CompressedDiamond");
		GameRegistry.registerItem(ItemParticleTester, "ParticleTester");
		GameRegistry.registerItem(ItemCrystal, "Crystal");
		GameRegistry.registerItem(ItemCrystalOre, "CrystalOre");
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
