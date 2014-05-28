package com.cricket.vanillaplus.Recipes;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.cricket.vanillaplus.api.Registry;

public class ItemStacks {
	static ItemStack cobbleStack = new ItemStack(Block.cobblestone);
	static ItemStack pebbleStack = new ItemStack(Registry.ItemPebble);
	static ItemStack rockCrusherStack = new ItemStack(Registry.BlockRockCrusherIdle);
	static ItemStack redstoneStack = new ItemStack(Item.redstone);
	static ItemStack stonePickStack = new ItemStack(Item.pickaxeStone);
	static ItemStack waterInfusedLogStack = new ItemStack(Registry.BlockWaterInfusedLog);
	static ItemStack waterInfusedPlanksStack = new ItemStack(Registry.BlockWaterInfusedPlanks);
	static ItemStack lavaInfusedLogStack = new ItemStack(Registry.BlockLavaInfusedLog);
	static ItemStack lavaInfusedPlanksStack = new ItemStack(Registry.BlockLavaInfusedPlanks);
	static ItemStack furnaceStack = new ItemStack(Registry.BlockFurnace);
}
