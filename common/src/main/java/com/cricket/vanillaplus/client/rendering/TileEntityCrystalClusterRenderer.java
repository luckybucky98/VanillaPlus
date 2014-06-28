package com.cricket.vanillaplus.client.rendering;

import java.awt.Color;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.cricket.vanillaplus.blocks.BlockCrystalOre;
import com.cricket.vanillaplus.tiles.TileEntityCrystalOre;

public class TileEntityCrystalClusterRenderer extends TileEntitySpecialRenderer{

	private CrystalClusterModel model;
	
	public TileEntityCrystalClusterRenderer(){
		this.model = new CrystalClusterModel();
	}
	
	private void translateFromOrientation(float x, float y, float z, int orientation){
		switch(orientation){
		case 0:
			GL11.glTranslatef(x + 0.5F, y + 0.5F, z + 0.5F);
			GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
		case 1:
			GL11.glTranslatef(x + 0.5F, y - 0.3F, z + 0.5F);
		case 2:
			GL11.glTranslatef(x + 0.5F, y + 0.5F, z + 1.3F);
			GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
		case 3:
			GL11.glTranslatef(x + 0.5F, y + 0.5F, z - 0.3F);
		    GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
		case 4:
			GL11.glTranslatef(x + 1.3F, y + 0.5F, z + 0.5F);
		    GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
		case 5:
			GL11.glTranslatef(x - 0.3F, y + 0.5F, z + 0.5F);
		    GL11.glRotatef(-90.0F, 0.0F, 0.0F, 1.0F);
		}
	}
	
	private void drawCrystal(int orientation, float x, float y, float z, float f, float f2, Random rand, int color, float size){
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		float shade = MathHelper.sin((player.renderYawOffset + rand.nextInt(10)) / (5.0F + rand.nextFloat())) * 0.075F + 0.925F;
		Color c = new Color(color);
		float r = c.getRed() / 220.0F;
		float g = c.getGreen() / 220.0F;
		float b = c.getBlue() / 220.0F;
		
		GL11.glPushMatrix();
		GL11.glEnable(2977);
		GL11.glEnable(3042);
		GL11.glEnable(32826);
		GL11.glBlendFunc(770, 771);
		translateFromOrientation(x, y, z, orientation);
		GL11.glRotatef(f, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(f2, 1.0F, 0.0F, 0.0F);
		GL11.glScalef((0.15F + rand.nextFloat() * 0.075F) * size, (0.5F + rand.nextFloat() * 0.1F) * size, (0.15F + rand.nextFloat() * 0.05F) * size);
		
		int var = (int) (210.0F * shade);
		int var1 = var % 65536;
		int var2 = var / 65536;
		
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.defaultTexUnit, var1 / 1.0F, var2 / 1.0F);
		GL11.glColor4f(r, g, b, 1.0F);
		this.model.render();
		GL11.glScalef(1.0F, 1.0F, 1.0F);
		GL11.glDisable(32826);
		GL11.glDisable(3042);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glPopMatrix();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f) {
		GL11.glPushMatrix();
		TileEntityCrystalOre tileCrystal = (TileEntityCrystalOre) tile;
		int meta = tileCrystal.getBlockMetadata();
		int color = BlockCrystalOre.colors[5];
		if(meta != 6){
			color = BlockCrystalOre.colors[(meta + 1)];
		}
		this.bindTexture(new ResourceLocation("vanillaplus:textures/blocks/BlockCrystalOre.png"));
		Random rand = new Random(tileCrystal.getBlockMetadata() + tileCrystal.blockMetadata + tileCrystal.orientation * tileCrystal.yCoord);
		drawCrystal(tileCrystal.orientation, (float) x, (float) y, (float) z, (rand.nextFloat() - rand.nextFloat()) * 5.0F, (rand.nextFloat() - rand.nextFloat()) * 0.5F, rand, color, 1.1F);
		
		for(int m = 1; m < 6; m++){
			if(meta == 6){
				color = BlockCrystalOre.colors[m];
			}
			int angle1 = rand.nextInt(36) + 72 * m;
			int angle2 = 15 + rand.nextInt(15);
			drawCrystal(tileCrystal.orientation, (float)x, (float)y, (float)z, angle1, angle2, rand, color, 0.8F);
		}
		GL11.glPopMatrix();
		GL11.glDisable(3042);
	}

}
