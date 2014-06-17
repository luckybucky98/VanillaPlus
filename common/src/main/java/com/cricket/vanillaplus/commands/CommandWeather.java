package com.cricket.vanillaplus.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.util.ChatComponentTranslation;

public class CommandWeather extends CommandBase{
	@Override
	public String getCommandName(){
		return "vpweather";
	}
	
	@Override
	public String getCommandUsage(ICommandSender sender){
		return "commands.vpweather.usage";
	}
	
	@Override
	public void processCommand(ICommandSender sender, String[] commands){
		try {
			if(commands.length < 9){
				sender.addChatMessage(new ChatComponentTranslation("commands.vpweather.fail", new Object[0]));
				throw new WrongUsageException("Invalid Usage");
			} else {
				if(commands[0].equalsIgnoreCase("bloodrain")){
					
				}
			}
		} catch(Exception e){
			System.out.println("[Vanilla Plus] Player did a wrong command");
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender){
		return sender.canCommandSenderUseCommand(this.getRequiredPermissionLevel(), this.getCommandName());
	}
}
