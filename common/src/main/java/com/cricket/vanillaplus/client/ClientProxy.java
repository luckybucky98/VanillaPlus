package com.cricket.vanillaplus.client;

import com.cricket.vanillaplus.CommonProxy;
import com.cricket.vanillaplus.client.rendering.CrystalClusterRenderer;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	
	public static int renderPass;
	public static int crystalClusterRenderType;
	
	public void preInit(FMLPreInitializationEvent event){
		
	}
	public void init(FMLInitializationEvent event){
		setupCustomRenderers();
	}
	public void postInit(FMLPostInitializationEvent event){
		
	}
	
	public static void setupCustomRenderers(){
		crystalClusterRenderType = RenderingRegistry.getNextAvailableRenderId();
		
		RenderingRegistry.registerBlockHandler(new CrystalClusterRenderer());
	}
}
