package com.cricket.vanillaplus.handlers;

import java.util.Random;

import net.minecraft.entity.EntityList;

import com.cricket.vanillaplus.VanillaPlus;

import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityHandler {
	public static void createNewEntity(Class entityClass, String entityName){
		int id = EntityRegistry.findGlobalUniqueEntityId();
		long n = entityName.hashCode();
		Random rand = new Random();
		int mainColor = rand.nextInt() * 16777215;
		int secondaryColor = rand.nextInt() * 16777215;
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, id);
		EntityRegistry.registerModEntity(entityClass, entityName, id, VanillaPlus.instance, 64, 1, true);
		EntityList.entityEggs.put(Integer.valueOf(id), new EntityList.EntityEggInfo(id, mainColor, secondaryColor));
	}
}
