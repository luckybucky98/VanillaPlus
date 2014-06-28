package com.cricket.vanillaplus.handlers;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraftforge.common.MinecraftForge;

public class VPEventHandlers {
	public static void init(){
		registerMiscEventHandlers();
	}
	private static void registerMiscEventHandlers(){
		//MinecraftForge.EVENT_BUS.register(new CapeEventHandler());
		MinecraftForge.EVENT_BUS.register(new ParticleHandler());
		MinecraftForge.EVENT_BUS.register(new PlayerJoinHandler());
		MinecraftForge.EVENT_BUS.register(new GuiHandler());
		FMLCommonHandler.instance().bus().register(new ServerTickHandler());
	}
}
