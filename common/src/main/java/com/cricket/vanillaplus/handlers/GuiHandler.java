package com.cricket.vanillaplus.handlers;

import net.minecraft.client.gui.inventory.GuiFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.world.World;
import net.minecraftforge.client.event.GuiOpenEvent;

import com.cricket.vanillaplus.containers.ContainerAdvancedSmelter;
import com.cricket.vanillaplus.containers.ContainerRockCrusher;
import com.cricket.vanillaplus.gui.GuiRockCrusher;
import com.cricket.vanillaplus.reference.GuiReference;
import com.cricket.vanillaplus.tiles.TileEntityAdvancedSmelter;
import com.cricket.vanillaplus.tiles.TileEntityRockCrusher;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		if(entity !=null){
			switch(ID){
			case GuiReference.guiIDRockCrusher:
				if(entity instanceof TileEntityRockCrusher){
					return new ContainerRockCrusher(player.inventory,(TileEntityRockCrusher) entity);
				}
			case GuiReference.guiIDAdvancedSmelter:
				if(entity instanceof TileEntityAdvancedSmelter){
					return new ContainerAdvancedSmelter(player.inventory,(TileEntityAdvancedSmelter)entity);
				}
				
			case GuiReference.guiIDLavaInfusedCraftingTable:
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		if(entity !=null){
			switch(ID){
			case GuiReference.guiIDRockCrusher:
				if(entity instanceof TileEntityRockCrusher){
					return new GuiRockCrusher(player.inventory,(TileEntityRockCrusher) entity);
				}
			}
		}
		return null;
	}
	
	@SubscribeEvent(priority = EventPriority.HIGHEST, receiveCanceled = true)
	public void onOpenFurnace(GuiOpenEvent event){
		
		if(event.gui instanceof GuiFurnace){
			event.setCanceled(true);
		}
	}
	

}
