package com.cricket.vanillaplus.blocks;

import com.cricket.vanillaplus.creativetab.CreativeTab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;


public class BlockWaterInfusedTree extends Block{
	public BlockWaterInfusedTree(int id, Material material) {
		super(id, material);
		
		this.setHardness(1.5F);
		this.setResistance(2F);
		this.setStepSound(Block.soundWoodFootstep);
	    this.setCreativeTab(CreativeTab.VANILLAPLUS_TAB);
		
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon("vanillaplus:");
	}

}