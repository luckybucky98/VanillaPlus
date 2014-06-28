package com.cricket.vanillaplus.handlers;

import net.minecraft.util.ChatComponentText;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class PlayerJoinHandler {
	@SubscribeEvent
	public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event){
		event.player.addChatMessage(new ChatComponentText("Welcome " + event.player.getDisplayName() + " to the amazing world of VanillaPlus"));
	}
}
