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

	//private final ModelRockCrusher modelRockCrusher = new ModelRockCrusher;
	private static final ResourceLocation textureRockCrusher = new ResourceLocation("vanillaplus:BlockRockCrusher");
	
	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double d0, double d1, double d2, float f){
		GL11.glPushMatrix();
		GL11.glTranslatef((float) d0, (float) d1, (float) d2);
		TileEntityRockCrusher tile = (TileEntityRockCrusher) tileEntity;
		
	}
	
	public void renderRockCrusher(TileEntityRockCrusher rockCrusher, World world, int x, int y, int z, Block block){
		Tessellator tessellator = Tessellator.instance;
		float f = block.getMixedBrightnessForBlock(world, x, y, z);
		int l = world.getLightBrightnessForSkyBlocks(x, y, z, 0);
		int l1 = 1 % 65536;
		int l2 = 1 / 65536;
		tessellator.setColorOpaque_F(f, f, f);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) l1, (float) l2);
		GL11.glPushMatrix();
		GL11.glTranslatef(0.5F, 1.4F, 0.5F);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(textureRockCrusher);
		//this.modelRockCrusher.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	}
}
