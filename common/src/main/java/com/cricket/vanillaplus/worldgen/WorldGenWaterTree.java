package com.cricket.vanillaplus.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenWaterTree extends WorldGenerator{
	
	private final int baseHeight;
	
	public WorldGenWaterTree(boolean doNotify, int height, Block wood, Block leave){
		super(doNotify);
		this.baseHeight = height;
	}
	
	
	@Override
	public boolean generate(World world, Random rand, int x, int y, int z) {
		
		return false;
	}
	
}
