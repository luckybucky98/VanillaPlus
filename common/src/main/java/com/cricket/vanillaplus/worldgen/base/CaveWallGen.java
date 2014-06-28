package com.cricket.vanillaplus.worldgen.base;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class CaveWallGen extends WorldGenerator{
	private static final int radius = 4;
	private Block block;
	private int blockMeta;
	private Block target;
	private int targetMeta;
	public Map<BlockM, BlockM> replacements = new HashMap();
	
	public CaveWallGen(Block block, Block target){
		this(block, 0, target, 0);
	}
	
	public CaveWallGen(Block block, int meta){
		this(block, meta, Blocks.stone, 0);
	}
	
	public CaveWallGen(Block block, int meta, Block target, int targetMeta){
		if(block == null){
			throw new IllegalArgumentException("Can't set the block to null silly");
		} else if(target == null){
			throw new IllegalArgumentException("Can't set the block to null silly");
		}
		
		this.block = block;
		this.blockMeta = meta;
		this.target = target;
		this.targetMeta = targetMeta;
	}
	
	public void addReplacement(Block targetBlock, Block replacementBlock){
		this.addReplacement(targetBlock, 0, replacementBlock, 0); 
	}
	
	public void addReplacement(Block targetBlock, Block replacementBlock, int replaceMeta){
		this.addReplacement(targetBlock,  0, replacementBlock, replaceMeta);
	}
	
	public void addReplacement(Block targetBlock, int targetMeta, Block replacementBlock, int replacementMeta){
		BlockM target = new BlockM(targetBlock, targetMeta);
		BlockM replacement = new BlockM(replacementBlock, replacementMeta);
		this.replacements.put(target, replacement);
	}
	
	public BlockM getReplacement(Block block, int meta){
		for(Map.Entry<BlockM, BlockM> entry : this.replacements.entrySet()){
			if(entry.getKey().equals(block, meta)){
				return entry.getValue();
			}
		}
		
		return null;
	}
	
	@Override
	public boolean generate(World world, Random rand, int x, int y, int z){
		int xmin = x - radius;
		int xmax = x + radius;
		int ymin = y - radius;
		int ymax = y + radius;
		int zmin = z - radius;
		int zmax = z + radius;
		
		if(ymin < 0){
			ymin = 0;
		}
		
		if(ymax > 255){
			ymax = 255;
		}
		
		for(int x1 = xmin; x1 <= xmax; x1++){
			for(int y1 = ymin; y1 <= ymax; y1++){
				for(int z1 = zmin; z1 <= zmax; z1++){
					int x2 = x1 - x;
					int y2 = y1 - y;
					int z2 = z1 - z;
					
					if(MathHelper.sqrt_float(x2 * x2 + y2 * y2 + z2 * z2) <= radius){
						this.replaceBlock(world, x1, y1, z1);
					}
				}
			}
		}
		
		return true;
	}
	
	private void replaceBlock(World world, int x, int y, int z){
		try{
			Block block = world.getBlock(x, y, z);
			
			if(block != Blocks.air){
				int meta = world.getBlockMetadata(x, y, z);
				
				if(block == this.target && meta == this.targetMeta){
					world.setBlock(x, y, z, this.block, this.blockMeta, 0);
				} else {
					BlockM replacement = this.getReplacement(block, meta);
					
					if(replacement != null){
						replacement.set(world, x, y, z, 0);
					}
				}
			}
		} catch (Exception e){
			
		}
	}
}
