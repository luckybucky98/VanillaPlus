package com.cricket.vanillaplus.blocks.nature;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

import com.cricket.vanillaplus.creativetab.CreativeTab;

public class BlockWaterInfusedLeaves extends Block {
	public BlockWaterInfusedLeaves(Material material) {
		super(material);
		
		this.setHardness(0.2F);
		this.setResistance(0.1F);
		this.setStepSound(Block.soundTypeGrass);
	    this.setCreativeTab(CreativeTab.VP_NATURE);
	}
	
	public void registerBlockIcons(IIconRegister register){
		this.blockIcon = register.registerIcon("vanillaplus:BlockWaterInfusedLeaves");
	}
	
	public IIcon getIcon(int side, int meta){
		return blockIcon;
	}
}
