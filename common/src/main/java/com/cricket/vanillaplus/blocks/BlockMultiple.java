package com.cricket.vanillaplus.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.cricket.vanillaplus.creativetab.CreativeTabMain;

public class BlockMultiple extends Block{
	public String[] types;
	public IIcon[] icons;
	
	public BlockMultiple(Material material, String[] types){
		super(material);
		this.types = types;
		this.setCreativeTab(CreativeTabMain.VANILLAPLUS_TAB);
	}
	
	@Override
	public int damageDropped(int meta){
		return meta;
	}
	
	@Override
	public int getDamageValue(World world, int x, int y, int z){
		return world.getBlockMetadata(x, y, z);
	}
	
	@Override
	public IIcon getIcon(int side, int meta){
		if(meta < 0 || meta >= this.types.length){
			meta = 0;
		}
		
		return this.icons[meta];
	}
	
	@Override
	public void registerBlockIcons(IIconRegister register){
		this.icons = new IIcon[this.types.length];
		
		for(int c = 0; c < this.types.length; c++){
			String s = this.getTextureName();
			if(this.types[c] != null){
				s += '_' + this.types[c];
			}
			
			this.icons[c] = register.registerIcon(s);
		}
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list){
		for(int c = 0; c < this.types.length; c++){
			list.add(new ItemStack(item, 1, c));
		}
	}
}
