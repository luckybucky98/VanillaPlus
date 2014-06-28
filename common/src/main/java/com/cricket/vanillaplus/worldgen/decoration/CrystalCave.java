package com.cricket.vanillaplus.worldgen.decoration;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.TempCategory;

import com.cricket.vanillaplus.Registry;
import com.cricket.vanillaplus.blocks.BlockCrystalOre;
import com.cricket.vanillaplus.worldgen.base.CaveBase;

public class CrystalCave extends CaveBase{
	
	public CrystalCave(String name){
		super(name, Blocks.stone);
		this.addOre(Registry.BlockCrystalOre, 18, 5, 48);
	}
	
	@Override
	public void generateFloor(World world, Random rand, int x, int y, int z){
		setBlock(world, x, y, z, Blocks.stone);
		
		if(y < 16){
			setBlock(world, x, y + 1, z, Blocks.stone);
		}
	}
	
	@Override
	public boolean canGenerateInBiome(BiomeGenBase biome){
		return biome.getTempCategory() == TempCategory.MEDIUM;
	}
	
	@Override
	public void generateCeilingAddons(World world, Random rand, int x, int y, int z){
		setBlock(world, x, y, z, Registry.BlockCrystalOre);
		setBlock(world, x, y - 1, z, Registry.BlockCrystalOre);
	}
}
