package com.cricket.vanillaplus;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.Configuration;

import com.cricket.vanillaplus.blocks.BlockRockCrusher;
import com.cricket.vanillaplus.creativetab.CreativeTab;
import com.cricket.vanillaplus.gui.GuiHandler;
import com.cricket.vanillaplus.items.ItemPebble;
import com.cricket.vanillaplus.tiles.TileEntityRockCrusher;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


@Mod(modid=Reference.MODID, name=Reference.NAME, version=Reference.VERSION)
@NetworkMod(clientSideRequired=true)
public class VanillaPlus {
	
	@Instance(Reference.MODID)
	public static VanillaPlus instance;
	
	//GUI
	public static final int guiIDRockCrusher=0;
	
	//Blocks
	
	public static Block BlockRockCrusherIdle;
	public static Block BlockRockCrusherActive;
	
	//Items
	
	public static Item ItemPebble;

	
	//Block Id's
	int BlockRockCrusherid;
	
	//ItemId
	int ItemPebbleid;
	
	@EventHandler
	private void preInit(FMLPreInitializationEvent event){
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		//Items
		ItemPebbleid = config.get("Item IDs", "ItemPebble ID", 600).getInt();
		ItemPebble = new ItemPebble(ItemPebbleid).setCreativeTab(CreativeTab.VANILLAPLUS_TAB);
		
		//Blocks
		
		BlockRockCrusherIdle = new BlockRockCrusher(1002,false).setUnlocalizedName("rockCrusherIdle").setHardness(3.5F).setCreativeTab(CreativeTab.VANILLAPLUS_TAB);
		BlockRockCrusherActive = new BlockRockCrusher(1003,true).setUnlocalizedName("rockCrusherActive").setHardness(3.5F).setLightValue(0.9F);
		config.save();
		
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event){
		gameRegisters();
		languageRegisters();
		registerRenderers();
		networkRegisters();
	}
	
	private static void gameRegisters(){
		
		//Blocks
		GameRegistry.registerBlock(BlockRockCrusherIdle, ItemBlock.class, "RockCrusherIdle");
		GameRegistry.registerBlock(BlockRockCrusherActive,ItemBlock.class,"RockCrusherActive");
		
		//Items
		GameRegistry.registerItem(ItemPebble, "Pebble");
		
		
		//Tile Entities
		GameRegistry.registerTileEntity(TileEntityRockCrusher.class, "RockCrusher");
	}
	
	private static void languageRegisters(){
		LanguageRegistry.addName(BlockRockCrusherIdle, "Rock Crusher");
		
		//Items
		LanguageRegistry.addName(ItemPebble, "Pebble");
	}
	
	private static void registerRenderers(){
		
	}
	
	private static void networkRegisters(){
		GuiHandler guiHandler = new GuiHandler();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}

}
