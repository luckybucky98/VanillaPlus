package com.cricket.vanillaplus.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockLavaInfusedPlanks extends Block{

	public BlockLavaInfusedPlanks(int id, Material material) {
		super(id, material);
		this.setStepSound(Block.soundWoodFootstep);
		this.setHardness(2F);
	}
	
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon("vanillaplus:BlockLavaInfusedWood");
	}

}
