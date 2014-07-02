package com.cricket.vanillaplus.blocks.decoration;

import com.cricket.vanillaplus.creativetab.CreativeTab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockWaterInfusedPlanks extends Block{

	public BlockWaterInfusedPlanks(Material material) {
		super(material);
		this.setCreativeTab(CreativeTab.VP_DECORATION);
		this.setHardness(2F);
	}
	
	public void registerBlockIcons(IIconRegister register){
		this.blockIcon = register.registerIcon("vanillaplus:BlockWaterInfusedPlanks");
	}
	
	public IIcon getIcon(int side, int meta){
		return blockIcon;
	}
}
