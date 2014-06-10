package com.cricket.vanillaplus.special.holidays;

import net.minecraft.entity.player.EntityPlayer;

import com.cricket.vanillaplus.special.YearlyDate;

public abstract class Holiday {
	public abstract YearlyDate getDate();
	public abstract void onEvent(EntityPlayer player);
	
	public String filterSound(String sound){
		return sound;
	}
}
