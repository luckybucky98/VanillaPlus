package com.cricket.vanillaplus.worldgen.base;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;

public class VPMapGenBase extends MapGenBase{
	protected int range;
	protected Random rand;
	protected World worldObj;
	
	public VPMapGenBase(){
		this.range = 8;
		this.rand = new Random();
	}
	
	@Override
	public void func_151539_a(IChunkProvider provider, World world, int x, int y, Block[] blocks){
		this.generate(provider, world, x, y, blocks, new byte[blocks.length]);
	}
	
	public void generate(IChunkProvider provider, World world, int x, int y, Block[] blocks, byte[] meta){
		int range2 = this.range;
		this.worldObj = world;
		this.rand.setSeed(world.getSeed());
		long l1 = this.rand.nextLong();
		long l2 = this.rand.nextLong();
		
		for(int c = x - range2; c <= x + range2; c++){
			for(int d = y - range2; d <= y + range2; d++){
				long l3 = c * l1;
				long l4 = d * l2;
				this.rand.setSeed(l3 ^ l4 ^ world.getSeed());
				this.generate(world, c, d, x, y, blocks, meta);
			}
		}
	}
	
	protected void generate(World world, int x, int z, int x1, int z1, Block[] blocks, byte[] meta){
		
	}
}
