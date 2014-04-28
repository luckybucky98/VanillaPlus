package com.cricket.vanillaplus;

public class Registry {
	
	public static final int guiIDRockCrusher=0;
	
	public static Block BlockRockCrusherIdle;
	public static Block BlockRockCrusherActive;
	
	public static Item ItemPebble;
	
	int BlockRockCrusherid;
	int ItemPebbleid;
	
	
	public static void game(){
		blocks();
		items();
		tiles();
	}
	public static void language(){
		languageBlocks();
		languageItems();
	}
	public static void network(){
		
	}
	public static void blocks(){
		GameRegistry.registerBlock(BlockRockCrusherIdle, ItemBlock.class,"RockCrusherIdle");
		GameRegistry.registerBlock(BlockRockCrusherActive, ItemBlock.class,"RockCrusherActive");
	}
	public static void items(){
		GameRegistry.registerItem(ItemPebble,"Pebble");
	}
	public static void tiles(){
		GameRegistry.registerTileEntity(TileEntityRockCrusher.class, "RockCrusher");
	}
	public static void languageBlocks(){
		LanguageRegistry.addName(BlockRockCrusherIdle, "Rock Crusher");
	}
	public static void languageItems(){
		LanguageRegistry.addName(ItemPebble, "Pebble");
	}
	public static void GUI(){
		GuiHandler guiHandler = new GuiHandler();
	}
}