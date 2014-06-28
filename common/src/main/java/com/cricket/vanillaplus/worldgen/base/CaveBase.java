package com.cricket.vanillaplus.worldgen.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.cricket.vanillaplus.worldgen.ore.OreGenData;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class CaveBase {
	public final String name;
	public Block block;
	public Block floorBlock;
	public Block ceilingBlock;
	public int blockMeta;
	public int floorMeta;
	public int ceilingMeta;
	public int spawnHeight = 62;
	protected float ceilingAddonWeight = 0.1F;
	protected float floorAddonWeight = 0.2F;
	public BiomeGenBase biome;
	protected CaveWallGen wallGen;
	public List<OreGenData> ores = new ArrayList();
	
	
	public CaveBase(String name, Block mainCaveBlock){
		if(mainCaveBlock == null){
			throw new IllegalArgumentException("You can't use a null block silly");
		}
		
		this.name = name;
		this.block = mainCaveBlock;
	}
	
	public String getName(){
		return this.name;
	}
	
	/**
	 * Setting the blocks
	 * @param world
	 * @param x coord
	 * @param y coord
	 * @param z coord
	 * @param block
	 */
	protected static void setBlock(World world, int x, int y, int z, Block block){
		setBlock(world, x, y, z, block, 0);
	}
	
	protected static void setBlock(World world, int x, int y, int z, Block block, int metadata){
		world.setBlock(x, y, z, block, metadata, 0);
	}
	
	public CaveBase setBlock(Block block){
		this.block = block;
		return this;
	}
	
	public CaveBase setBlock(Block block, int meta){
		this.block = block;
		this.blockMeta = meta;
		this.wallGen = null;
		return this;
	}
	
	public CaveBase setFloorBlock(Block block){
		this.floorBlock = block;
		return this;
	}
	
	public CaveBase setFloorBlock(Block block, int meta){
		this.floorBlock = block;
		this.floorMeta = meta;
		return this;
	}
	
	public CaveBase setCeilingBlock(Block block){
		this.ceilingBlock = block;
		return this;
	}
	
	public CaveBase setCeilingBlock(Block block, int meta){
		this.ceilingBlock = block;
		this.ceilingMeta = meta;
		return this;
	}
	
	public CaveBase setBiome(BiomeGenBase biome){
		this.biome = biome;
		return this;
	}
	
	/**
	 * Set the rate at which floor decorations spawn (0 <= spawn <= 1)
	 * @param weight
	 * @return
	 */
	public CaveBase setFloorAddonSpawnWeight(float weight){
		this.floorAddonWeight = weight;
		return this;
	}
	/**
	 * Set the rate at which ceiling decorations spawn (0 <= spawn <= 1)
	 * @param weight
	 * @return
	 */
	public CaveBase setCeilingAddonSpawnWeight(float weight){
		this.ceilingAddonWeight = weight;
		return this;
	}
	
	public boolean canGenerateAt(World world, int x, int z){
		return this.canGenerateInBiome(world.getBiomeGenForCoords(x, z));
	}
	
	public boolean canGenerateInBiome(BiomeGenBase biome){
		return this.biome == null || this.biome == biome;
	}
	
	public CaveBase setSpawnHeight(int height){
		this.spawnHeight = height;
		return this;
	}
	
	public void generate(World world, Random rand, int x, int floor, int ceiling, int z){
		int center = floor + (ceiling - floor) / 2;
		this.generateCeiling(world, rand, x, ceiling, z);
		
		if(rand.nextFloat() < this.ceilingAddonWeight){
			this.generateCeilingAddons(world, rand, x, ceiling, z);
		}
		
		this.generate(world, rand, x, center, z);
		this.generateFloor(world, rand, x, floor, z);
		
		if(rand.nextFloat() < this.floorAddonWeight){
			this.generateFloorAddons(world, rand, x, floor, z);
		}
	}
	
	public CaveWallGen getWallGen(){
		if(this.wallGen == null){
			this.wallGen = new CaveWallGen(this.block, this.blockMeta);
		}
		return this.wallGen;
	}
	
	public void generate(World world, Random rand, int x, int y, int z){
		this.getWallGen().generate(world, rand, x, y, z);
	}
	
	public void generateCeiling(World world, Random rand, int x, int y, int z){
		if(this.ceilingBlock != null){
			world.setBlock(x, y, z, this.ceilingBlock, this.ceilingMeta, 2);
		} else {
			world.setBlock(x, y, z, this.block, this.blockMeta, 2);
		}
	}
	
	public void generateFloor(World world, Random rand, int x, int y, int z){
		if(this.floorBlock != null){
			world.setBlock(x, y, z, this.floorBlock, this.floorMeta, 2);
		} else {
			world.setBlock(x, y, z, this.block, this.blockMeta, 2);
		}
	}
	
	public void generateCeilingAddons(World world, Random rand, int x, int y, int z){
		
	}
	
	public void generateFloorAddons(World world, Random rand, int x, int y, int z){
		
	}
	
	public void addOre(Block ore, int veinsPerChunk, int orePerVein, int spawnHeight){
		this.addOre(ore, 0, veinsPerChunk, orePerVein, spawnHeight);
	}
	
	public void addOre(Block ore, int meta, int veinsPerChunk, int orePerVein, int spawnHeight){
		this.ores.add(new OreGenData(this, ore, meta, veinsPerChunk, orePerVein, spawnHeight));
	}
}
