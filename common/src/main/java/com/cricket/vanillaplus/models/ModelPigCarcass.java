package com.cricket.vanillaplus.models;

public class ModelPigCarcass extends ModelCarcassBase{
	
	public ModelPigCarcass(){
		this(0.0F);
	}

	public ModelPigCarcass(Float f){
		super(6, f);
		this.head.setTextureOffset(16, 16).addBox(-2.0F, 0.0F, -9.0F, 4, 3, 1, f);
	}
}
