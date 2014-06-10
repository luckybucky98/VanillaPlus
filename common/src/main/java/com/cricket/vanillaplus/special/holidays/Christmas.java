package com.cricket.vanillaplus.special.holidays;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IChatComponent;

import com.cricket.vanillaplus.special.EnumColor;
import com.cricket.vanillaplus.special.HolidayManager;
import com.cricket.vanillaplus.special.YearlyDate;

public class Christmas extends Holiday{

	@Override
	public YearlyDate getDate() {
		return new YearlyDate(12, 25);
	}

	@Override
	public void onEvent(EntityPlayer player) {
		String themedLines = HolidayManager.getThemedLines(new EnumColor[] {EnumColor.DARK_GREEN, EnumColor.DARK_RED}, 13);
		player.addChatMessage(null);
	}
	
}
