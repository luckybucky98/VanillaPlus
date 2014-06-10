package com.cricket.vanillaplus.special;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.minecraft.client.Minecraft;

import com.cricket.vanillaplus.ConfigManager;
import com.cricket.vanillaplus.special.holidays.Christmas;
import com.cricket.vanillaplus.special.holidays.Holiday;
import com.cricket.vanillaplus.special.holidays.NewYear;

public final class HolidayManager {
	private static Calendar calendar;
	private Christmas christmas;
	private static Minecraft mc = Minecraft.getMinecraft();
	public static List<Holiday> holidays = new ArrayList();
	private static List<Holiday> holidaysNotified = new ArrayList();
	
	public static void init(){
		if(ConfigManager.holidays){
			holidays.add(new Christmas());
			holidays.add(new NewYear());
		}
		System.out.println("[VanillaPlus] Holiday's Loaded");
	}
	
	public static void check(){
		YearlyDate date;
		try{
			date = getDate();
			for(Holiday holiday : holidays){
				if(!holidaysNotified.contains(holiday)){
					if(holiday.getDate().equals(date)){
						holiday.onEvent(mc.thePlayer);
						holidaysNotified.add(holiday);
					}
				}
			}
		} catch (Exception e){
			
		}
	}
	
	public static String filterSound(String sound){
		if(!ConfigManager.holidays){
			return sound;
		}
		
		YearlyDate date;
		
		try{
			date = getDate();
			for(Holiday holiday : holidays){
				if(holiday.getDate().equals(date)){
					return holiday.filterSound(sound);
				}
			}
		} catch (Exception e){
			
		}
		return sound;
	}
	
	private static YearlyDate getDate(){
		return new YearlyDate(calendar.get(2) + 1, calendar.get(5));
	}
	
	public static String getThemedLines(EnumColor[] colors, int ammount){
		StringBuilder builder = new StringBuilder();
		for(int c = 0; c < ammount; ++c){
			builder.append(colors[(c % colors.length)] + "-");
		}
		return builder.toString();
	}
	
}
