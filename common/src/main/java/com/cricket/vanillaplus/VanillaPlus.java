package com.cricket.vanillaplus;

import net.minecraftforge.common.Configuration;

import com.cricket.vanillaplus.Recipes.Crafting;
import com.cricket.vanillaplus.api.PreInitBlockCreating;
import com.cricket.vanillaplus.api.Registry;
import com.cricket.vanillaplus.api.handlers.VPEventHandlers;
import com.cricket.vanillaplus.worldgen.TreeManager;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;


@Mod(modid=Reference.MODID, name=Reference.NAME, version=Reference.VERSION)
@NetworkMod(clientSideRequired=true)
public class VanillaPlus {
	
	TreeManager treeManager = new TreeManager();
	
	//GUI
	public static final int guiIDRockCrusher = 0;
	public static final int guiIDAdvancedSmelter = 1;
	public static final int guiIDLavaInfusedCraftingTable = 2;
	
	@Instance(Reference.MODID)
	public static VanillaPlus instance;
	
	@SidedProxy(clientSide = "com.cricket.vanillaplus.client.ClientProxy", serverSide = "com.cricket.vanillaplus.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	private void preInit(FMLPreInitializationEvent event){
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		
		Registry.BlockAdvancedSmelterIdleID = config.get("Block ID's", "Advanced Smelter Off", 700).getInt(700);
		Registry.BlockAdvancedSmelterActiveID = config.get("Block ID's", "Advanced Smelter On", 701).getInt(701);
		Registry.BlockCompressorID = config.get("Block ID's", "Compressor", 702).getInt(702);
		Registry.BlockCrystalOreID = config.get("Block ID's", "Crystal Ore", 703).getInt(703);
		Registry.BlockLavaInfusedLeavesID = config.get("Block ID's", "Lava Infused Leaves", 704).getInt(704);
		Registry.BlockLavaInfusedLogID = config.get("Block ID's", "Lava Infused Tree", 705).getInt(705);
		Registry.BlockLavaInfusedPlanksID = config.get("Block ID's", "Lava Infused Wood", 706).getInt(706);
		Registry.BlockWaterInfusedLeavesID = config.get("Block ID's", "Water Infused Leaves", 707).getInt(707);
		Registry.BlockWaterInfusedLogID = config.get("Block ID's", "Water Infused Tree", 708).getInt(708);
		Registry.BlockWaterInfusedPlanksID = config.get("Block ID's", "Water Infused Wood", 709).getInt(709);
		Registry.BlockLavaInfusedCraftingTableID = config.get("Block ID's", "Lava Infused Crafting Table", 712).getInt(712);
		Registry.BlockFurnaceID = config.get("Block ID's", "Furnace", 61).getInt(61);
		
		Registry.ItemPebbleid = config.get("Item IDs", "Pebble", 600).getInt(600);
		Registry.ItemCompressedCoalid = config.get("Item IDs", "Compressed Coal", 601).getInt(601);
		Registry.ItemCompressedDiamondid = config.get("Item ID's", "Compressed Diamond", 602).getInt(602);
		Registry.ItemSpawnUnicornid = config.get("Item ID's", "Spawn Unicorn", 603).getInt(603);
		
		config.save();
		proxy.preInit(event);
		PreInitBlockCreating.load();
		VPEventHandlers.init();
		Crafting.loadCraftingRecipes();
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event){
		Registry.load();
		GameRegistry.registerWorldGenerator(treeManager);
		proxy.init(event);
		
	}
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		proxy.postInit(event);
	}

}
