package com.cricket.vanillaplus.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import com.cricket.vanillaplus.VanillaPlus;
import com.cricket.vanillaplus.api.Registry;
import com.cricket.vanillaplus.creativetab.CreativeTab;
import com.cricket.vanillaplus.tiles.TileEntityAdvancedSmelter;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class BlockAdvancedSmelter extends BlockContainer{
	private final boolean isActive;
	
	@SideOnly(Side.CLIENT)
	private Icon iconFront;
	private Icon iconTop;
	
	public BlockAdvancedSmelter(int id, boolean isActive) {
		super(id, Material.iron);
		
		this.isActive = isActive;
		this.setHardness(3.0F);
		this.setResistance(10F);
		this.setStepSound(Block.soundMetalFootstep);
	    this.setCreativeTab(CreativeTab.VANILLAPLUS_TAB);
		
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon("vanillaplus:BlockAdvancedSmelter_Side");
		this.iconFront = iconRegister.registerIcon("vanillaplus:" + (this.isActive ? "BlockAdvancedSmelter_Front_Active":"BlockAdvancedSmelter_Front_Idle"));
		this.iconTop = iconRegister.registerIcon("vanillaplus:BlockAdvancedSmelter_Top");
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata){
		return side == metadata ? this.iconFront : this.blockIcon;
	}
	
	public int idDropped() {
		return Registry.BlockAdvancedSmelterIdle.blockID;
	}
	
	public void addBlockadded(World world, int x, int y, int z){
		super.onBlockAdded(world, x, y, z);
		this.setDefaultDirection(world, x, y, z);
		}
	
	private void setDefaultDirection(World world, int x, int y, int z){
		if(!world.isRemote){
			int l = world.getBlockId(x, y, z - 1);
			int il = world.getBlockId(x, y, z + 1);
			int jl = world.getBlockId(x - 1, y, z);
			int kl = world.getBlockId(x + 1, y, z);
			byte bO = 3;
			
			if(Block.opaqueCubeLookup[l] && ! Block.opaqueCubeLookup[il]){
				bO = 3;
				}
			
			if(Block.opaqueCubeLookup[il] && ! Block.opaqueCubeLookup[l]){
				bO = 2;
				}
			
			if(Block.opaqueCubeLookup[kl] && ! Block.opaqueCubeLookup[jl]){
				bO = 5;
				}
			
			if(Block.opaqueCubeLookup[jl] && ! Block.opaqueCubeLookup[kl]){
				bO = 5;
				}
			world.setBlockMetadataWithNotify(x, y, z, bO, 2);
			
		}
	}
	public TileEntity createNewTileEntity(World world){
		return new TileEntityAdvancedSmelter();
	}
}
