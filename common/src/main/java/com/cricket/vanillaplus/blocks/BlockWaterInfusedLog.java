package com.cricket.vanillaplus.blocks;

import com.cricket.vanillaplus.creativetab.CreativeTab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;


public class BlockWaterInfusedLog extends Block{
	
	@SideOnly(Side.CLIENT)
	public Icon iconTop;

	public BlockWaterInfusedLog(int id, Material material) {
		super(id, material);
		
		this.setHardness(1.5F);
		this.setResistance(2F);
		this.setStepSound(Block.soundWoodFootstep);
	    this.setCreativeTab(CreativeTab.VANILLAPLUS_TAB);
		
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata){
		return side==1?this.iconTop:(side==0?this.iconTop:(side!=metadata?this.blockIcon:this.blockIcon));
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon("vanillaplus:BlockWaterInfusedLog");
		this.iconTop = iconRegister.registerIcon("vanillaplus:BlockWaterInfusedLogTop");
	}
}