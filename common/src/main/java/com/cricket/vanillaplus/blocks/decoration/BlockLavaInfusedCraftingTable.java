package com.cricket.vanillaplus.blocks.decoration;

import com.cricket.vanillaplus.creativetab.CreativeTab;
import com.cricket.vanillaplus.reference.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockLavaInfusedCraftingTable extends Block {
	
	@SideOnly(Side.CLIENT)
	private IIcon top;
	
	@SideOnly(Side.CLIENT)
	private IIcon front;
	

	public BlockLavaInfusedCraftingTable(Material material) {
		super(material);
		this.setHardness(2.0F);
		this.setCreativeTab(CreativeTab.VP_DECORATION);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon){
		this.blockIcon = icon.registerIcon(Reference.MODID + ":BlockLavaInfusedCraftingTableSide");
		this.top = icon.registerIcon(Reference.MODID + ":BlockLavaInfusedCraftingTableTop");
		this.front =  icon.registerIcon(Reference.MODID + ":BlockLavaInfusedCraftingTableFront");
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcons(int side, int meta){
		return side == 1 ? this.top : (side == 0 ? Blocks.planks.getBlockTextureFromSide(side) : (side != 2 && side != 4 ? this.blockIcon : this.front));
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par, float x1, float y1, float z1){
		if(!world.isRemote){
			return true;
		} else {
			player.displayGUIWorkbench(x, y, z);
			return true;
		}
	}

}
