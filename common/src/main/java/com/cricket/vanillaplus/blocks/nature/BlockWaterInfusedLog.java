package com.cricket.vanillaplus.blocks.nature;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

import com.cricket.vanillaplus.creativetab.CreativeTabMain;


public class BlockWaterInfusedLog extends Block{

	private IIcon topIcon;
	
	public BlockWaterInfusedLog(Material material) {
		super(material);
		
		this.setHardness(1.5F);
		this.setResistance(2F);
		this.setStepSound(Block.soundTypeWood);
	    this.setCreativeTab(CreativeTabMain.VANILLAPLUS_TAB);	
	}
	
	public void registerBlockIcons(IIconRegister register){
		this.blockIcon = register.registerIcon("vanillaplus:BlockWaterInfusedLog");
		this.topIcon = register.registerIcon("vanillaplus:BlockWaterInfusedLogTop");
	}
	
	public IIcon getIcon(int side, int meta){
		return side == 1 || side == 0 ? this.topIcon : this.blockIcon;
	}
}