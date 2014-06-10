package com.cricket.vanillaplus;

import net.minecraftforge.common.config.Configuration;

import com.cricket.vanillaplus.Recipes.Crafting;
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
import cpw.mods.fml.common.registry.GameRegistry;


@Mod(modid=Reference.MODID, name=Reference.NAME, version=Reference.VERSION)
public class VanillaPlus {
	
	//TreeManager treeManager = new TreeManager();
	
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
		proxy.preInit(event);
		VPEventHandlers.init();
		Crafting.loadCraftingRecipes();
		Registry.load();
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
