package com.cricket.vanillaplus.Recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.cricket.vanillaplus.Registry;

public class ItemStacks {
	static ItemStack cobbleStack = new ItemStack(Blocks.cobblestone);
	static ItemStack pebbleStack = new ItemStack(Registry.ItemPebble);
	static ItemStack rockCrusherStack = new ItemStack(Registry.BlockRockCrusherIdle);
	static ItemStack redstoneStack = new ItemStack(Items.redstone);
	static ItemStack stonePickStack = new ItemStack(Items.stone_pickaxe);
	static ItemStack waterInfusedLogStack = new ItemStack(Registry.BlockWaterInfusedLog);
	static ItemStack waterInfusedPlanksStack = new ItemStack(Registry.BlockWaterInfusedPlanks);
	static ItemStack lavaInfusedLogStack = new ItemStack(Registry.BlockLavaInfusedLog);
	static ItemStack lavaInfusedPlanksStack = new ItemStack(Registry.BlockLavaInfusedPlanks);
}
