package com.cricket.vanillaplus.special;

import net.minecraft.util.StatCollector;

public enum EnumColor {
	BLACK("§0", "black", new int[] { 0, 0, 0 }, 0),  DARK_BLUE("§1", "darkBlue", new int[] { 0, 0, 170 }, 4),  DARK_GREEN("§2", "darkGreen", new int[] { 0, 170, 0 }, 2),  DARK_AQUA("§3", "darkAqua", new int[] { 0, 170, 170 }, 6),  DARK_RED("§4", "darkRed", new int[] { 170, 0, 0 }, 1),  PURPLE("§5", "purple", new int[] { 170, 0, 170 }, 5),  ORANGE("§6", "orange", new int[] { 255, 170, 0 }, 14),  GREY("§7", "grey", new int[] { 170, 170, 170 }, 7),  DARK_GREY("§8", "darkGrey", new int[] { 85, 85, 85 }, 8),  INDIGO("§9", "indigo", new int[] { 85, 85, 255 }, 12),  BRIGHT_GREEN("§a", "brightGreen", new int[] { 85, 255, 85 }, 10),  AQUA("§b", "aqua", new int[] { 85, 255, 255 }, -1),  RED("§c", "red", new int[] { 255, 85, 85 }, 13),  PINK("§d", "pink", new int[] { 255, 85, 255 }, 9),  YELLOW("§e", "yellow", new int[] { 255, 255, 85 }, 11),  WHITE("§f", "white", new int[] { 255, 255, 255 }, 15);
	  
	  public static EnumColor[] DYES = { BLACK, DARK_RED, DARK_GREEN, null, DARK_BLUE, PURPLE, DARK_AQUA, GREY, DARK_GREY, PINK, BRIGHT_GREEN, YELLOW, INDIGO, RED, ORANGE, WHITE };
	  public final String code;
	  public final int[] rgbCode;
	  public final int mcMeta;
	  public String unlocalizedName;
	  
	  private EnumColor(String s, String n, int[] rgb, int meta){
	    this.code = s;
	    this.unlocalizedName = n;
	    this.rgbCode = rgb;
	    this.mcMeta = meta;
	  }
	  
	  public String getLocalizedName(){
	    return StatCollector.translateToLocal("color." + this.unlocalizedName);
	  }
	  
	  public String getName(){
	    return this.code + getLocalizedName();
	  }
	  
	  public float getColor(int index){
	    return this.rgbCode[index] / 255.0F;
	  }
	  
	  public int getMetaValue(){
	    return this.mcMeta;
	  }
	  
	  public String toString(){
	    return this.code;
	  }
}
