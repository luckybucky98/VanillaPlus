package com.cricket.vanillaplus.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockLavaInfusedCraftingTable extends Block {

	public BlockLavaInfusedCraftingTable(Material material) {
		super(material);
		this.setHardness(2.0F);
	}

}
