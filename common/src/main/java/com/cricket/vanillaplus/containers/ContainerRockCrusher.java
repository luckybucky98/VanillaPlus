package com.cricket.vanillaplus.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

import com.cricket.vanillaplus.tiles.TileEntityRockCrusher;

public class ContainerRockCrusher extends Container{
	
	private TileEntityRockCrusher rockCrusher;

	public ContainerRockCrusher(InventoryPlayer inv, TileEntityRockCrusher crusher){
		this.rockCrusher = crusher;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return rockCrusher.isUseableByPlayer(player);
	}
	
}
