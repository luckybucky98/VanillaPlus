package com.vanillaplus.georgecode.blocks;

import com.vanillaplus.georgecode.creativetab.CreativeTab;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;


public class BlockCrystalOre extends Block{
	public BlockCrystalOre(int id, Material material) {
		super(id, material);
		
		this.setHardness(2.5F);
		this.setResistance(5F);
		this.setLightValue(0.6F);
		this.setStepSound(Block.soundStoneFootstep);
	    this.setCreativeTab(CreativeTab.VANILLAPLUS_TAB);
		
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon("vanillaplus:");
	}

}