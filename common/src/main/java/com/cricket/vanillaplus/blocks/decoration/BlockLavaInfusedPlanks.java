package com.cricket.vanillaplus.blocks.decoration;

import com.cricket.vanillaplus.creativetab.CreativeTab;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockLavaInfusedPlanks extends Block{

	public BlockLavaInfusedPlanks(Material material) {
		super(material);
		this.setStepSound(Block.soundTypeWood);
		this.setHardness(2F);
		this.setCreativeTab(CreativeTab.VP_DECORATION);
	}
	
	public void registerBlockIcons(IIconRegister register){
		this.blockIcon = register.registerIcon("vanillaplus:BlockLavaInfusedPlanks");
	}
	
	public IIcon getIcon(int side, int meta){
		return blockIcon;
	}
}
