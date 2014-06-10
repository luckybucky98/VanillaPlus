package com.cricket.vanillaplus.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

import com.cricket.vanillaplus.tiles.TileEntityAdvancedSmelter;

public class ContainerAdvancedSmelter extends Container{

	public ContainerAdvancedSmelter(InventoryPlayer inventory,
			TileEntityAdvancedSmelter entity) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
