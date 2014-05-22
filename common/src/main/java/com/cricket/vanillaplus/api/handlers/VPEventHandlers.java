package com.cricket.vanillaplus.api.handlers;

import net.minecraftforge.common.MinecraftForge;

public class VPEventHandlers {
	public static void init(){
		registerMiscEventHandlers();
	}
	private static void registerMiscEventHandlers(){
		MinecraftForge.EVENT_BUS.register(new CapeEventHandler());
	}
}
