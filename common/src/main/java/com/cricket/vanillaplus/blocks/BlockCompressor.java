package com.vanillaplus.georgecode.blocks;

import com.vanillaplus.georgecode.creativetab.CreativeTab;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;


public class BlockCompressor extends Block{
	public BlockCompressor(int id, Material material) {
		super(id, material);
		
		this.setHardness(3.0F);
		this.setResistance(10F);
		this.setStepSound(Block.soundMetalFootstep);
	    this.setCreativeTab(CreativeTab.VANILLAPLUS_TAB);
		
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon("vanillaplus:");
 	}

}
