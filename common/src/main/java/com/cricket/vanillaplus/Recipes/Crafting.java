package com.cricket.vanillaplus.Recipes;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.cricket.vanillaplus.api.Registry;

import cpw.mods.fml.common.registry.GameRegistry;

public class Crafting {
	
	ItemStack cobbleStack = new ItemStack(Block.cobblestone);
	ItemStack pebbleStack = new ItemStack(Registry.ItemPebble);
	ItemStack rockCrusherStack = new ItemStack(Registry.BlockRockCrusherIdle);
	ItemStack redstoneStack = new ItemStack(Item.redstone);
	ItemStack stonePickStack = new ItemStack(Item.pickaxeStone);
	
	
	public void loadCraftingRecipes(){
		GameRegistry.addRecipe(pebbleStack, "xx","xx",'x',cobbleStack);
		GameRegistry.addRecipe(rockCrusherStack, "xyx","xzx","xxx",'x',cobbleStack,'y',stonePickStack,'z',redstoneStack);
    
	}
}
