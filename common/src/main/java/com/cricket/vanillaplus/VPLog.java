package com.cricket.vanillaplus;

import java.util.logging.Level;

import cpw.mods.fml.relauncher.FMLRelaunchLog;

public class VPLog {
	public static void info(String message){
		FMLRelaunchLog.log("Vanilla Plus", Level.INFO, message);
	}
	public static void severe(String message){
		FMLRelaunchLog.log("Vanilla Plus", Level.SEVERE, message);
	}
}
