package com.cricket.vanillaplus.api.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.cricket.vanillaplus.VanillaPlus;
import com.cricket.vanillaplus.api.Registry;
import com.cricket.vanillaplus.containers.ContainerRockCrusher;
import com.cricket.vanillaplus.gui.GuiRockCrusher;
import com.cricket.vanillaplus.tiles.TileEntityRockCrusher;

import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getBlockTileEntity(x, y, z);
		if(entity !=null){
			switch(ID){
			case Registry.guiIDRockCrusher:
				if(entity instanceof TileEntityRockCrusher){
					return new ContainerRockCrusher(player.inventory,(TileEntityRockCrusher) entity);
				}
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getBlockTileEntity(x, y, z);
		if(entity !=null){
			switch(ID){
			case Registry.guiIDRockCrusher:
				if(entity instanceof TileEntityRockCrusher){
					return new GuiRockCrusher(player.inventory,(TileEntityRockCrusher) entity);
				}
			}
		}
		return null;
	}
	

}
