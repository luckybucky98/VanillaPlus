package com.cricket.vanillaplus.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.FakePlayer;

import com.cricket.vanillaplus.Registry;
import com.cricket.vanillaplus.VPDeath;
import com.cricket.vanillaplus.tiles.TileEntityGrinder;

public class BlockGrinder extends BlockContainer{
	
	public BlockGrinder() {
		super(Material.iron);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int var2) {
		return new TileEntityGrinder();
	}
	
	@Override
	public Item getItemDropped(int par1, Random rand, int par3){
		return Item.getItemFromBlock(Registry.BlockGrinderIdle);
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z){
		super.onBlockAdded(world, x, y, z);
		this.setDefaultDirection(world, x, y, z);
	}
	
	private void setDefaultDirection(World world, int x, int y, int z){
		if(!world.isRemote){
			Block block1 = world.getBlock(x, y, z - 1);
            Block block2 = world.getBlock(x, y, z + 1);
            Block block3 = world.getBlock(x - 1, y, z);
            Block block4 = world.getBlock(x + 1, y, z);
            byte direction = 3;

            if (block1.func_149730_j() && !block2.func_149730_j())
            {
                direction = 3;
            }

            if (block2.func_149730_j() && !block1.func_149730_j())
            {
                direction = 2;
            }

            if (block3.func_149730_j() && !block4.func_149730_j())
            {
                direction = 5;
            }

            if (block4.func_149730_j() && !block3.func_149730_j())
            {
                direction = 4;
            }

            world.setBlockMetadataWithNotify(x, y, z, direction, 2);
		}
	}
	
	@Override
	public int tickRate(World world){
		return 20;
	}
	
	@Override
	public boolean getBlocksMovement(IBlockAccess access, int x, int y, int z){
		return true;
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random rand){
		if(world.isRemote){
			world.scheduleBlockUpdate(x, y, z, this, 0);
		}
		setStateIfMobInteractsWithBlock(world, x, y + 1, z);
		
		if(world.getBlockMetadata(x, y, z) > 0){
			world.scheduleBlockUpdate(x, y, z, this, tickRate(world));
		} else {
			world.scheduleBlockUpdate(x, y, z, this, 0);
		}
	}
	
	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity){
		if(!world.isRemote){
			setStateIfMobInteractsWithBlock(world, x, y, z);
		}
	}
	
	protected AxisAlignedBB getSensativeAABB(int x, int y, int z){
		return AxisAlignedBB.getBoundingBox(x, y + 2, z, x + 1, y + 3, z + 1);
	}
	
	private void setStateIfMobInteractsWithBlock(World world, int x, int y, int z){
		notifyArround(world, x, y, z);
		world.markBlockForUpdate(x, y, z);
		world.playSoundEffect(x + 0.5D, y + 0.1D, z + 0.5D, "liquid.water", 0.3F, 0.5F);
		removeHealthPlayer(Minecraft.getMinecraft().thePlayer);
	}
	
	public void removeHealthPlayer(EntityPlayer player){
		if(!player.capabilities.isCreativeMode){
			player.setHealth(player.getHealth() - 1000000);
		}
		
		if(player instanceof FakePlayer){
			System.out.println("[Vanilla Plus] Just tried to kill a fake player");
		}
		
		if(player.getHealth() <= 0.001F){
			player.onDeath(VPDeath.grinder);
		}
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int metadata){
		if(metadata > 0){
			world.notifyBlocksOfNeighborChange(x, y, z, this);
			world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
			world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
		}
		
		super.breakBlock(world, x, y, z, block, metadata);
	}
	
	protected void notifyArround(World world, int x, int y, int z){
		world.notifyBlocksOfNeighborChange(x, y, z, this);
		world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
		world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
		world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
		world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
	}
}
