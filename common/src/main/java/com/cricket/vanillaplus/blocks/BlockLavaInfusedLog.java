package com.cricket.vanillaplus.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

import com.cricket.vanillaplus.creativetab.CreativeTab;


public class BlockLavaInfusedLog extends Block{
	
	private IIcon topIcon;
	
	public BlockLavaInfusedLog(Material material) {
		super(material);
		
		this.setHardness(1.5F);
		this.setResistance(2F);
		this.setStepSound(Block.soundTypeWood);
	    this.setCreativeTab(CreativeTab.VANILLAPLUS_TAB);
		
	}
	
	public void registerBlockIcons(IIconRegister register){
		this.blockIcon = register.registerIcon("vanillaplus:BlockLavaInfusedLog");
		this.topIcon = register.registerIcon("vanillaplus:BlockLavaInfusedLog_Top");
	}
	
	public IIcon getIcon(int side, int meta){
		return side == 1 ? this.topIcon : (side == 0 ? this.topIcon : (this.blockIcon));
	}

}