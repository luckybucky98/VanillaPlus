package com.cricket.vanillaplus.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockLavaInfusedCraftingTable extends Block {

	public BlockLavaInfusedCraftingTable(int id, Material material) {
		super(id, material);
		this.setHardness(2.0F);
	}
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon("vanillaplus:LavaInfusedCraftingTable");
	}

}
