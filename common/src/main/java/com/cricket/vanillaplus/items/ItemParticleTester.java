package com.cricket.vanillaplus.items;

import java.util.Random;

import com.cricket.vanillaplus.entities.EntityBloodFX;
import com.cricket.vanillaplus.handlers.ParticleHandler;

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
		for(int countparticles = 0; countparticles <= 10; ++countparticles){
			ParticleHandler.spawnParticle("blood", player.posX, player.posY, player.posZ, 0.0D, 0.0D, 0.0D);
		}
		
		return stack;
	}

}
