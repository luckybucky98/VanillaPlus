package com.cricket.vanillaplus.worldgen.biomes;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeLavaForest extends BiomeGenBase{

	public BiomeLavaForest(int par1) {
		super(par1);
		this.spawnableCreatureList.clear();
		this.topBlock = (byte)Block.grass.blockID;
		this.fillerBlock = (byte)Block.stone.blockID;
		this.theBiomeDecorator.treesPerChunk = 4;
		this.theBiomeDecorator.reedsPerChunk = 0;
		this.theBiomeDecorator.cactiPerChunk = 0;
	}

}
