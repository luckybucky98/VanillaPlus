package com.vanillaplus.georgecode.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockWaterInfusedWood extends Block{

	public BlockWaterInfusedWood(int id, Material material) {
		super(id, material);
		
		this.setHardness(2F);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon("vanillaplus:BlockWaterInfusedWood");
	}
}
