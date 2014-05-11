package com.cricket.vanillaplus.api;

import net.minecraft.block.material.Material;

import com.cricket.vanillaplus.blocks.BlockAdvancedSmelter;
import com.cricket.vanillaplus.blocks.BlockCompressor;
import com.cricket.vanillaplus.blocks.BlockCrystalOre;
import com.cricket.vanillaplus.blocks.BlockLavaInfusedLeaves;
import com.cricket.vanillaplus.blocks.BlockLavaInfusedTree;
import com.cricket.vanillaplus.blocks.BlockLavaInfusedWood;
import com.cricket.vanillaplus.blocks.BlockRockCrusher;
import com.cricket.vanillaplus.blocks.BlockWaterInfusedLeaves;
import com.cricket.vanillaplus.blocks.BlockWaterInfusedTree;
import com.cricket.vanillaplus.blocks.BlockWaterInfusedWood;
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
		Registry.ItemPebble = new ItemPebble(Registry.ItemPebbleid).setCreativeTab(CreativeTab.VANILLAPLUS_TAB);
		Registry.ItemCompressedCoal = new ItemCompressedCoal(Registry.ItemCompressedCoalid).setCreativeTab(CreativeTab.VANILLAPLUS_TAB);
		Registry.ItemCompressedDiamond = new ItemCompressedDiamond(Registry.ItemCompressedDiamondid).setCreativeTab(CreativeTab.VANILLAPLUS_TAB);
	}
	public static void blocks(){
		Registry.BlockRockCrusherIdle = new BlockRockCrusher(710,false).setUnlocalizedName("rockCrusherIdle").setHardness(3.5F).setCreativeTab(CreativeTab.VANILLAPLUS_TAB);
		Registry.BlockRockCrusherActive = new BlockRockCrusher(711,true).setUnlocalizedName("rockCrusherActive").setHardness(3.5F).setLightValue(0.9F);
		Registry.BlockCrystalOre = new BlockCrystalOre(Registry.BlockCrystalOreID, Material.rock).setUnlocalizedName("crystalOre").setCreativeTab(CreativeTab.VANILLAPLUS_TAB);
		Registry.BlockLavaInfusedLeaves = new BlockLavaInfusedLeaves(Registry.BlockLavaInfusedLeavesID, Material.leaves).setUnlocalizedName("lavaInfusedLeaves").setCreativeTab(CreativeTab.VANILLAPLUS_TAB);
		Registry.BlockLavaInfusedTree = new BlockLavaInfusedTree(Registry.BlockLavaInfusedTreeID, Material.wood).setUnlocalizedName("lavaInfusedWood").setCreativeTab(CreativeTab.VANILLAPLUS_TAB);
		Registry.BlockLavaInfusedWood = new BlockLavaInfusedWood(Registry.BlockLavaInfusedWoodID, Material.wood).setUnlocalizedName("lavaInfusedWood").setCreativeTab(CreativeTab.VANILLAPLUS_TAB);
		Registry.BlockWaterInfusedLeaves = new BlockWaterInfusedLeaves(Registry.BlockWaterInfusedLeavesID, Material.leaves).setUnlocalizedName("waterInfusedLeaves").setCreativeTab(CreativeTab.VANILLAPLUS_TAB);
		Registry.BlockWaterInfusedTree = new BlockWaterInfusedTree(Registry.BlockWaterInfusedTreeID, Material.wood).setUnlocalizedName("waterInfusedTree").setCreativeTab(CreativeTab.VANILLAPLUS_TAB);
		Registry.BlockWaterInfusedWood = new BlockWaterInfusedWood(Registry.BlockWaterInfusedWoodID, Material.wood).setUnlocalizedName("waterInfusedWood").setCreativeTab(CreativeTab.VANILLAPLUS_TAB);
		Registry.BlockCompressor = new BlockCompressor(Registry.BlockCompressorID, Material.rock).setUnlocalizedName("compressor").setCreativeTab(CreativeTab.VANILLAPLUS_TAB);
		Registry.BlockAdvancedSmelterIdle = new BlockAdvancedSmelter(Registry.BlockAdvancedSmelterIdleID,false).setUnlocalizedName("advancedSmelterIdle").setCreativeTab(CreativeTab.VANILLAPLUS_TAB);
		Registry.BlockAdvancedSmelterActive = new BlockAdvancedSmelter(Registry.BlockAdvancedSmelterActiveID,true).setUnlocalizedName("advancedSmelterActive").setCreativeTab(CreativeTab.VANILLAPLUS_TAB);
	}
}
