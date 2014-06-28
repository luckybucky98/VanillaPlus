package com.cricket.vanillaplus.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import com.cricket.vanillaplus.creativetab.CreativeTabMain;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class BlockCompressor extends Block{
	public BlockCompressor(Material material) {
		super(material);
		
		this.setHardness(3.0F);
		this.setResistance(10F);
		this.setStepSound(Block.soundTypeMetal);
	    this.setCreativeTab(CreativeTabMain.VANILLAPLUS_TAB);
		
	}

}
