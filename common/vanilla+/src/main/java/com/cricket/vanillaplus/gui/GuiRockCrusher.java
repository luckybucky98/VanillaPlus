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
	private static final ResourceLocation rockCrusherGui = new ResourceLocation("vanillaplus/textures/gui/container/GuiRockCrusher.png");
	private TileEntityRockCrusher rockCrusher;
	
	public GuiRockCrusher(InventoryPlayer invPlayer, TileEntityRockCrusher tile){
		super(new ContainerRockCrusher(invPlayer, tile));
		this.rockCrusher = tile;
	}
	
	protected void drawGuiContainerForeGroundLayer(int par1, int par2){
		String var3 = this.rockCrusher.isInvNameLocalized() ? this.rockCrusher.getInvName() : I18n.getString(this.rockCrusher.getInvName());
		this.fontRenderer.drawString(var3, this.xSize/2 - this.fontRenderer.getStringWidth(var3)/2,6,4210752);
		this.fontRenderer.drawString(I18n.getString("container.inventory"),8,this.ySize-96+2,4210752);
	}
	
	protected void drawGuiContainerBackgroundLayer(int par1, int par2, int par3){
		GL11.glColor4f(1.0F,1.0F,1.0F,1.0F);
		this.mc.getTextureManager().bindTexture(rockCrusher);
		int var4 = (this.width - this.xSize)/2;
		int var5 = (this.height - this.ySize)/2;
		this.drawTextureModalRect(var4, var5,0,0,this.xSize,this.ySize);
		int var6;
		if(this.rockCrusher.isGrinding()){
			var6 = this.rockCrusher.getBurnTimeRemainingScaled(12);
			this.drawTextureModalRect(var4+56,var5+48-var6,176,12-var6,14,var6+2);
		}
		var6 = this.rockCrusher.getCookProgressScaled(24);
		this.drawTexturedModalRect(var4+79,var5+34,176,14,var6+1,16);
	}
}
