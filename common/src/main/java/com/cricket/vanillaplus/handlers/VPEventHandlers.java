package com.cricket.vanillaplus.handlers;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;

public class VPEventHandlers {
	public static void init(){
		registerMiscEventHandlers();
	}
	private static void registerMiscEventHandlers(){
		//MinecraftForge.EVENT_BUS.register(new CapeEventHandler());
		MinecraftForge.EVENT_BUS.register(new ParticleHandler());
		MinecraftForge.EVENT_BUS.register(new PlayerJoinHandler());
		MinecraftForge.EVENT_BUS.register(new GuiHandler());
		MinecraftForge.EVENT_BUS.register(new LivingDeathEventHandler());
		FMLCommonHandler.instance().bus().register(new ServerTickHandler());
	}
}
