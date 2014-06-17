package com.cricket.vanillaplus.handlers;

import net.minecraft.world.World;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ServerTickEvent;

public class ServerTickHandler {
	
	private ServerTickEvent event;
	private World lastWorld;
	
	public ServerTickHandler(){
		onTick(event);
	}
	
	@SubscribeEvent
	public void onTick(ServerTickEvent event){
		if(FMLCommonHandler.instance() == null || FMLCommonHandler.instance().getMinecraftServerInstance() == null){
			return;
		}
		
		World world = FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(0);
		
		if(world != null && lastWorld != world){
			
		}
	}
}
