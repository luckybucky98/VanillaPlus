package com.cricket.vanillaplus.worldgen;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraftforge.event.terraingen.ChunkProviderEvent.ReplaceBiomeBlocks;

import com.cricket.vanillaplus.worldgen.base.CaveBase;
import com.cricket.vanillaplus.worldgen.decoration.VPGenCaves;
import com.cricket.vanillaplus.worldgen.decoration.VPGenRavines;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class VPCaves {
	
	public static List<CaveBase> caveBase = new ArrayList();
	
	public static void registerCave(CaveBase base){
		caveBase.add(base);
	}
	
	@SubscribeEvent
	public void replaceBiomeBlocks(ReplaceBiomeBlocks event){
		IChunkProvider provider = event.chunkProvider;
		
		if(provider instanceof ChunkProviderGenerate){
			setField(ChunkProviderGenerate.class, provider, 15, new VPGenCaves());
			setField(ChunkProviderGenerate.class, provider, 20, new VPGenRavines());
		}
	}
	
	private static void setField(Class leClass, Object inst, int fieldID, Object value){
		try{
			Field f = leClass.getDeclaredFields()[fieldID];
			f.setAccessible(true);
			f.set(inst, value);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
