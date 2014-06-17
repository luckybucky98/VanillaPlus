package com.cricket.vanillaplus;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;

import com.cricket.vanillaplus.blocks.*;
import com.cricket.vanillaplus.creativetab.CreativeTab;
import com.cricket.vanillaplus.handlers.GuiHandler;
import com.cricket.vanillaplus.items.*;
import com.cricket.vanillaplus.tiles.*;

import cpw.mods.fml.common.Mod.EventHandler;
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
	public static Block BlockFurnace;
	public static Block BlockGrinder;
	
	public static Item ItemPebble;
	public static Item ItemCompressedCoal;
	public static Item ItemCompressedDiamond;
	public static Item ItemParticleTester;
	
	private static void preInit(){
		preBlocks();
		preItems();
	}
	
	private static void preBlocks(){
		BlockRockCrusherIdle = new BlockRockCrusher(Material.rock, false).setHardness(3.5F).setCreativeTab(CreativeTab.VANILLAPLUS_TAB).setBlockName("rockCrusherIdle");
		BlockRockCrusherActive = new BlockRockCrusher(Material.rock, true).setHardness(3.5F).setBlockName("rockCrusherActive");
		BlockCrystalOre = new BlockCrystalOre(Material.rock).setCreativeTab(CreativeTab.VANILLAPLUS_TAB).setBlockName("crystalOre");
		BlockLavaInfusedLeaves = new BlockLavaInfusedLeaves(Material.leaves).setCreativeTab(CreativeTab.VANILLAPLUS_TAB).setLightLevel(1000).setBlockName("lavaInfusedLeaves");
		BlockLavaInfusedLog = new BlockLavaInfusedLog(Material.wood).setCreativeTab(CreativeTab.VANILLAPLUS_TAB).setBlockName("lavaInfusedLog");
		BlockLavaInfusedPlanks = new BlockLavaInfusedPlanks(Material.wood).setCreativeTab(CreativeTab.VANILLAPLUS_TAB).setBlockName("lavaInfusedPlanks");
		BlockWaterInfusedLeaves = new BlockWaterInfusedLeaves(Material.leaves).setCreativeTab(CreativeTab.VANILLAPLUS_TAB).setBlockName("waterInfusedLeaves");
		BlockWaterInfusedLog = new BlockWaterInfusedLog(Material.wood).setCreativeTab(CreativeTab.VANILLAPLUS_TAB).setBlockName("waterInfusedLog");
		BlockWaterInfusedPlanks = new BlockWaterInfusedPlanks(Material.wood).setCreativeTab(CreativeTab.VANILLAPLUS_TAB).setBlockName("waterInfusedPlanks");
		BlockCompressor = new BlockCompressor(Material.rock).setCreativeTab(CreativeTab.VANILLAPLUS_TAB).setBlockName("compressor");
		BlockAdvancedSmelterIdle = new BlockAdvancedSmelter(Material.rock).setCreativeTab(CreativeTab.VANILLAPLUS_TAB).setBlockName("advancedSmelterIdle");
		BlockAdvancedSmelterActive = new BlockAdvancedSmelter(Material.rock).setBlockName("advancedSmelterActive").setLightLevel(500);
		BlockLavaInfusedCraftingTable = new BlockLavaInfusedCraftingTable(Material.wood).setCreativeTab(CreativeTab.VANILLAPLUS_TAB).setBlockName("lavaInfusedCraftingTable");
		BlockFurnace = new BlockFurnace(Material.rock).setHardness(3.5f).setCreativeTab(CreativeTab.VANILLAPLUS_TAB).setBlockName("furnace");
		BlockGrinder = new BlockGrinder().setHardness(3.5F).setCreativeTab(CreativeTab.VANILLAPLUS_TAB).setBlockName("grinder");
	}
	
	private static void preItems(){
		ItemPebble = new ItemPebble().setCreativeTab(CreativeTab.VANILLAPLUS_TAB).setUnlocalizedName("pebble");
		ItemCompressedCoal = new ItemCompressedCoal().setCreativeTab(CreativeTab.VANILLAPLUS_TAB).setUnlocalizedName("compressedCoal");
		ItemCompressedDiamond = new ItemCompressedDiamond().setCreativeTab(CreativeTab.VANILLAPLUS_TAB).setUnlocalizedName("compressedDiamond");
		ItemParticleTester = new ItemParticleTester().setCreativeTab(CreativeTab.VANILLAPLUS_TAB).setUnlocalizedName("particleTester");
	}
	
	private static void game(){
		blocks();
		items();
		tiles();
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
		GameRegistry.registerBlock(BlockCrystalOre, ItemBlock.class, BlockCrystalOre.getUnlocalizedName());
		GameRegistry.registerBlock(BlockLavaInfusedLeaves, ItemBlock.class, BlockLavaInfusedLeaves.getUnlocalizedName());
		GameRegistry.registerBlock(BlockLavaInfusedLog, ItemBlock.class, BlockLavaInfusedLog.getUnlocalizedName());
		GameRegistry.registerBlock(BlockLavaInfusedPlanks, ItemBlock.class, BlockLavaInfusedPlanks.getUnlocalizedName());
		GameRegistry.registerBlock(BlockLavaInfusedCraftingTable, ItemBlock.class, BlockLavaInfusedCraftingTable.getUnlocalizedName());
		GameRegistry.registerBlock(BlockWaterInfusedLeaves, ItemBlock.class, BlockWaterInfusedLeaves.getUnlocalizedName());
		GameRegistry.registerBlock(BlockWaterInfusedLog, ItemBlock.class, BlockWaterInfusedLog.getUnlocalizedName());
		GameRegistry.registerBlock(BlockWaterInfusedPlanks, ItemBlock.class, BlockWaterInfusedPlanks.getUnlocalizedName());
		GameRegistry.registerBlock(BlockFurnace, ItemBlock.class, BlockFurnace.getUnlocalizedName());
		GameRegistry.registerBlock(BlockGrinder, ItemBlock.class, BlockGrinder.getUnlocalizedName());
	}
	private static void items(){
		GameRegistry.registerItem(ItemPebble,"Pebble");
		GameRegistry.registerItem(ItemCompressedCoal, "CompressedCoal");
		GameRegistry.registerItem(ItemCompressedDiamond, "CompressedDiamond");
		GameRegistry.registerItem(ItemParticleTester, "ParticleTester");
	}
	private static void tiles(){
		GameRegistry.registerTileEntity(TileEntityRockCrusher.class, "RockCrusher");
		GameRegistry.registerTileEntity(TileEntityAdvancedSmelter.class, "AdvancedSmelter");
	}
	public static void load(){
		preInit();
		game();
		network();
	}
}
