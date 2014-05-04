package com.cricket.vanillaplus;

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
	
	//GUI
	public static final int guiIDRockCrusher=0;
	
	@Instance(Reference.MODID)
	public static VanillaPlus instance;
	
	@SidedProxy(clientSide = "com.cricket.vanillaplus.client.ClientProxy", serverSide = "com.cricket.vanillaplus.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	private void preInit(FMLPreInitializationEvent event){
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		Registry.ItemPebbleid = config.get("Item IDs", "Pebble", 600).getInt();
		
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
