package com.cricket.vanillaplus.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

import com.cricket.vanillaplus.blocks.nature.BlockSapling;

public class ItemSapling extends ItemBlockWithMetadata{

	public ItemSapling(Block block) {
		super(block, block);
	}
	
	public String getUnlocalizedName(ItemStack stack){
		int d = stack.getItemDamage();
		if(d < 0 || d >= BlockSapling.type.length){
			d = 0;
		}
		return super.getUnlocalizedName() + "." + BlockSapling.type[d];
	}
	
	public int getMetadata(int meta){
		return meta;
	}

}
