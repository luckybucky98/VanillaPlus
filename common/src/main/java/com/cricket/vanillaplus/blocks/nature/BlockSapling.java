package com.cricket.vanillaplus.blocks.nature;

import java.util.Random;

import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.cricket.vanillaplus.creativetab.CreativeTabMain;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSapling extends BlockBush implements IGrowable{

	public static final String[] type = new String[]{"lava", "water"};
	private static final IIcon[] texture = new IIcon[type.length];
	
	public BlockSapling(){
		float f = 0.4F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
		this.setCreativeTab(CreativeTabMain.VANILLAPLUS_TAB);
	}
	
	public void updateTick(World world, int x, int y, int z, Random rand){
		if(!world.isRemote){
			super.updateTick(world, x, y, z, rand);
			
			if(world.getBlockLightValue(x, y, z) >= 9 && rand.nextInt(7) == 0){
				this.markOrGrowMarked(world, x, y, z, rand);
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){
		meta &= 7;
		return texture[MathHelper.clamp_int(meta, 0, 5)];
	}
	
	protected ItemStack createStackedBlock(int par1){
		return new ItemStack(this, 1, par1 & 3);
	}
	
	public void markOrGrowMarked(World world, int x, int y, int z, Random rand){
		int meta = world.getBlockMetadata(x, y, z);
		
		if((meta & 8) == 0){
			world.setBlockMetadataWithNotify(x, y, z, 1 | 8, 4);
		} else {
			this.growTree(world, x, y, z, rand);
		}
	}
	
	public void growTree(World world, int x, int y, int z, Random rand){
		
	}
	
	@Override
	public boolean func_149851_a(World world, int x_, int y, int z, boolean p_149851_5_) {
		return true;
	}

	@Override
	public boolean func_149852_a(World world, Random rand, int x, int y, int z) {
		return (double)world.rand.nextFloat() < 0.45D;
	}

	@Override
	public void func_149853_b(World world, Random rand, int x, int y, int z) {
		this.markOrGrowMarked(world, x, y, z, rand);
	}

}
