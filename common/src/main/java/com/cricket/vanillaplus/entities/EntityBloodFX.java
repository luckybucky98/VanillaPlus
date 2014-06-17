package com.cricket.vanillaplus.entities;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import static org.lwjgl.opengl.GL11.*;

public class EntityBloodFX extends EntityFX{

	private static final ResourceLocation texture = new ResourceLocation("vanillaplus:textures/particle/blood.png");
	
	public EntityBloodFX(World world, double x, double y, double z, float f, float f1, float f2){
		this(world, x, y, z, 1.0F, f, f1, f2);
	}
	
	public EntityBloodFX(World world, double x, double y, double z, float f, float f1, float f2, float f3){
		super(world, x, y, z, 0.0D, 0.0D, 0.0D);
	}

	@Override
	public void renderParticle(Tessellator tess, float partialTicks, float par3, float par4, float par5, float par6, float par7){
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		glDepthMask(false);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glAlphaFunc(GL_GREATER, 0.003921569F);
		tess.startDrawingQuads();
		tess.setBrightness(getBrightnessForRender(partialTicks));
		float scale = 0.1F * particleScale;
		float x = (float)(prevPosX + (posX - prevPosX) * partialTicks - interpPosX);
		float y = (float)(prevPosY + (posY - prevPosY) * partialTicks - interpPosY);
		float z = (float)(prevPosZ + (posZ - prevPosZ) * partialTicks - interpPosZ);
		tess.addVertexWithUV(x - par3 * scale - par6 * scale, y - par4 * scale, z - par5 * scale - par7 * scale, 0, 0);
		tess.addVertexWithUV(x - par3 * scale - par6 * scale, y + par4 * scale, z - par5 * scale + par7 * scale, 1, 0);
		tess.addVertexWithUV(x + par3 * scale - par6 * scale, y + par4 * scale, z - par5 * scale + par7 * scale, 1, 1);
		tess.addVertexWithUV(x + par3 * scale - par6 * scale, y - par4 * scale, z - par5 * scale - par7 * scale, 0, 1);
		tess.draw();
		glDisable(GL_BLEND);
		glDepthMask(true);
		glAlphaFunc(GL_GREATER, 0.1F);
	}
	
	@Override
	public int getFXLayer(){
		return 3;
	}
	
	public EntityBloodFX setMaxAge(int maxAge){
		particleMaxAge = maxAge;
		return this;
	}
	
	public EntityBloodFX setGravity(int gravity){
		particleGravity = gravity;
		return this;
	}
	
	public EntityBloodFX setScale(int scale){
		particleScale = scale;
		return this;
	}

}
