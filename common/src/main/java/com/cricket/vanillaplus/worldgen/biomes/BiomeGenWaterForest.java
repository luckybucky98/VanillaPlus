package com.cricket.vanillaplus.worldgen.biomes;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenWaterForest extends BiomeGenBase{

	public BiomeGenWaterForest(int id) {
		super(id);
		this.topBlock = Blocks.grass;
		this.fillerBlock = Blocks.stone;
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.deadBushPerChunk = 4;
		this.theBiomeDecorator.generateLakes = true;
		this.waterColorMultiplier = 14745518;
	}

}
