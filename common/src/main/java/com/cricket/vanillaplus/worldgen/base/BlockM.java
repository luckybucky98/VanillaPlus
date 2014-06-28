package com.cricket.vanillaplus.worldgen.base;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class BlockM {
	public Block block;
	public int meta;
	
	public BlockM(Block block, int meta){
		if(block == null){
			throw new IllegalArgumentException("Can't set the block to null!");
		}
		
		this.block = block;
		this.meta = meta;
	}
	
	public void set(World world, int x, int y, int z){
		this.set(world, x, y, z, 3);
	}
	
	public void set(World world, int x, int y, int z, int flags){
		world.setBlock(x, y, z, this.block, this.meta, flags);
	}
	
	@Override
	public int hashCode(){
		return Block.getIdFromBlock(this.block) | this.meta << 12;
	}
	
	@Override
	public boolean equals(Object obj){
		if(this == obj){
			return true;
		}
		
		if(obj == null){
			return false;
		}
		
		if(!(obj instanceof BlockM)){
			return false;
		}
		
		BlockM other = (BlockM)obj;
		
		return this.equals(other.block, other.meta);
	}
	
	public boolean equals(Block block, int meta){
		return this.block == block && this.meta == meta;
	}
}
