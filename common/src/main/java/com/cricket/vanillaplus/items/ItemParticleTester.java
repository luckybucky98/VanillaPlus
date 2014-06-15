package com.cricket.vanillaplus.items;

import java.util.Random;

import com.cricket.vanillaplus.entities.EntityBloodFX;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemParticleTester extends Item{
	
	private Random rand = new Random();
	
	public ItemParticleTester(){
		super();
		this.maxStackSize=(64);
		setTextureName("vanillaplus:ItemParticleTester");
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
		if(!player.capabilities.isCreativeMode){
			--stack.stackSize;
		}
		world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		
		if(!world.isRemote){
			
		}
		return stack;
	}

}
