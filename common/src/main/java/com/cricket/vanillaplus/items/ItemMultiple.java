package com.cricket.vanillaplus.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.cricket.vanillaplus.creativetab.CreativeTabMain;

public class ItemMultiple extends Item{
	
	public String[] textureNames;
	public IIcon[] icons;
	
	public ItemMultiple(String[] textureNames){
		this.textureNames = textureNames;
		this.setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack){
		return super.getUnlocalizedName() + '.' + stack.getItemDamage();
	}
	
	@Override
	public void registerIcons(IIconRegister register){
		this.icons = new IIcon[this.textureNames.length];
		
		for(int c = 0; c < this.textureNames.length; c++){
			String s = this.getIconString();
			
			if(this.textureNames[c] != null){
				s += "_" + this.textureNames[c];	
			}
			
			this.icons[c] = register.registerIcon(s);
		}
	}
	
	@Override
	public IIcon getIconFromDamage(int meta){
		return this.icons[meta];
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list){
		for(int c = 0; c < this.textureNames.length; c++){
			list.add(new ItemStack(this, 1, c));
		}
	}
}
