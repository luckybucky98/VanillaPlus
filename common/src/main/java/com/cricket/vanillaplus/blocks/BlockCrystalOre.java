package com.cricket.vanillaplus.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

import com.cricket.vanillaplus.creativetab.CreativeTab;


public class BlockCrystalOre extends Block{
	public BlockCrystalOre(Material material) {
		super(material);
		
		this.setHardness(2.5F);
		this.setResistance(5F);
		this.setStepSound(Block.soundTypeStone);
	    this.setCreativeTab(CreativeTab.VANILLAPLUS_TAB);
	}
	
	public IIcon getIcon(int side, int meta){
		return blockIcon;
	}
	
	public void registerBlockIcons(IIconRegister register){
		this.blockIcon = register.registerIcon("vanillaplus:BlockCrystalOre");
	}

}