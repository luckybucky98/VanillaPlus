package com.cricket.vanillaplus.worldgen;

import java.util.Random;

import com.cricket.vanillaplus.Registry;
import com.cricket.vanillaplus.VanillaPlus;
import com.cricket.vanillaplus.worldgen.base.CaveBase;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderEnd;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraft.world.gen.ChunkProviderHell;
import cpw.mods.fml.common.IWorldGenerator;

public class VPWorldGen implements IWorldGenerator{
	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider){
		chunkX <<= 4;
		chunkZ <<= 4;
		
		if(chunkGenerator instanceof ChunkProviderGenerate){
			generateSurface(world, rand, chunkX, chunkZ, chunkGenerator);
		} else if(chunkGenerator instanceof ChunkProviderHell){
			generateNether(world, rand, chunkX, chunkZ);
		} else if(chunkGenerator instanceof ChunkProviderEnd){
			generateEnd(world, rand, chunkX, chunkZ);
		}
	}

	public static void generateEnd(World world, Random rand, int chunkX, int chunkZ) {
		
	}

	public static void generateNether(World world, Random rand, int chunkX, int chunkZ) {
		
	}

	public static void generateSurface(World world, Random rand, int chunkX, int chunkZ, IChunkProvider chunkGenerator) {
		for(int x0 = 0; x0 < 16; x0++){
			int x1 = chunkX + x0;
			
			for(int z0 = 0; z0 < 16; z0++){
				int z1 = chunkZ + z0;
				
				for(CaveBase base : Registry.caveBase){
					if(base.canGenerateAt(world, x1, z1)){
						replaceCaves(base, world, rand, x1, z1);
					}
				}
			}
		}
	}
	
	public static void replaceCaves(CaveBase base, World world, Random rand, int x, int z){
		int y = base.spawnHeight;
		int ceiling = -1;
		boolean wasAir = false;
		
		while(y > 5){
			if(world.isAirBlock(x, y, z)){
				if(!wasAir && ceiling == -1){
					ceiling = y + 1;
				}
				wasAir = true;
			} else {
				if(ceiling != -1){
					base.generate(world, rand, x, y, ceiling, z);
					ceiling = -1;
					y -= 4;
				}
				wasAir = false;
			}
			y--;
		}
	}
}
