package com.cricket.vanillaplus.gui;

import org.lwjgl.opengl.GL11;

import com.cricket.vanillaplus.containers.ContainerRockCrusher;
import com.cricket.vanillaplus.tiles.TileEntityRockCrusher;

import cpw.mods.fml.relauncher.SideOnly;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class GuiRockCrusher extends GuiContainer{
	
	private static final ResourceLocation texture = new ResourceLocation("vanillaplus:/textures/gui/container/GuiRockCrusher.png");
	private TileEntityRockCrusher tileRockCrusher;
	
	public GuiRockCrusher(InventoryPlayer inv, TileEntityRockCrusher crusher) {
		super(new ContainerRockCrusher(inv, crusher));
		this.tileRockCrusher = crusher;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2){
		String string = this.tileRockCrusher.hasCustomInventoryName() ? this.tileRockCrusher.getInventoryName() : I18n.format(this.tileRockCrusher.getInventoryName(), new Object[0]);
		this.fontRendererObj.drawString(string, this.xSize / 2 - this.fontRendererObj.getStringWidth(string), 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 94, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		GL11.glColor4f(1.0F, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(texture);
		int c = (this.width - this.xSize) / 2;
		int d = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(c, d, 0, 0, this.xSize, this.ySize);
		int e;
		
		if(this.tileRockCrusher.isBurning()){
			e = this.tileRockCrusher.getBurnTimeRemainingScaled(12);
			this.drawTexturedModalRect(c + 56, d + 36 + 12 - e, 176, 12 - e, 14, e + 2);
		}
		
		e = this.tileRockCrusher.getCookProgressScaled(24);
		this.drawTexturedModalRect(c + 79, d = 34, 176, 14, e + 1, 16);
	}
	
}