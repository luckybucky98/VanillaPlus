package com.cricket.vanillaplus.client.rendering;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import com.cricket.vanillaplus.tiles.TileEntityRockCrusher;

import cpw.mods.fml.client.FMLClientHandler;

public class RenderRockCrusher extends TileEntitySpecialRenderer{
	private ModelRockCrusher model = new ModelRockCrusher();
	private ResourceLocation texture = "vanillaplus:/textures/tile/TileRockCrusher.png";
	
	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float partialTick){
		renderModelAt((TileEntityRockCrusher)tile, x, y, z, partialTick);
	}
	
	private void renderModelAt(TileEntityRockCrusher tile, double x, double y, double z, float partialTick){
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		
		bindTexture(texture);
		
		switch(tile.facing){
			case 2: GL11.glRotatef(90, 0.0F, 1.0F, 0.0F); break;
			case 3: GL11.glRotatef(270, 0.0F, 1.0F, 0.0F); break;
			case 4: GL11.glRotatef(180, 0.0F, 1.0F, 0.0F); break;
			case 5: GL11.glRotatef(0, 0.0F, 1.0F, 0.0F); break;
		}
		
		GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
		model.render(0.0625F, tile.isActive);
		GL11.glPopMatrix
	}
}
