package com.cricket.vanillaplus.client.rendering;

import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class CrystalClusterModel extends ModelBase{
	
	private IModelCustom model;
	
	public CrystalClusterModel(){
		model = AdvancedModelLoader.loadModel(new ResourceLocation("vanillaplus:models/ModelCrystalCluster.obj"));
	}
	
	public void render(){
		model.renderAll();
	}
}
