package com.cricket.vanillaplus.weather;

import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;

public class WeatherManager {

	public int dimension;
	
	public WeatherManager(int dim) {
		this();
		dimension = dim;
	}
	
	public WeatherManager(){
		
	}
	
	public void tick(Side side, World world){
		boolean remote = world.isRemote;
		
		if(side == Side.SERVER){
			
		} else {
			
		}
	}

}
