package com.vanillaplus.georgecode.items;

import com.vanillaplus.georgecode.creativetab.CreativeTab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class itemBasic extends Item{

	public itemBasic(int id) {
		super(id);
		
		this.setCreativeTab(CreativeTab.VANILLAPLUS_TAB);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister){
		this.itemIcon = iconRegister.registerIcon("Vanillaplus:ItemCompressedCoal");
		this.itemIcon = iconRegister.registerIcon("Vanillaplus:ItemSuperDiamond");
	}

}
