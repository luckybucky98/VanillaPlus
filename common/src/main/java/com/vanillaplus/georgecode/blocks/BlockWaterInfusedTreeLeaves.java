package com.vanillaplus.georgecode.blocks;

import com.vanillaplus.georgecode.creativetab.CreativeTab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockWaterInfusedTreeLeaves extends Block {
	public BlockWaterInfusedTreeLeaves(int id, Material material) {
		super(id, material);
		
		this.setHardness(0.2F);
		this.setResistance(0.1F);
		this.setStepSound(Block.soundGrassFootstep);
	    this.setCreativeTab(CreativeTab.VANILLAPLUS_TAB);
	}
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon("vanillaplus:BlockWaterInfusedLeaves");
	}
}
