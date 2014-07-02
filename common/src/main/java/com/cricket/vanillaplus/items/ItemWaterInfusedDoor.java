package com.cricket.vanillaplus.items;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.cricket.vanillaplus.Registry;
import com.cricket.vanillaplus.creativetab.CreativeTab;

public class ItemWaterInfusedDoor extends Item{
	public ItemWaterInfusedDoor(Material material){
		this.maxStackSize = 1;
		this.setCreativeTab(CreativeTab.VP_DECORATION);
	}
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int meta, float x1, float y1, float z1){
		if(stack.stackSize != 1){
			return false;
		} else {
			++y;
			Block door = Registry.BlockWaterInfusedDoor;
			
			if(player.canPlayerEdit(x, y, z, meta, stack) && player.canPlayerEdit(x, y + 1, z, meta, stack)){
				if(!door.canPlaceBlockAt(world, x, y, z)){
					return false;
				} else {
					int rotate = MathHelper.floor_double((double)((player.rotationYaw + 180.0F) * 4.0F / 360.0F) - 0.5D) & 3;
					placeDoorBlock(world, x, y, z, rotate, door);
					--stack.stackSize;
					return true;
				}
			} else {
				return false;
			}
		}
	}
	
	public static void placeDoorBlock(World world, int x, int y, int z, int meta, Block block){
		byte b0 = 0;
		byte b1 = 0;
		
		if(meta == 0){
			b1 = 1;
		}
		
		if(meta == 1){
			b0 = -1;
		}
		
		if(meta == 2){
			b1 = -1;
		}
		
		if(meta == 3){
			b0 = 1;
		}
		
		int c = (world.getBlock(x - b0, y, z - b1).isNormalCube() ? 1: 0) + (world.getBlock(x - b0, y + 1, z - b1).isNormalCube() ? 1 : 0);
		int d = (world.getBlock(x + b0, y, z + b1).isNormalCube() ? 1: 0) + (world.getBlock(x + b0, y + 1, z + b1).isNormalCube() ? 1 : 0);
		boolean flag = world.getBlock(x - b0, y, z - b1) == block || world.getBlock(x - b0, y + 1, z - b1) == block;
		boolean flag1 = world.getBlock(x + b0, y, z + b1) == block || world.getBlock(x + b0, y + 1, z + b1) == block;
		boolean flag2 = false;
		
		if(flag && !flag1){
			flag2 = true;
		} else if(d > c){
			flag2 = true;
		}
		
		world.setBlock(x, y, z, block, meta, 2);
		world.setBlock(x, y + 1, z, block, 8 | (flag2 ? 1 : 0), 2);
		world.notifyBlocksOfNeighborChange(x, y, z, block);
		world.notifyBlocksOfNeighborChange(x, y + 1, z, block);
	}
}
