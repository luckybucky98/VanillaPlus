package com.cricket.vanillaplus.client.rendering.mobs;

import com.cricket.vanillaplus.mobs.EntityPigCarcass;
import com.cricket.vanillaplus.reference.ResourceLocationReference;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderPigCarcass extends RenderLiving{
	public RenderPigCarcass(ModelBase model, float f){
		super(model, f);
	}
	
	public void doRenderLiving(EntityLiving entity, double x, double y, double z, float f, float f1){
		super.doRender(entity, x, y, z, f, f1);
	}
	
	public void doRender(Entity entity, double x, double y, double z, float f, float f1){
		doRenderLiving((EntityPigCarcass)entity, x, y, z, f, f1);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return ResourceLocationReference.PIG_CARCASS_TEXTURE;
	}
}
