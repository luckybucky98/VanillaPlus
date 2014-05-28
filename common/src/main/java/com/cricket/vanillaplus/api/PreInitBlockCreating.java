package com.cricket.vanillaplus.api;

import net.minecraft.block.material.Material;

import com.cricket.vanillaplus.blocks.BlockAdvancedSmelter;
import com.cricket.vanillaplus.blocks.BlockCompressor;
import com.cricket.vanillaplus.blocks.BlockCrystalOre;
import com.cricket.vanillaplus.blocks.BlockFurnace;
import com.cricket.vanillaplus.blocks.BlockLavaInfusedCraftingTable;
import com.cricket.vanillaplus.blocks.BlockLavaInfusedLeaves;
import com.cricket.vanillaplus.blocks.BlockLavaInfusedLog;
import com.cricket.vanillaplus.blocks.BlockLavaInfusedPlanks;
import com.cricket.vanillaplus.blocks.BlockRockCrusher;
import com.cricket.vanillaplus.blocks.BlockWaterInfusedLeaves;
import com.cricket.vanillaplus.blocks.BlockWaterInfusedLog;
import com.cricket.vanillaplus.blocks.BlockWaterInfusedPlanks;
import com.cricket.vanillaplus.creativetab.CreativeTab;
import com.cricket.vanillaplus.items.ItemCompressedCoal;
import com.cricket.vanillaplus.items.ItemCompressedDiamond;
import com.cricket.vanillaplus.items.ItemPebble;

public class PreInitBlockCreating {
	public static void load(){
		items();
		blocks();
	}
	public static void items(){
		Registry.ItemPebble = new ItemPebble(Registry.ItemPebbleid).setCreativeTab(CreativeTab.VANILLAPLUS_TAB).setUnlocalizedName("pebble");
		Registry.ItemCompressedCoal = new ItemCompressedCoal(Registry.ItemCompressedCoalid).setCreativeTab(CreativeTab.VANILLAPLUS_TAB).setUnlocalizedName("compressedCoal");
		Registry.ItemCompressedDiamond = new ItemCompressedDiamond(Registry.ItemCompressedDiamondid).setCreativeTab(CreativeTab.VANILLAPLUS_TAB).setUnlocalizedName("compressedDiamond");
	}
	public static void blocks(){
		Registry.BlockRockCrusherIdle = new BlockRockCrusher(1001,false).setUnlocalizedName("rockCrusherIdle").setHardness(3.5F).setCreativeTab(CreativeTab.VANILLAPLUS_TAB);
		Registry.BlockRockCrusherActive = new BlockRockCrusher(1002,true).setUnlocalizedName("rockCrusherActive").setHardness(3.5F).setLightValue(0.9F);
		Registry.BlockCrystalOre = new BlockCrystalOre(Registry.BlockCrystalOreID, Material.rock).setUnlocalizedName("crystalOre").setCreativeTab(CreativeTab.VANILLAPLUS_TAB);
		Registry.BlockLavaInfusedLeaves = new BlockLavaInfusedLeaves(Registry.BlockLavaInfusedLeavesID, Material.leaves).setUnlocalizedName("lavaInfusedLeaves").setCreativeTab(CreativeTab.VANILLAPLUS_TAB).setLightOpacity(1000).setLightValue(1.0F);
		Registry.BlockLavaInfusedLog = new BlockLavaInfusedLog(Registry.BlockLavaInfusedLogID, Material.wood).setUnlocalizedName("lavaInfusedPlanks").setCreativeTab(CreativeTab.VANILLAPLUS_TAB);
		Registry.BlockLavaInfusedPlanks = new BlockLavaInfusedPlanks(Registry.BlockLavaInfusedPlanksID, Material.wood).setUnlocalizedName("lavaInfusedPlanks").setCreativeTab(CreativeTab.VANILLAPLUS_TAB);
		Registry.BlockWaterInfusedLeaves = new BlockWaterInfusedLeaves(Registry.BlockWaterInfusedLeavesID, Material.leaves).setUnlocalizedName("waterInfusedLeaves").setCreativeTab(CreativeTab.VANILLAPLUS_TAB);
		Registry.BlockWaterInfusedLog = new BlockWaterInfusedLog(Registry.BlockWaterInfusedLogID, Material.wood).setUnlocalizedName("waterInfusedLog").setCreativeTab(CreativeTab.VANILLAPLUS_TAB);
		Registry.BlockWaterInfusedPlanks = new BlockWaterInfusedPlanks(Registry.BlockWaterInfusedPlanksID, Material.wood).setUnlocalizedName("waterInfusedPlanks").setCreativeTab(CreativeTab.VANILLAPLUS_TAB);
		Registry.BlockCompressor = new BlockCompressor(Registry.BlockCompressorID, Material.rock).setUnlocalizedName("compressor").setCreativeTab(CreativeTab.VANILLAPLUS_TAB);
		Registry.BlockAdvancedSmelterIdle = new BlockAdvancedSmelter(Registry.BlockAdvancedSmelterIdleID,false).setUnlocalizedName("advancedSmelterIdle").setCreativeTab(CreativeTab.VANILLAPLUS_TAB);
		Registry.BlockAdvancedSmelterActive = new BlockAdvancedSmelter(Registry.BlockAdvancedSmelterActiveID,true).setUnlocalizedName("advancedSmelterActive").setCreativeTab(CreativeTab.VANILLAPLUS_TAB);
		Registry.BlockLavaInfusedCraftingTable = new BlockLavaInfusedCraftingTable(Registry.BlockLavaInfusedCraftingTableID, Material.wood).setUnlocalizedName("lavaInfusedCraftingTable").setCreativeTab(CreativeTab.VANILLAPLUS_TAB);
		Registry.BlockFurnace = new BlockFurnace(Registry.BlockFurnaceID, Material.rock).setUnlocalizedName("furnace").setHardness(3.5f).setCreativeTab(CreativeTab.VANILLAPLUS_TAB);
	}
}
