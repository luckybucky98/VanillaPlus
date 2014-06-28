package com.cricket.vanillaplus.blocks.nature;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

import com.cricket.vanillaplus.creativetab.CreativeTabMain;


public class BlockLavaInfusedLeaves extends Block{
	public BlockLavaInfusedLeaves(Material material) {
		super(material);
		
		this.setHardness(0.2F);
		this.setResistance(2F);
		this.setStepSound(Block.soundTypeGrass);
	    this.setCreativeTab(CreativeTabMain.VANILLAPLUS_TAB);
	}
	
	public IIcon getIcon(int side, int meta){
		return blockIcon;
	}
	
	public void registerBlockIcons(IIconRegister register){
		this.blockIcon = register.registerIcon("vanillaplus:BlockLavaInfusedLeaves");
		
	}
}

