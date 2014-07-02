package com.cricket.vanillaplus.mobs;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import com.cricket.vanillaplus.mobs.ai.AICarcass;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EntityPigCarcass extends EntityAnimal{

	public EntityPigCarcass(World world) {
		super(world);
		this.tasks.addTask(0, new AICarcass(this, 0.0D));
		this.setSize(1.0F, 1.0F);
	}
	
	@Override
	public boolean isAIEnabled(){
		return true;
	}
	
	@Override
	protected void applyEntityAttributes(){
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(8.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.0D);
	}
	
	@Override
	protected String getLivingSound(){
		return null;
	}
	
	@Override
	protected String getHurtSound(){
		return null;
	}
	
	@Override
	protected String getDeathSound(){
		return null;
	}
	
	@Override
	protected float getSoundVolume(){
		return 0.0F;
	}

	public EntityPigCarcass createChild(EntityAgeable entity) {
		return new EntityPigCarcass(this.worldObj);
	}
	
	@Override
	protected Item getDropItem(){
		return Items.rotten_flesh;
	}
	
	@Override
	protected void dropFewItems(boolean recentlyHit, int lootLevel){
		int c = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + lootLevel);
		
		for(int d = 0; d < c; d++){
			this.dropItem(Items.rotten_flesh, 1);
			
			if(this.rand.nextBoolean()){
				this.dropItem(Items.bone, 1);
			}
		}
	}
	
	public void onStruckByLightning(EntityLightningBolt bolt){
		if(!this.worldObj.isRemote){
			EntityPig pig = new EntityPig(this.worldObj);
			pig.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
			this.worldObj.spawnEntityInWorld(pig);
			this.setDead();
		}
	}
	
	@Override
	protected void fall(float distance){
		super.fall(distance);
		this.setDead();
	}

}
