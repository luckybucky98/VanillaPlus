package com.cricket.vanillaplus.mobs;

import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIRunAroundLikeCrazy;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class EntityUnicorn extends EntityHorse{

	public EntityUnicorn(World world) {
		super(world);
		this.setSize(1.4F, 1.6F);
		this.isImmuneToFire = false;
		this.setChested(false);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIPanic(this, 1.2D));
		this.tasks.addTask(1, new EntityAIRunAroundLikeCrazy(this, 1.2D));
		this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(4, new EntityAIFollowParent(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWander(this, 0.7D));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		
	}
	protected void entityInit(){
		super.entityInit();
		this.dataWatcher.addObject(16, Integer.valueOf(0));
		this.dataWatcher.addObject(19, Byte.valueOf((byte)0));
		this.dataWatcher.addObject(20, Integer.valueOf(0));
		this.dataWatcher.addObject(21, String.valueOf(""));
		this.dataWatcher.addObject(22, Integer.valueOf(0));
	}
	public void setHorseType(int par1){
		this.dataWatcher.updateObject(19, Byte.valueOf((byte)par1));
	}
	public int getHorseType(){
		return this.dataWatcher.getWatchableObjectInt(20);
	}
	public void setHorseVarient(int par1){
		this.dataWatcher.updateObject(20,Integer.valueOf(par1));
	}
	public int getHorseVarient(){
		return this.dataWatcher.getWatchableObjectInt(20);
	}
	public String getEntityName(){
		if(this.hasCustomNameTag()){
			return this.getCustomNameTag();
		} else {
			int var1 = this.getHorseType();
			
			switch (var1){
			case 0:
				default:
					return StatCollector.translateToLocal("entity.unicorn.name");
				case 1:
					return StatCollector.translateToLocal("entity.rainacorn.name");
				case 2:
					return StatCollector.translateToLocal("entity.zombiecorn.name");
				case 3:
					return StatCollector.translateToLocal("entity.skelecorn.name");
			}
		}
	}
	public boolean getHorseWatchableBoolean(int par1){
		return (this.dataWatcher.getWatchableObjectInt(16) & par1) != 0;
	}
	
	private void setHorseWatchableBoolean(int par1, boolean par2){
		int var3 = this.dataWatcher.getWatchableObjectInt(16);
		if(par2){
			this.dataWatcher.updateObject(16,Integer.valueOf(var3 | par1));
		} else {
			this.dataWatcher.updateObject(16,Integer.valueOf(var3 & ~par1));
		}
	}
	public boolean isAdultHorse(){
		return !this.isChild();
	}
	public boolean isTame(){
		return this.getHorseWatchableBoolean(2);
	}
	public boolean func_110253_bW(){
		return this.isAdultHorse();
	}
	public String getOwnerName(){
		return this.dataWatcher.getWatchableObjectString(21);
	}
	public void setOwnerName(String string){
		this.dataWatcher.updateObject(21, string);
	}
	public float getHorseSize(){
		int var1 = this.getGrowingAge();
		return var1 >= 0 ? 1.0F : 0.5F + (float)(-24000 - var1) / -24000F * 0.5F;
	}
	public void setScaleForAge(boolean par1){
		if(par1){
			this.setScale(this.getHorseSize());
		} else {
			this.setScale(1.0F);
		}
	}
	public boolean isHorseJumping(){
		return this.horseJumping;
	}
	public void setHorseTamed(boolean par1){
		this.setHorseWatchableBoolean(2, par1);
	}
	public void setHorseJumping(boolean par1){
		this.horseJumping = par1;
	}
	public boolean allowLeashing(){
		return !this.func_110256_cu()&&this.isEatingHaystack();
	}
	protected void func_142017_0(float par1){
		if(par1 > 6.0F && this.isEatingHaystack()){
			this.setEatingHaystack(false);
		}
	}
	public boolean isChested(){
		return this.getHorseWatchableBoolean(8);
	}
	public int func_110241_cb(){
		return this.dataWatcher.getWatchableObjectInt(22);
	}
	public int getHorseArmorIndex(ItemStack stack){
		return stack == null ? 0 : (stack.itemID == Item.horseArmorIron.itemID ? 1 : (stack.itemID == Item.horseArmorGold.itemID ? 2 : (stack.itemID == Item.horseArmorDiamond.itemID ? 3 : 0)));
	}
	public boolean isEatingHayStack(){
		return this.getHorseWatchableBoolean(32);
	}
	public boolean isRearing(){
		return this.getHorseWatchableBoolean(64);
	}
	public boolean func_110205_ce(){
		return this.getHorseWatchableBoolean(16);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}