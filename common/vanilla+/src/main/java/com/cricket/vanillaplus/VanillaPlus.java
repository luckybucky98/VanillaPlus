package com.cricket.vanillaplus;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;

import com.cricket.vanillaplus.api.PreInitBlockCreating;
import com.cricket.vanillaplus.api.Registry;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;


@Mod(modid=Reference.MODID, name=Reference.NAME, version=Reference.VERSION)
@NetworkMod(clientSideRequired=true)
public class VanillaPlus {
	
	@Instance(Reference.MODID)
	public static VanillaPlus instance;
	
	//GUI
	public static final int guiIDRockCrusher=0;
	
	@EventHandler
	private void preInit(FMLPreInitializationEvent event){
		System.out.println("[VanillaPlus] Starting Pre-Initialization");
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		Registry.ItemPebbleid = config.get("Item ID's", "Pebble", 600).getInt();
		Registy.ItemBiomeCompassid = config.get("Item ID's", "Biome Compass", 601).getInt();
		
		config.save();
		
		PreInitBlockCreating.load();
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event){
		Registry.load();
	}
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}

}
