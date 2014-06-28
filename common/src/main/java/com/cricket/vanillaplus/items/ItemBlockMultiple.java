package com.cricket.vanillaplus.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemBlockMultiple extends ItemBlock{

	public ItemBlockMultiple(Block block) {
		super(block);
		this.setHasSubtypes(true);
	}
	
	@Override
	public IIcon getIconFromDamage(int meta){
		return this.field_150939_a.getIcon(1, meta);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack){
		return super.getUnlocalizedName() + "." + stack.getItemDamage();
	}
	
	@Override
	public int getMetadata(int meta){
		return meta;
	}

}
