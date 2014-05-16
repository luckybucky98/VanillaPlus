package com.cricket.vanillaplus;

import java.util.HashMap;
import java.util.Map;

import net.minecraftforge.common.Configuration;

import com.cricket.vanillaplus.api.PreInitBlockCreating;
import com.cricket.vanillaplus.api.Registry;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;


@Mod(modid=Reference.MODID, name=Reference.NAME, version=Reference.VERSION)
@NetworkMod(clientSideRequired=true)
public class VanillaPlus {
	
	public static Map<String, PlayerCapesClient> playersClient = new HashMap<String, PlayerCapesClient>();
	
	//GUI
	public static final int guiIDRockCrusher=0;
	public static final int guiIDAdvancedSmelter=1;
	
	@Instance(Reference.MODID)
	public static VanillaPlus instance;
	
	@SidedProxy(clientSide = "com.cricket.vanillaplus.client.ClientProxy", serverSide = "com.cricket.vanillaplus.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	private void preInit(FMLPreInitializationEvent event){
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		
		Registry.BlockAdvancedSmelterIdleID = config.get("Block ID's", "Advanced Smelter Off", 700).getInt();
		Registry.BlockAdvancedSmelterActiveID = config.get("Block ID's", "Advanced Smelter On", 701).getInt();
		Registry.BlockCompressorID = config.get("Block ID's", "Compressor", 702).getInt();
		Registry.BlockCrystalOreID = config.get("Block ID's", "Crystal Ore", 703).getInt();
		Registry.BlockLavaInfusedLeavesID = config.get("Block ID's", "Lava Infused Leaves", 704).getInt();
		Registry.BlockLavaInfusedTreeID = config.get("Block ID's", "Lava Infused Tree", 705).getInt();
		Registry.BlockLavaInfusedWoodID = config.get("Block ID's", "Lava Infused Wood", 706).getInt();
		Registry.BlockWaterInfusedLeavesID = config.get("Block ID's", "Water Infused Leaves", 707).getInt();
		Registry.BlockWaterInfusedTreeID = config.get("Block ID's", "Water Infused Tree", 708).getInt();
		Registry.BlockWaterInfusedWoodID = config.get("Block ID's", "Water Infused Wood", 709).getInt();
		
		
		Registry.ItemPebbleid = config.get("Item IDs", "Pebble", 600).getInt();
		Registry.ItemCompressedCoalid = config.get("Item IDs", "Compressed Coal", 601).getInt();
		Registry.ItemCompressedDiamondid = config.get("Item ID's", "Compressed Diamond", 602).getInt();
		
		config.save();
		proxy.preInit(event);
		PreInitBlockCreating.load();
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event){
		Registry.load();
		proxy.init(event);
	}
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		proxy.postInit(event);
	}

}
