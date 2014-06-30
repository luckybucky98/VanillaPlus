package com.cricket.vanillaplus.handlers;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigurationHandler {
	public static void init(File configFile){
		Configuration config = new Configuration(configFile);
		boolean configValue = false;
		
		try{
			config.load();
			configValue = config.get(Configuration.CATEGORY_GENERAL, "configValue", true, "Oh cool you have the dev version!").getBoolean(true);
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			config.save();
		}
		
		System.out.println(configValue);
		
		if(config.hasChanged()){
			config.save();
		}
	}
}
