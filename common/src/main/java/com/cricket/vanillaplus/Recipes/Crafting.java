package com.cricket.vanillaplus.Recipes;

import java.util.HashMap;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.ShapedRecipes;

import com.cricket.vanillaplus.Registry;

import cpw.mods.fml.common.registry.GameRegistry;

public class Crafting {
	
	public static void loadCraftingRecipes(){
		GameRegistry.addRecipe(ItemStacks.cobbleStack, "xx","xx",'x',ItemStacks.pebbleStack);
		GameRegistry.addRecipe(ItemStacks.rockCrusherStack, "xyx","xzx","xxx",'x',ItemStacks.cobbleStack,'y',ItemStacks.stonePickStack,'z',ItemStacks.redstoneStack);
		GameRegistry.addShapelessRecipe(ItemStacks.lavaInfusedPlanksStack, ItemStacks.lavaInfusedLogStack);
		GameRegistry.addShapelessRecipe(ItemStacks.waterInfusedPlanksStack, ItemStacks.waterInfusedLogStack);
		GameRegistry.addRecipe(ItemStacks.lavaTableStack, "xx", "xx", 'x', ItemStacks.lavaInfusedPlanksStack);
	}
}
