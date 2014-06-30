package com.cricket.vanillaplus;

import net.minecraftforge.common.config.Configuration;

import com.cricket.vanillaplus.Recipes.Crafting;
import com.cricket.vanillaplus.handlers.ConfigurationHandler;
import com.cricket.vanillaplus.handlers.VPEventHandlers;
import com.cricket.vanillaplus.reference.Reference;
import com.cricket.vanillaplus.worldgen.TreeManager;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;


@Mod(modid=Reference.MODID, name=Reference.NAME, version=Reference.VERSION, guiFactory = "com.cricket.vanillaplus.gui.GuiFactory")
public class VanillaPlus {
	
	public static Configuration config;
	
	@Instance(Reference.MODID)
	public static VanillaPlus instance;
	
	@SidedProxy(clientSide = "com.cricket.vanillaplus.client.ClientProxy", serverSide = "com.cricket.vanillaplus.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	private void preInit(FMLPreInitializationEvent event){
		proxy.preInit(event);
		VPEventHandlers.init();
		Crafting.loadCraftingRecipes();
		Registry.load();
		config = new Configuration(event.getSuggestedConfigurationFile());
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		proxy.init(event);
	}
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		proxy.postInit(event);
	}

}
