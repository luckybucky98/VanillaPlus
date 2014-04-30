package com.cricket.vanillaplus.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;

import com.cricket.vanillaplus.Reference;
import com.cricket.vanillaplus.containers.ContainerRockCrusher;
import com.cricket.vanillaplus.tiles.TileEntityRockCrusher;

public class GuiRockCrusher extends GuiContainer{
	public TileEntityRockCrusher rockCrusher;
	
	public static final ResourceLocation texture = new ResourceLocation(Reference.MODID,"textures/gui/container/GuiRockCrusher.png");
	
	
	public GuiRockCrusher(InventoryPlayer inventoryPlayer, TileEntityRockCrusher entity){
		super(new ContainerRockCrusher(inventoryPlayer, entity));
		this.rockCrusher=entity;
		this.xSize=176;
		this.ySize=166;
	}
	public void drawGuiContainerForegroundLayer(int par1, int par2){
		String name = this.rockCrusher.isInvNameLocalized()?this.rockCrusher.getInvName():I18n.getString(this.rockCrusher.getInvName());
		
		this.fontRenderer.drawString(name, this.xSize/2-this.fontRenderer.getStringWidth(name)/2,6,4210752);
		this.fontRenderer.drawString(I18n.getString("container.inventory"), 8, this.ySize-96 + 2,4210752);
	}
	public void drawGuiContainerBackgroundLayer(float f, int i, int j){
		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft,guiTop,0,0,xSize, ySize);
	}
}
