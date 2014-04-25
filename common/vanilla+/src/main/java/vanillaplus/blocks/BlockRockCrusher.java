package com.cricket.vanillaplus.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.cricket.vanillaplus.VanillaPlus;
import com.cricket.vanillaplus.tiles.TileEntityRockCrusher;

import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockRockCrusher extends BlockContainer {
	
	private final boolean isActive;
	private Random rand = new Random();
	private static boolean keepInventory;
	
	@SideOnly(Side.CLIENT)
	private Icon iconFront;
	
	@SideOnly(Side.CLIENT)
	private Icon iconBack;
	
	
	public BlockRockCrusher(int id, boolean isActive) {
		super(id,Material.rock);
		this.isActive=isActive;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon("vanillaplus:BlockRockCrusherSide");
		this.iconFront= iconRegister.registerIcon("vanillaplus:"+(this.isActive?"BlockRockCrusherFrontActive":"BlockRockCrusherFrontIdle"));
		this.iconBack=iconRegister.registerIcon("vanillaplus:BlockRockCrusherBack");
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata){
		
		
		return side==1?this.blockIcon:(side==0?this.blockIcon:(side!=metadata?this.blockIcon:this.iconFront));
	}
	
	public int idDropped(int par1, Random random, int par3){
		return VanillaPlus.BlockRockCrusherIdle.blockID;
	}
	
	public void onBlockAdded(World world, int x, int y, int z){
		super.onBlockAdded(world, x, y, z);
		this.setDefaultDirection(world,x,y,z);
	}
	
	private void setDefaultDirection(World world, int x, int y, int z){
		if(!world.isRemote){
			int l = world.getBlockId(x, y, z-1);
			int il=world.getBlockId(x, y, z+1);
			int jl=world.getBlockId(x-1, y, z);
			int kl=world.getBlockId(x+1, y, z);
			byte b0 = 3;
			
			if(Block.opaqueCubeLookup[l]&&!Block.opaqueCubeLookup[il]){
				b0=3;
			}
			if(Block.opaqueCubeLookup[il]&&!Block.opaqueCubeLookup[l]){
				b0=2;
			}
			
			if(Block.opaqueCubeLookup[kl]&&!Block.opaqueCubeLookup[jl]){
				b0=5;
			}
			
			if(Block.opaqueCubeLookup[jl]&&!Block.opaqueCubeLookup[kl]){
				b0=5;
			}
			world.setBlockMetadataWithNotify(x, y, z, b0, 2);
		}
		
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		
		return new TileEntityRockCrusher();
	}
	
	public void onBlockPlacedby(World world, int x, int y, int z, EntityLivingBase entitiyLivingBase, ItemStack itemStack){
		int l=MathHelper.floor_double((double)(entitiyLivingBase.rotationYaw*4.0F/360.0F)+0.5D)&3;
		if(l==0){
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}
		if(l==1){
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}
		if(l==2){
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}
		if(l==3){
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}
		if(itemStack.hasDisplayName()){
			((TileEntityRockCrusher) world.getBlockTileEntity(x, y, z)).setGuiDisplayName(itemStack.getDisplayName());
		}
	}
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitx, float hity, float hitz){
		if(!world.isRemote){
			FMLNetworkHandler.openGui(player, VanillaPlus.instance, VanillaPlus.guiIDRockCrusher, world, x, y, z);
		}
		return true;
	}
}

//1 is top
//0 is bottom
//2,3,4,5 sides
