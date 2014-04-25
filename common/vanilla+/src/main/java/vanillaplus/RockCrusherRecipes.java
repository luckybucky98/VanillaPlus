package com.cricket.vanillaplus;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RockCrusherRecipes {
	
	private static final RockCrusherRecipes grindingBase=new RockCrusherRecipes();
	
	private Map grindingList = new HashMap();
	private Map experienceList=new HashMap();
	
	public static final RockCrusherRecipes grinding(){
		return grindingBase;
	}
	
	private RockCrusherRecipes(){
		this.addGrinding(Block.cobblestone.blockID, new ItemStack(VanillaPlus.ItemPebble),0.7F);
	}

	public void addGrinding(int par1, ItemStack par2ItemStack, float par3){
		this.grindingList.put(Integer.valueOf(par1),par2ItemStack);
		this.experienceList.put(Integer.valueOf(par2ItemStack.itemID), Float.valueOf(par3));
	}
	
	public ItemStack getGrindingResult(int par1){
		return (ItemStack)this.grindingList.get(Integer.valueOf(par1));
	}
	
	public Map getGrindingList(){
		return this.grindingList;
	}
	public float getExperience(int par1){
		return this.experienceList.containsKey(Integer.valueOf(par1))?((Float)this.experienceList.get(Integer.valueOf(par1))).floatValue():0.0F;
	}
}
