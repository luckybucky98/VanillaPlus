package com.cricket.vanillaplus.handlers;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import com.cricket.vanillaplus.mobs.EntityPigCarcass;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class LivingDeathEventHandler {
	
	@SubscribeEvent
	public void onEntityDeath(LivingDeathEvent event){
		EntityPigCarcass carcass = new EntityPigCarcass(event.entity.worldObj);
		
		if(event.entityLiving instanceof EntityPig){
			carcass.setLocationAndAngles(event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, event.entityLiving.rotationYaw, event.entityLiving.rotationPitch);
			event.entity.worldObj.spawnEntityInWorld(carcass);
		}
	}
}
