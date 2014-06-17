package com.cricket.vanillaplus.worldgen;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenLavaForest extends BiomeGenBase{

	public BiomeGenLavaForest(int par1) {
		super(par1);
		this.topBlock = Blocks.grass;
		this.fillerBlock = Blocks.stone;
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.deadBushPerChunk = 4;
		this.theBiomeDecorator.generateLakes = true;
		this.waterColorMultiplier = 14745518;
	}
	
	public void decorate(World world, Random rand, int chunkx, int chunkz){
		super.decorate(world, rand, chunkx, chunkz);
	}

}