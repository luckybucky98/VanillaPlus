package com.cricket.vanillaplus.blocks.nature;


import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.cricket.vanillaplus.Registry;
import com.cricket.vanillaplus.client.ClientProxy;
import com.cricket.vanillaplus.creativetab.CreativeTab;
import com.cricket.vanillaplus.tiles.TileEntityCrystalOre;


public class BlockCrystalOre extends Block{
	
	public EntityPlayer player;
	public static final int[] colors = {16777215, 16777086, 16727041, 37119, 40960, 14540287, 5592439};
	
	public BlockCrystalOre() {
		super(Material.rock);
		this.setHardness(2.5F);
		this.setResistance(5F);
		this.setStepSound(Block.soundTypeGlass);
	    this.setCreativeTab(CreativeTab.VP_NATURE);
	    this.setTickRandomly(true);
	    this.setLightLevel(0.921F);
	    this.setLightOpacity(1);
	}
	
	@Override
	public boolean renderAsNormalBlock(){
		return false;
	}
	
	@Override
	public void onEntityWalking(World world, int x, int y, int z, Entity entity){
		if(world.getBlockMetadata(x, y, z) == 1){
			if(entity instanceof EntityPlayer){
				this.player.setHealth(-1.0F);
			}
		}
	}
	
	@Override
	public int getRenderType(){
		return 0;
		//return ClientProxy.crystalClusterRenderType;
	}
	
	@Override
	public boolean canRenderInPass(int pass){
		ClientProxy.renderPass = pass;
		return true;
	}
	
	@Override
	public int getRenderBlockPass(){
		return 1;
	}
	
	@Override
	public boolean isOpaqueCube(){
		return false;
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z){
		this.updateTick(world, x, y, z, world.rand);
	}
	
	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int meta, int fortune){
		if(meta == 0 && world.provider.dimensionId == -1){
			return new ArrayList();
		}
		
		return super.getDrops(world, x, y, z, meta, fortune);
	}
	
	@Override
	public Item getItemDropped(int meta, Random random, int fortune){
		return Registry.ItemCrystal;
	}
	
	@Override
	public int quantityDropped(int meta, int fortune, Random rand){
		int c = 2 + rand.nextInt(3) + rand.nextInt(fortune + 1);
			if(c > 4){
				c = 4;
			}
			
			return c;
	}
	
	@Override
	public int damageDropped(int meta){
		return meta + 1;
	}
	
	public IIcon getIcon(int side, int meta){
		return blockIcon;
	}
	
	public void registerBlockIcons(IIconRegister register){
		this.blockIcon = register.registerIcon("vanillaplus:BlockCrystalOre");
	}
	
	public TileEntity createTileEntity(World world, int metadata){
		if(metadata <= 6){
			return new TileEntityCrystalOre();
		}
		return super.createTileEntity(world, metadata);
	}

}