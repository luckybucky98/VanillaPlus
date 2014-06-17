package com.cricket.vanillaplus.blocks;

import java.util.Random;

import com.cricket.vanillaplus.Registry;
import com.cricket.vanillaplus.VanillaPlus;
import com.cricket.vanillaplus.tiles.TileEntityAdvancedSmelter;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockAdvancedSmelter extends BlockContainer{

	private static boolean hasBlockChanged;
	private final Random random = new Random();
	private boolean isActive;
	private IIcon iconFront;
	private IIcon iconTop;
	
	
	public BlockAdvancedSmelter(Material material) {
		super(material);
		
	}
	
	public Item getItemDropped(int par1, Random rand, int par2){
		return Item.getItemFromBlock(Registry.BlockAdvancedSmelterIdle);
	}
	
	public void onBlockAdded(World world, int x, int y, int z){
		super.onBlockAdded(world, x, y, z);
		this.setDefaultDirection(world, x, y, z);
	}
	
	private void setDefaultDirection(World world, int x, int y, int z){
		if(world.isRemote){
			Block var1 = world.getBlock(x, y, z - 1);
			Block var2 = world.getBlock(x, y, z + 1);
			Block var3 = world.getBlock(x - 1, y, z);
			Block var4 = world.getBlock(x + 1, y, z);
			byte var5 = 3;
			
			if(var1.func_149730_j() && !var2.func_149730_j()){
				var5 = 3;
			}
			
			if(var2.func_149730_j() && !var1.func_149730_j()){
				var5 = 2;
			}
			
			if(var3.func_149730_j() && !var4.func_149730_j()){
				var5 = 5;
			}
			
			if(var4.func_149730_j() && !var3.func_149730_j()){
				var5 = 4;
			}
			
			world.setBlockMetadataWithNotify(x, y, z, var5, 2);
		}
	}
	
	public IIcon getIcon(int side, int metadata){	
		return side == 1 ? this.iconFront : (side == 0 ? this.iconFront : (side == metadata ? this.blockIcon : this.iconTop));
	}
	
	public void registerBlockIcons(IIconRegister icon){
		this.blockIcon = icon.registerIcon("BlockAdvancedSmelter_Side");
		this.iconFront = icon.registerIcon(this.isActive ? "BlockAdvancedSmelter_Front_Active" : "BlockAdvancedSmelter_Front_Active");
		this.iconTop = icon.registerIcon("BlockAdvancedSmelter_Top");
	}
	
	public void randomTickDisplay(World world, int x, int y, int z, Random rand){
		if(this.isActive){
			int var6 = world.getBlockMetadata(x, y, z);
			float var7 = (float)x + 0.5F;
			float var8 = (float)y + 0.5F + rand.nextFloat() * 6.0F / 16.0F;
			float var9 = (float)z + 0.5F;
			float var10 = 0.52F;
			float var11 = rand.nextFloat() * 6.0F - 0.3F;
			
			if(var6 == 4){
				world.spawnParticle("smoke", (double)(var7 - var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", (double)(var7 - var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
			} else
				if(var6 == 5){
					world.spawnParticle("smoke", (double)(var7 + var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
					world.spawnParticle("flame", (double)(var7 + var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
				} else
					if(var6 == 2){
						world.spawnParticle("smoke", (double)(var7 + var11), (double)var8, (double)(var9 - var10), 0.0D, 0.0D, 0.0D);
						world.spawnParticle("flame", (double)(var7 + var11), (double)var8, (double)(var9 - var10), 0.0D, 0.0D, 0.0D);
					} else
						if(var6 == 3){
							world.spawnParticle("smoke", (double)(var7 + var11), (double)var8, (double)(var9 + var10), 0.0D, 0.0D, 0.0D);
							world.spawnParticle("flame", (double)(var7 + var11), (double)var8, (double)(var9 + var10), 0.0D, 0.0D, 0.0D);
						}
		}
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par1, float var2, float var3, float var4){
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		
		if(tileEntity == null || player.isSneaking()){
			return false;
		}
		player.openGui(VanillaPlus.instance, VanillaPlus.guiIDAdvancedSmelter, world, x, y, z);
		return true;
	}
	
	public static void changeBlock(boolean isActive, World world, int x, int y, int z){
		int var1 = world.getBlockMetadata(x, y, z);
		TileEntity var2 = world.getTileEntity(x, y, z);
		hasBlockChanged = true;
		
		if(isActive){
			world.setBlock(x, y, z, Registry.BlockAdvancedSmelterActive);
		} else {
			world.setBlock(x, y, z, Registry.BlockAdvancedSmelterIdle);
		}
		
		hasBlockChanged = false;
		world.setBlockMetadataWithNotify(x, y, z, var1, 2);
		
		if(var2 != null){
			var2.validate();
			world.setTileEntity(x, y, z, var2);
		}
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int var1) {
		return new TileEntityAdvancedSmelter();
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack){
		int var1 = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		
		if(var1 == 0){
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}
		
		if(var1 == 1){
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}
		
		if(var1 == 2){
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}
		
		if(var1 == 3){
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}
	}
	
	public void breakBlock(World world, int x, int y, int z, Block block, int par1){
		if(!hasBlockChanged){
			TileEntityAdvancedSmelter AdvSmelter = (TileEntityAdvancedSmelter)world.getTileEntity(x, y, z);
			
			if(AdvSmelter != null){
				for(int c = 0; c < AdvSmelter.getSizeInventory(); ++c){
					ItemStack stack = AdvSmelter.getStackInSlot(c);
					
					if(stack != null){
						float var1 = this.random.nextFloat() * 0.8F + 0.1F;
						float var2 = this.random.nextFloat() * 0.8F + 0.1F;
						float var3 = this.random.nextFloat() * 0.8F + 0.1F;
						
						while(stack.stackSize > 0){
							int var4 = this.random.nextInt(21) + 10;
							
							if(var4 > stack.stackSize){
								var4 = stack.stackSize;
							}
							
							stack.stackSize -= var4;
							EntityItem item = new EntityItem(world, (double)((float)x + var1), (double)((float)y + var2), (double)((float)z + var3), new ItemStack(stack.getItem(), var4, stack.getItemDamage()));
							
							if(stack.hasTagCompound()){
								item.getEntityItem().setTagCompound((NBTTagCompound) stack.getTagCompound().copy());
							}
							
							float var5 = 0.05F;
							item.motionX = (double)((float)this.random.nextGaussian() * var5);
							item.motionY = (double)((float)this.random.nextGaussian() * var5 + 0.2F);
							item.motionZ = (double)((float)this.random.nextGaussian() * var5);
							world.spawnEntityInWorld(item);
						}
					}
				}
				world.func_147453_f(x, y, z, block);
			}
		}
		super.breakBlock(world, x, y, z, block, par1);
	}
	
	public boolean hasComparatorInputOverride(){
		return true;
	}
	
	public int getComparatorInputOverride(World world, int x, int y, int z, int side){
		return Container.calcRedstoneFromInventory((IInventory) world.getTileEntity(x, y, z));
	}
	
	public Item getItem(World world, int x, int y, int z){
		return Item.getItemFromBlock(Registry.BlockAdvancedSmelterIdle);
	}
}
