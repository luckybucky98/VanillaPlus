package com.cricket.vanillaplus.client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.cricket.vanillaplus.CommonProxy;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	public static Map<String, String> capeMap = new HashMap<String, String>();
	
	public void preInit(FMLPreInitializationEvent event){
		
	}
	public void init(FMLInitializationEvent event){
		
	}
	public void postInit(FMLPostInitializationEvent event){
		
	}
	public void setupCapes(){
		try{
			ClientProxy.updateCapeList();
		} catch (Exception e){
			FMLLog.severe("Error while setting up VanillaPlus Capes oh noes!");
			e.printStackTrace();
		}
		if(Loader.isModLoaded("CoFHCore")){
			for (Entry<String, String> e : ClientProxy.capeMap.entrySet())
			{
				try
				{
					Object capeRegistry = Class.forName("cofh.api.core.RegistryAccess").getField("capeRegistry").get(null);
					Class.forName("cofh.api.core.ISimpleRegistry").getMethod("register", String.class, String.class).invoke(capeRegistry, e.getKey(), e.getValue());
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
					break;
				}
			}
		}
	}
	
	public static void updateCapeList() throws Exception{
		int timeout = 10000;
		URL capeListUrl = new URL("https://raw.github.com/TheCricket/VanillaPlus/master/Capes.txt");
		URLConnection connection = capeListUrl.openConnection();
		connection.setConnectTimeout(timeout);
		connection.setReadTimeout(timeout);
		InputStream stream = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

		String line;
		while ((line = reader.readLine()) != null)
		{
			if (line.contains(":"))
			{
				int splitLocation = line.indexOf(":");
				String username = line.substring(0, splitLocation);
				String capeUrl = "https://raw.github.com/TheCricket/VanillaPlus/master/capes" + line.substring(splitLocation + 1) + ".png";
				ClientProxy.capeMap.put(username, capeUrl);
			}
		}
	}
}
