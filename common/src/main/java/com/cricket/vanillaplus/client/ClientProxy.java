package com.cricket.vanillaplus.client;

import com.cricket.vanillaplus.CommonProxy;
import com.cricket.vanillaplus.client.rendering.mobs.RenderPigCarcass;
import com.cricket.vanillaplus.mobs.EntityPigCarcass;
import com.cricket.vanillaplus.models.ModelPigCarcass;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	
	public static int renderPass;
	public static int crystalClusterRenderType;
	public static int pigCarcassRenderType;
	
	public void preInit(FMLPreInitializationEvent event){
		
	}
	public void init(FMLInitializationEvent event){
		setupCustomRenderers();
	}
	public void postInit(FMLPostInitializationEvent event){
		
	}
	
	private static void setupCustomRenderers(){
		crystalClusterRenderType = RenderingRegistry.getNextAvailableRenderId();
		pigCarcassRenderType = RenderingRegistry.getNextAvailableRenderId();
		
		//RenderingRegistry.registerBlockHandler(new CrystalClusterRenderer());
		RenderingRegistry.registerEntityRenderingHandler(EntityPigCarcass.class, new RenderPigCarcass(new ModelPigCarcass(), 0.5F));
	}
}
