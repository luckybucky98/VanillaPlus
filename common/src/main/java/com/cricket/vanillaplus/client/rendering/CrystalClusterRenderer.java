package com.cricket.vanillaplus.client.rendering;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import com.cricket.vanillaplus.client.ClientProxy;
import com.cricket.vanillaplus.tiles.TileEntityCrystalOre;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class CrystalClusterRenderer implements ISimpleBlockRenderingHandler{

	private final CrystalClusterModel model;
	
	public CrystalClusterRenderer(){
		model = new CrystalClusterModel();
	}
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
		if(metadata <= 6){
			GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
			TileEntityCrystalOre crystal = new TileEntityCrystalOre();
			crystal.blockMetadata = metadata;
			TileEntityRendererDispatcher.instance.renderTileEntityAt(crystal, 0.0D, 0.0D, 0.0D, 0.0F);
			GL11.glEnable(32826);
		}
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		int meta = world.getBlockMetadata(x, y, z);
		
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return true;
	}

	@Override
	public int getRenderId() {
		return ClientProxy.crystalClusterRenderType;
	}

}
