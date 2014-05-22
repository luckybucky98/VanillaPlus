package com.cricket.vanillaplus.worldgen;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenLavaForest extends BiomeGenBase{

	public BiomeGenLavaForest(int par1) {
		super(par1);
		this.topBlock = (byte) Block.redstoneLampActive.blockID;
		this.fillerBlock = (byte) Block.glass.blockID;
	}

}