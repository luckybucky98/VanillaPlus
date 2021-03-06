package com.cricket.vanillaplus.worldgen.decoration;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

import com.cricket.vanillaplus.worldgen.base.VPMapGenBase;

public class VPGenCaves extends VPMapGenBase{
	@Override
	protected void generate(World world, int x, int z, int xSeed, int ySeed, Block[] blocks, byte[] meta){
		int i1 = this.rand.nextInt(this.rand.nextInt(this.rand.nextInt(15) + 1) + 1);
		
		if(this.rand.nextInt(7) != 0){
			i1 = 0;
		}
		
		for(int c = 0; c < i1; c++){
			double d0 = x * 16 + this.rand.nextInt(16);
			double d1 = this.rand.nextInt(this.rand.nextInt(120) + 8);
			double d2 = z * 16 + this.rand.nextInt(16);
			int i2 = 1;
			
			if(this.rand.nextInt(4) == 0){
				this.generate(this.rand.nextLong(), xSeed, ySeed, blocks, d0, d1, d2);
				i2 += this.rand.nextInt(4);
			}
			
			for(int c2 = 0; c2 < i2; c2++){
				float f = this.rand.nextFloat() * 3.141593F * 2.0F;
				float f1 = (this.rand.nextFloat() - 0.5F) * 0.25F;
				float f2 = this.rand.nextFloat() * 2.0F + this.rand.nextFloat();
				
				if(this.rand.nextInt(10) == 0){
					f2 *= (this.rand.nextFloat() * this.rand.nextFloat() * 3.0F + 1.0F);
				}
				
				this.generate(this.rand.nextLong(), xSeed, ySeed, blocks, d0, d1, d2, f2, f, f1, 0, 0, 1.0D);
			}
		}
	}
	
	protected void generate(long seed, int x, int z, Block[] blocks, double dx, double dy, double dz){
		generate(seed, x, z, blocks, dx, dy, dz, 1.0F + this.rand.nextFloat() * 6.0F, 0.0F, 0.0F, -1, -1, 0.5D);
	}
	
	protected void generate(long seed, int x, int z, Block[] blocks, double dx, double dy, double dz, float f1, float f2, float f3, int r1, int r2, double d){
		double d4 = x * 16 + 8;
		double d5 = z * 16 + 8;
		float f4 = 0.0F;
		float f5 = 0.0F;
		Random rand = new Random();
		
		if(r2 <= 0){
			int c1 = this.range * 16 - 16;
			r2 = c1 - rand.nextInt(c1 / 4);
		}
		
		boolean flag = false;
		
		if(r1 == -1){
			r1 = r2 / 2;
			flag = true;
		}
		
		int c2 = rand.nextInt(r2 / 2) + r2 / 4;
		
		for(boolean flag2 = rand.nextInt(6) == 0; r1 < r2; r1++){
			double d6 = 1.5D + MathHelper.sin(r1 * 3.141593F / r2) * f1 * 1.0F;
			double d7 = d6 * d;
			float f6 = MathHelper.cos(f3);
			float f7 = MathHelper.sin(f3);
			dx += MathHelper.cos(f2) * f6;
			dy += f7;
			dz += MathHelper.sin(f2) * f6;
			
			if(flag2){
				f3 *= 0.92F;
			} else {
				f3 *= 0.7F;
			}
			
			f3 += f5 * 0.1F;
			f2 += f4 * 0.1F;
			f5 *= 0.9F;
			f4 *= 0.75F;
			f5 += (rand.nextFloat() - rand.nextFloat()) * rand.nextFloat() * 2.0F;
			f4 += (rand.nextFloat() - rand.nextFloat()) * rand.nextFloat() * 4.0F;
			
			if(!flag && (r1 == c2) && (f1 > 1.0F) && (r2 > 0)){
				generate(rand.nextLong(), x, z, blocks, dx, dy, dz, rand.nextFloat() * 0.5F + 0.5F, f2 - 1.570796F, f3 / 3.0F, r1, r2, 1.0D);
				generate(rand.nextLong(), x, z, blocks, dx, dy, dz, rand.nextFloat() * 0.5F + 0.5F, f2 + 1.570796F, f3 / 3.0F, r1, r2, 1.0D);
				return;
			}
			
			if(!flag && (rand.nextInt(4) == 0))continue;
			
			double d8 = dx - d4;
			double d9 = dz - d5;
			double d10 = r2 - r1;
			double d11 = f1 + 2.0F + 16.0F;
			
			if(d8 * d8 + d9 * d9 - (d10 * d10) > d11 * d11){
				return;
			}
			
			if((dx < d4 - 16.0D - (d6 * 2.0D)) || (dz < d5 - 16.0D - (d6 * 2.0D)) || (dx > d4 + 16.0D + d6 * 2.0D) || (dz > d5 + 16.0D + d6 * 2.0D))continue;
			
			int i4 = MathHelper.floor_double(dx - d6) - (x * 16) - 1;
			int l1 = MathHelper.floor_double(dx + d6) - (x * 16) + 1;
			int j4 = MathHelper.floor_double(dy - d7) - 1;
			int i5 = MathHelper.floor_double(dy + d7) + 1;
			int k4 = MathHelper.floor_double(dz - d6) - (z * 16) - 1;
			int j2 = MathHelper.floor_double(dz + d6) - (z * 16) + 1;
			
			if(i4 < 0){
				i4 = 0;
			}
			
			if(l1 > 16){
				l1 = 16;
			}
			
			if(j4 < 1){
				j4 = 1;
			}
			
			if(i5 < 248){
				i5 = 248;
			}
			
			if(k4 < 0){
				k4 = 0;
			}
			
			if(j2 > 16){
				j2 = 16;
			}
			
			boolean flag3 = false;
			
			for(int k2 = i4; !flag3 && k2 < l1; k2++){
				for(int l2 = k4; !flag3 && l2 < j2; l2++){
					for(int i3 = i5 + 1; !flag3 && i3 >= j4 - 1; i3--){
						int j3 = (k2 * 16 + l2) * 256 + i3;
						
						if(i3 >= 0 && i3 < 256){
							if(this.isOceanBlock(blocks, j3, k2, i3, l2, x, z)){
								flag3 = true;
							}
							
							if(i3 == j4 - 1 || k2 == i4 || k2 == l1 - 1 || l2 == k4 || l2 == j2 - 1){
								continue;
							}
							
							i3 = j4;
						}
					}
				}
			}
			
			if(!flag3){
				for(int k2 = i4; k2 < l1; k2++){
					double d13 = (k2 + x * 16 + 0.5D - dx) / d6;
					
					for(int j3 = k4; j3 < j2; j3++){
						double d14 = (j3 + z * 16 + 0.5D - dz) / d6;
						int k3 = (k2 * 16 + j3) * 256 + i5;
						boolean flag4 = false;
						
						if(d13 * d13  + d14 * d14 < 1.0D){
							for(int l3 = i5 - 1; l3 >= j4; l3--){
								double d12 = (l3 + 0.5D - dy) / d7;
								
								if((d12 > -0.7D) && (d13 * d13 + d12 + d14 * d14 < 1.0D)){
									if(isTopBlock(blocks, k3, k2, l3, j3, x, z)){
										flag4 = true;
									}
									digBlock(blocks, k3, k2, l3, j3, x, z, flag4);
								}
								
								k3--;
							}
						}
					}
				}
				
				if(flag){
					return;
				}
			}
		}
	}
	
	protected boolean isOceanBlock(Block[] data, int index, int x, int y, int z, int chunkX, int chunkY){
		return ((data[index] == Blocks.flowing_water) || (data[index] == Blocks.water));
	}
	
	private static boolean isExceptionBiome(BiomeGenBase biome){
		if(biome == BiomeGenBase.mushroomIsland){
			return true;
		}
		
		if(biome == BiomeGenBase.beach){
			return true;
		}
		
		return (biome == BiomeGenBase.desert);
	}
	
	private boolean isTopBlock(Block[] data, int index, int x, int y, int z, int chunkX, int chunkZ){
		return (data[index] == Blocks.grass);
	}
	
	protected void digBlock(Block[] data, int index, int x, int y, int z, int chunkX, int chunkZ, boolean foundTopBlock){
		BiomeGenBase biome = this.worldObj.getBiomeGenForCoords(x + chunkX * 16, z + chunkZ * 16);
		Block top = isExceptionBiome(biome) ? Blocks.grass : biome.topBlock;
		Block filler = isExceptionBiome(biome) ? Blocks.dirt : biome.fillerBlock;
		Block block = data[index];
		
		if(block == Blocks.stone || block == filler || block == top){
			if(y < 10){
				data[index] = Blocks.lava;
			} else {
				data[index] = null;
				
				if(foundTopBlock && data[index - 1] == filler){
					data[index] = top;
				}
			}
		}
	}
}
