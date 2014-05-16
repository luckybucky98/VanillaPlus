package com.cricket.vanillaplus;

import java.io.File;

import net.minecraftforge.common.Configuration;

public class ConfigManager {
	public static boolean loaded;
	static Configuration configuration;
	
	public static boolean overrideCapes;
	
	public static void setDefaultValues(File file){
		if(!ConfigManager.loaded){
			ConfigManager.configuration = new Configuration(file);
		} try {
			ConfigManager.configuration.load();
			
			ConfigManager.overrideCapes = ConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Override Capes", true, "By default we allow our devs, testers, and donors to have capes. Set this to false to disable their capes").getBoolean(true);
		} catch (final Exception e){
			VPLog.severe("Problem Loading config, its in you're config folder called Vanillaplus");
		} finally {
			if(ConfigManager.configuration.hasChanged()){
				ConfigManager.configuration.save();
			}
			ConfigManager.loaded = true;
		}
	}
}
