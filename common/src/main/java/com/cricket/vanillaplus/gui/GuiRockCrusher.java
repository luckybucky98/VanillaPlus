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
		String var3 = this.tileRockCrusher.isInventoryNameLocalized() ? this.tileRockCrusher.getInventoryName() : I18n.format(this.tileRockCrusher.getInventoryName(), new Object[0]);
        this.fontRendererObj.drawString(var3, this.xSize / 2 - this.fontRendererObj.getStringWidth(var3) / 2, 6, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(texture);
        int var4 = (this.width - this.xSize) / 2;
        int var5 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(var4, var5, 0, 0, this.xSize, this.ySize);
        int var6;

        if (this.tileRockCrusher.isBurning())
        {
            var6 = this.tileRockCrusher.getBurnTimeRemainingScaled(12);
            this.drawTexturedModalRect(var4 + 56, var5 + 36 + 12 - var6, 176, 12 - var6, 14, var6 + 2);
        }

        var6 = this.tileRockCrusher.getCookProgressScaled(24);
        this.drawTexturedModalRect(var4 + 79, var5 + 34, 176, 14, var6 + 1, 16);
	}
	
}