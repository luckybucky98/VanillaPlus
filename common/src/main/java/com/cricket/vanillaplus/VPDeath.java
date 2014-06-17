package com.cricket.vanillaplus;

import net.minecraft.util.DamageSource;

public class VPDeath {
	public static DamageSource grinder;
	
	public void load(){
		addDeath();
	}
	
	private static void addDeath(){
		DamageSource grinder = new DamageSource("vanillaplus.grinder");
	}
}
