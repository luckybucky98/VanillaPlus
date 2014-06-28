package com.cricket.vanillaplus.worldgen.ore;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;

import com.cricket.vanillaplus.worldgen.base.CaveBase;

public class OreGenData {
	protected CaveBase caveBase;
	public Block block;
	public int meta;
	public int veinsPerChunk;
	public int orePerVein;
	public int oreSpawnHeight;
	protected WorldGenMinable generator;
	
	public OreGenData(CaveBase caveBase, Block block, int meta, int veinsPerChunk, int orePerVein, int oreSpawnHeight){
		this.caveBase = caveBase;
		this.block = block;
		this.meta = meta;
		this.veinsPerChunk = veinsPerChunk;
		this.orePerVein = orePerVein;
		this.oreSpawnHeight = oreSpawnHeight;
	}
	
	public void generate(World world, Random rand, int x, int y, int z){
		if(this.generator == null){
			this.generator = new WorldGenMinable(this.block, this.meta, this.orePerVein, this.caveBase.block);
		}
		this.generator.generate(world, rand, x, y, z);
	}
}
