package com.cricket.vanillaplus;

import net.minecraft.util.DamageSource;

public class VPDeath {
	public static DamageSource grinder;
	
	public void load(){
		addDeath();
	}
	
	private static void addDeath(){
		grinder = new DamageSource("vanillaplus.grinder");
	}
}
