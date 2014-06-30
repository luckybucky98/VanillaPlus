package com.cricket.vanillaplus.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPigCarcass extends ModelBase
{
  //fields
    ModelRenderer ribTop1;
    ModelRenderer ribBottom1;
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer ribBottom2;
    ModelRenderer ribTop2;
    ModelRenderer ribBottom3;
    ModelRenderer ribTop3;
    ModelRenderer ribTop4;
    ModelRenderer ribBottom4;
    ModelRenderer ribTop5;
    ModelRenderer ribBottom5;
    ModelRenderer ribTop6;
    ModelRenderer ribBottom6;
  
  public ModelPigCarcass(){
    textureWidth = 64;
    textureHeight = 32;
    
      ribTop1 = new ModelRenderer(this, 0, 0);
      ribTop1.addBox(0F, 0F, 0F, 3, 2, 2);
      ribTop1.setRotationPoint(-4F, 17F, 0F);
      ribTop1.setTextureSize(64, 32);
      ribTop1.mirror = true;
      setRotation(ribTop1, 0F, 0F, 0F);
      ribBottom1 = new ModelRenderer(this, 0, 0);
      ribBottom1.addBox(0F, 0F, 0F, 2, 4, 2);
      ribBottom1.setRotationPoint(-4F, 19F, 0F);
      ribBottom1.setTextureSize(64, 32);
      ribBottom1.mirror = true;
      setRotation(ribBottom1, 0F, 0F, 0F);
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-4F, -4F, -8F, 8, 8, 8);
      head.setRotationPoint(0F, 18F, -6F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 28, 8);
      body.addBox(-5F, -10F, -7F, 10, 16, 8);
      body.setRotationPoint(0F, 17F, 3F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 1.570796F, 0F, 0F);
      leg1 = new ModelRenderer(this, 0, 16);
      leg1.addBox(-2F, 0F, -2F, 4, 6, 4);
      leg1.setRotationPoint(-3F, 10F, 7F);
      leg1.setTextureSize(64, 32);
      leg1.mirror = true;
      setRotation(leg1, 0F, 0F, 0F);
      leg2 = new ModelRenderer(this, 0, 16);
      leg2.addBox(-2F, 0F, -2F, 4, 6, 4);
      leg2.setRotationPoint(3F, 10F, 7F);
      leg2.setTextureSize(64, 32);
      leg2.mirror = true;
      setRotation(leg2, 0F, 0F, 0F);
      leg3 = new ModelRenderer(this, 0, 16);
      leg3.addBox(-2F, 18F, -2F, 4, 6, 4);
      leg3.setRotationPoint(-3F, -8F, -5F);
      leg3.setTextureSize(64, 32);
      leg3.mirror = true;
      setRotation(leg3, 0F, 0F, 0F);
      leg4 = new ModelRenderer(this, 0, 16);
      leg4.addBox(-2F, 0F, -2F, 4, 6, 4);
      leg4.setRotationPoint(3F, 10F, -5F);
      leg4.setTextureSize(64, 32);
      leg4.mirror = true;
      setRotation(leg4, 0F, 0F, 0F);
      ribBottom2 = new ModelRenderer(this, 0, 0);
      ribBottom2.addBox(0F, 0F, 0F, 2, 4, 2);
      ribBottom2.setRotationPoint(-4F, 19F, 3F);
      ribBottom2.setTextureSize(64, 32);
      ribBottom2.mirror = true;
      setRotation(ribBottom2, 0F, 0F, 0F);
      ribTop2 = new ModelRenderer(this, 0, 0);
      ribTop2.addBox(0F, 0F, 0F, 3, 2, 2);
      ribTop2.setRotationPoint(-4F, 17F, 3F);
      ribTop2.setTextureSize(64, 32);
      ribTop2.mirror = true;
      setRotation(ribTop2, 0F, 0F, 0F);
      ribBottom3 = new ModelRenderer(this, 0, 0);
      ribBottom3.addBox(0F, 0F, 0F, 2, 4, 2);
      ribBottom3.setRotationPoint(-4F, 19F, -3F);
      ribBottom3.setTextureSize(64, 32);
      ribBottom3.mirror = true;
      setRotation(ribBottom3, 0F, 0F, 0F);
      ribTop3 = new ModelRenderer(this, 0, 0);
      ribTop3.addBox(0F, 0F, 0F, 3, 2, 2);
      ribTop3.setRotationPoint(-4F, 17F, -3F);
      ribTop3.setTextureSize(64, 32);
      ribTop3.mirror = true;
      setRotation(ribTop3, 0F, 0F, 0F);
      ribTop4 = new ModelRenderer(this, 0, 0);
      ribTop4.addBox(0F, 0F, 0F, 3, 2, 2);
      ribTop4.setRotationPoint(4F, 17F, 2F);
      ribTop4.setTextureSize(64, 32);
      ribTop4.mirror = true;
      setRotation(ribTop4, 0F, 3.141593F, 0F);
      ribBottom4 = new ModelRenderer(this, 0, 0);
      ribBottom4.addBox(0F, 0F, 0F, 2, 4, 2);
      ribBottom4.setRotationPoint(4F, 19F, 2F);
      ribBottom4.setTextureSize(64, 32);
      ribBottom4.mirror = true;
      setRotation(ribBottom4, 0F, 3.141593F, 0F);
      ribTop5 = new ModelRenderer(this, 0, 0);
      ribTop5.addBox(0F, 0F, 0F, 3, 2, 2);
      ribTop5.setRotationPoint(4F, 17F, -1F);
      ribTop5.setTextureSize(64, 32);
      ribTop5.mirror = true;
      setRotation(ribTop5, 0F, 3.141593F, 0F);
      ribBottom5 = new ModelRenderer(this, 0, 0);
      ribBottom5.addBox(0F, 0F, 0F, 2, 4, 2);
      ribBottom5.setRotationPoint(4F, 19F, -1F);
      ribBottom5.setTextureSize(64, 32);
      ribBottom5.mirror = true;
      setRotation(ribBottom5, 0F, 3.141593F, 0F);
      ribTop6 = new ModelRenderer(this, 0, 0);
      ribTop6.addBox(0F, 0F, 0F, 3, 2, 2);
      ribTop6.setRotationPoint(4F, 17F, 5F);
      ribTop6.setTextureSize(64, 32);
      ribTop6.mirror = true;
      setRotation(ribTop6, 0F, 3.141593F, 0F);
      ribBottom6 = new ModelRenderer(this, 0, 0);
      ribBottom6.addBox(0F, 0F, 0F, 2, 4, 2);
      ribBottom6.setRotationPoint(4F, 19F, 5F);
      ribBottom6.setTextureSize(64, 32);
      ribBottom6.mirror = true;
      setRotation(ribBottom6, 0F, 3.141593F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5){
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    ribTop1.render(f5);
    ribBottom1.render(f5);
    head.render(f5);
    body.render(f5);
    leg1.render(f5);
    leg2.render(f5);
    leg3.render(f5);
    leg4.render(f5);
    ribBottom2.render(f5);
    ribTop2.render(f5);
    ribBottom3.render(f5);
    ribTop3.render(f5);
    ribTop4.render(f5);
    ribBottom4.render(f5);
    ribTop5.render(f5);
    ribBottom5.render(f5);
    ribTop6.render(f5);
    ribBottom6.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z){
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5){
    super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
  }

}
