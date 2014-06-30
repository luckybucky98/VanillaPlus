package com.cricket.vanillaplus.mobs.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;

public class AICarcass extends EntityAIBase{

	private EntityCreature entity;
	private double xPos;
	private double yPos;
	private double zPos;
	private double speed;
	
	public AICarcass(EntityCreature creature, double speed){
		this.entity = creature;
		this.speed = speed;
		this.setMutexBits(1);
	}
	
	@Override
	public boolean shouldExecute() {
		
		if(this.entity.getAge() >= 100){
			return false;
		} else if(this.entity.getRNG().nextInt(120) != 0){
			return false;
		} else {
			return false;
		}
	}
	
	public boolean continueExecuting(){
		return !this.entity.getNavigator().noPath();
	}
	
	public void startExecuting(){
		this.entity.getNavigator().tryMoveToXYZ(xPos, yPos, zPos, speed);
	}
}
