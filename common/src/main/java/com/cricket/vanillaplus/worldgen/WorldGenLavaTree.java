package com.cricket.vanillaplus.worldgen;

import java.util.Random;

import com.cricket.vanillaplus.Registry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenLavaTree extends WorldGenerator{
	public WorldGenLavaTree(boolean doNotify){
		super(doNotify);
	}
	
	public WorldGenLavaTree(){
		super();
	}
	
	@Override
	public boolean generate(World world, Random rand, int x, int trying, int z){
		for(int c = 0; c < trying; c++){
			int y = world.getActualHeight() -1;
			while(world.isAirBlock(x, y, z) && y > 0){
				y--;
			}
			
			if(!growTree(world, rand, x, y + 1, z)){
				trying--;
			}
			
			x += rand.nextInt(16) - 8;
			z += rand.nextInt(16) - 8;
		}
		
		return true;
	}
	
	public boolean growTree(World world, Random rand, int x, int y, int z){
		if(y>world.getHeight() - 8) return false;
		
		int trunkHeight = rand.nextInt(3) + 4;
		int branchStartY = y + trunkHeight - 2;
		
		for(int yy = y; yy < branchStartY; ++yy){
			if(!world.isAirBlock(x, yy, z)) return false;
		}
		
		for(int yy = branchStartY; yy < branchStartY + 2; ++y){
			for(int xx = x - 1; xx <= x + 1; ++xx){
				for(int zz = z - 1; zz <= z + 1; ++zz){
					if(!world.isAirBlock(xx, yy, zz)) return false;
				}
			}
		}
		
		for(int yy = branchStartY + 2, r = 3; yy < branchStartY + 5; ++yy){
			for(int xx = x - r; xx <= x + r; ++xx){
				for(int zz = z - r; zz <= z + r; ++zz){
					if(!world.isAirBlock(xx, yy, zz)) return false;
				}
			}
			--r;
		}
		
		byte branchSizes[] = new byte[4];
		boolean longBranchGenerated = false;
		
		for(int attempt = 0; attempt < 3; ++attempt){
			if((branchSizes[rand.nextInt(4)] = (byte)(rand.nextBoolean() && !longBranchGenerated ? 2 : 1)) == 2){
				longBranchGenerated = true;
			}
		}
		
		for(int yy = y; yy < y + trunkHeight; ++yy){
			world.setBlock(x, yy, z, Registry.BlockLavaInfusedLog);
		}
		
		generateLeaves(world, x, y + trunkHeight, z, rand.nextInt(2) + 1);
		
		for(int a = 0, xx, zz; a < 4; ++a){
			if(branchSizes[a] == 0) continue;
			for(int branch = 0; branch < branchSizes[a]; ++branch){
				xx = a == 0 ? x + 1 + branch : a == 1 ? x - 1 - branch : x;
				zz = a == 2 ? z + 1 + branch : a == 3 ? z - 1 - branch : z;
				world.setBlock(xx, y + trunkHeight - (branchSizes[a] == 1 ? 1 : 2 - branch), zz, Registry.BlockLavaInfusedLog, 0 + a <= 1 ? 4 : 8, 3);
				
				if(branch == 0) generateLeaves(world, xx, y + trunkHeight, zz, rand.nextInt(2) + 1);
			}
		}
		
		for(int yy = y + trunkHeight + 1; yy <= y + trunkHeight + 2; yy++){
			for(int xx = x - 4; xx <= x + 4; xx++){
				for(int zz = z - 4; zz <= z + 4; zz++){
					if(world.getBlock(xx - 1, yy - 1, zz) == Registry.BlockLavaInfusedLeaves && world.getBlock(xx + 1, yy - 1, zz) == Registry.BlockLavaInfusedLeaves && world.getBlock(xx, yy - 1, zz - 1) == Registry.BlockLavaInfusedLeaves && world.getBlock(xx, yy - 1, zz + 1) == Registry.BlockLavaInfusedLeaves){
						world.setBlock(xx, yy, zz, Registry.BlockLavaInfusedLeaves, 0, 3);
					}
				}
			}
		}
		
		return true;
	}
	
	private void generateLeaves(World world, int x, int y, int z, int sideSize){
		for(int xx = x - 2, xDiff, zDiff; xx <= x + 2; ++xx){
			for(int zz = z - 2; zz <= z + 2; ++zz){
				xDiff = Math.abs(xx - x);
				zDiff = Math.abs(zz -z);
				
				if(((xDiff <= 1 && zDiff <= 1) || (xDiff == 2 && zDiff <= sideSize) || (xDiff <= sideSize && zDiff == 2)) && world.isAirBlock(xx, y, zz)){
					world.setBlock(xx, y, zz, Registry.BlockLavaInfusedLeaves, 0 , 3);
				}
			}
		}
	}
}
	