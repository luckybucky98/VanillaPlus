package com.vanillaplus.georgecode;

import com.vanillaplus.georgecode.blocks.BlockAdvancedSmelter;
import com.vanillaplus.georgecode.blocks.BlockCompressor;
import com.vanillaplus.georgecode.blocks.BlockLavaInfusedTree;
import com.vanillaplus.georgecode.blocks.BlockLavaInfusedWood;
import com.vanillaplus.georgecode.blocks.BlockLavaLeaves;
import com.vanillaplus.georgecode.blocks.BlockWaterInfusedTree;
import com.vanillaplus.georgecode.blocks.BlockCrystalOre;
import com.vanillaplus.georgecode.blocks.BlockWaterInfusedTreeLeaves;
import com.vanillaplus.georgecode.blocks.BlockWaterInfusedWood;
import com.vanillaplus.georgecode.items.itemBasic;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


@Mod(modid=Reference.MODID, name=Reference.NAME, version=Reference.VERSION)
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class VanillaplusMain {
	
	//BLOCKS
	//public static Block blockAdvancedSmelter;
	public static Block blockCompressor;
	public static Block blockCrystalOre;
	public static Block blockLavaInfusedTree;
	public static Block blockWaterInfusedTree;
	public static Block blockLavaLeaves;
	public static Block blockWaterInfusedTreeLeaves;
	public static Block blockAdvancedSmelterIdle;
	public static Block blockAdvancedSmelterActive;
	public static Block blockLavaInfusedWood;
	public static Block blockWaterInfusedWood;

	
	
	//ITEMS
	public static Item itemCompressedCoal;
	public static Item itemSuperDiamond;
	
	@EventHandler
	public void load(FMLInitializationEvent e){
		
		//blockAdvancedSmelter = new BlockAdvancedSmelter(2650, Material.iron) .setUnlocalizedName("AdvancedSmelterBlock");
		blockAdvancedSmelterIdle = new BlockAdvancedSmelter(2640,false) .setUnlocalizedName("AdvancedSmelterIdleBlock");
		blockAdvancedSmelterActive = new BlockAdvancedSmelter(2641,true) .setUnlocalizedName("AdvancedSmelterActiveBlock").setLightValue(0.7F);
		blockWaterInfusedTreeLeaves = new BlockWaterInfusedTreeLeaves(2656, Material.leaves) .setUnlocalizedName("WaterInfusedTreeLeavesBlock");
		blockCompressor = new BlockCompressor(2651, Material.iron) .setUnlocalizedName("CompressorBlock");
		blockCrystalOre = new BlockCrystalOre(2652, Material.rock) .setUnlocalizedName("CrystalOreBlock");
		blockLavaInfusedTree = new BlockLavaInfusedTree(2653, Material.wood) .setUnlocalizedName("LavaInfusedTreeBlock");
		blockLavaLeaves = new BlockLavaLeaves(2655, Material.leaves) .setUnlocalizedName("LavaLeavesBlock");
		blockWaterInfusedTree = new BlockWaterInfusedTree(2654, Material.wood) .setUnlocalizedName("WaterInfusedTreeBlock");
		blockWaterInfusedWood = new BlockWaterInfusedWood(2658, Material.wood) .setUnlocalizedName("WaterInfusedTreeWood");
		blockLavaInfusedWood = new BlockLavaInfusedWood(2657, Material.wood) .setUnlocalizedName("LavaInfusedTreeWood");


		//registerBlock(blockAdvancedSmelter, "Advanced Smelter");
		registerBlock(blockAdvancedSmelterIdle, "Advanced Smelter");
		registerBlock(blockAdvancedSmelterActive, "Advanced Smelter Active");
		registerBlock(blockCompressor, "Compressor");
		registerBlock(blockCrystalOre, "CrystalOre");
		registerBlock(blockLavaInfusedTree, "Lava Infused Tree Log");
		registerBlock(blockLavaLeaves, "Lava  Leaves");
		registerBlock(blockWaterInfusedTree, "Water Infused Tree Log");
		registerBlock(blockWaterInfusedTreeLeaves, "Water Infused Tree Leaves");
		registerBlock(blockWaterInfusedWood, "Water Infused Wood");
		registerBlock(blockLavaInfusedWood, "Lava Infused Wood");

		//Items
		itemCompressedCoal = new itemBasic(12450).setUnlocalizedName("Compressed Coal");
		itemSuperDiamond = new itemBasic(12451).setUnlocalizedName("Super Diamond");
		
		registerItem(itemCompressedCoal, "Compressed Coal");
		registerItem(itemSuperDiamond, "SuperDiamond");
		}
	
	public void registerBlock(Block block, String name){
		GameRegistry.registerBlock(block, block.getUnlocalizedName());
		LanguageRegistry.addName(block, name);
	}
	
	public void registerItem(Item item,String name){
		GameRegistry.registerItem(item, item.getUnlocalizedName());
		LanguageRegistry.addName(item,name);
	}
}
