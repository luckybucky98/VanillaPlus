package com.cricket.vanillaplus.blocks.decoration;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.cricket.vanillaplus.Registry;
import com.cricket.vanillaplus.creativetab.CreativeTab;
import com.cricket.vanillaplus.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockWaterInfusedDoor extends Block{
	
	@SideOnly(Side.CLIENT)
	private IIcon[] top;
	
	@SideOnly(Side.CLIENT)
	private IIcon[] bottom;

	public BlockWaterInfusedDoor(Material material) {
		super(material);
		float f = 0.5F;
		float f1 = 1.0F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){
		return this.bottom[0];
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(IBlockAccess access, int x, int y, int z, int meta){
		if(meta != 1 && meta != 0){
			int meta1 = this.getFullMetadata(access, x, y, z);
			int meta2 = meta1 & 3;
			boolean flag = (meta1 & 4) != 0;
			boolean flag1 = false;
			boolean flag2 = (meta1 & 8) != 0;
			
			if(flag){
				if (meta2 == 0 && meta == 2){
					flag1 = !flag1;
				} else if(meta2 == 1 && meta == 5){
					flag1 = !flag1;
				} else if(meta2 == 2 && meta == 1){
					flag1 = !flag1;
				} else if(meta2 == 3 && meta == 4){
					flag1 = !flag1;
				}
			} else {
				if(meta2 == 0 && meta == 5){
					flag1 = !flag1;
				} else if(meta2 == 1 && meta == 3){
					flag1 = !flag1;
				} else if(meta2 == 2 && meta == 4){
					flag1 = !flag1;
				} else if(meta2 == 3 && meta == 2){
					flag1 = !flag1;
				}
				
				if((meta1 & 16) != 0){
					flag1 = !flag1;
				}
			}
			
			return flag2 ? this.top[flag1 ? 1 : 0] : this.bottom[flag1 ? 1 : 0];
		} else {
			return this.bottom[0];
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon){
		this.top = new IIcon[2];
		this.bottom = new IIcon[2];
		this.top[0] = icon.registerIcon(Reference.MODID + ":BlockWaterInfusedDoorTop");
		this.bottom[0] = icon.registerIcon(Reference.MODID + ":BlockWaterInfusedDoorBottom");
		this.top[1] = new IconFlipped(this.top[0], true, false);
		this.bottom[1] = new IconFlipped(this.bottom[1], true, false);
	}
	
	public boolean isOpaqueCube(){
		return false;
	}
	
	public boolean getBlocksMovement(IBlockAccess access, int x, int y, int z){
		int metadata = this.getFullMetadata(access, x, y, z);
		return (metadata & 4) != 0;
	}
	
	public boolean renderAsNormalBlock(){
		return false;
	}
	
	public int getRenderType(){
		return 7;
	}
	
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z){
		this.setBlockBoundsBasedOnState(world, x, y, z);
		return super.getCollisionBoundingBoxFromPool(world, x, y, z);
	}
	
	public void setBlockBoundsBasedOnState(IBlockAccess access, int x, int y, int z){
		this.setBlockBounding(this.getFullMetadata(access, x, y, z));
	}
	
	public int func_150013_e(IBlockAccess access, int x, int y, int z){
		return this.getFullMetadata(access, x, y, z) & 3;
	}
	
	public boolean func_150015_f(IBlockAccess access, int x, int y, int z){
		return (this.getFullMetadata(access, x, y, z) & 4) != 0;
	}
	
	private void setBlockBounding(int meta){
		float f = 0.1875F;
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
		int c = meta & 3;
		boolean flag = (meta & 4) != 0;
		boolean flag1 = (meta & 16) != 0;
		
		if(c == 0){
			if(flag){
				if(!flag1){
					this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
				} else {
					this.setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
				}
			} else {
				this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
			}
		} else if(c == 1){
			if(flag){
				if(!flag){
					this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
				} else {
					this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				}
			} else {
				this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			}
		}
	}
	
	public boolean onBlockClicked(World world, int x, int y, int z, EntityPlayer player, int par, float x1, float y1, float z1){
		int metadata = this.getFullMetadata(world, x, y, z);
		int meta1 = metadata & 7;
		meta1 ^= 4;
		
		if((metadata & 8) == 0){
			world.setBlockMetadataWithNotify(x, y, z, meta1, 2);
			world.markBlockRangeForRenderUpdate(x, y, z, x, y, z);
		} else {
			world.setBlockMetadataWithNotify(x, y - 1, z, meta1, 2);
			world.markBlockRangeForRenderUpdate(x, y - 1, z, x, y, z);
		}
		
		world.playAuxSFXAtEntity(player, 1003, x, y, z, 0);
		return true;
	}
	
	public void func_150014_a(World world, int x, int y, int z, boolean par){
		int metadata = this.getFullMetadata(world, x, y, z);
		boolean flag = (metadata & 4) != 0;
		
		if(flag != par){
			int meta = metadata & 7;
			meta ^= 4;
			
			if((metadata & 8) == 0){
				world.setBlockMetadataWithNotify(x, y, z, meta, 2);
				world.markBlockRangeForRenderUpdate(x, y - 1, z, x, y, z);
			} else {
				world.setBlockMetadataWithNotify(x, y - 1, z, meta, 2);
				world.markBlockRangeForRenderUpdate(x, y - 1, z, x, y, z);
			}
			
			world.playAuxSFXAtEntity((EntityPlayer) null, 1003, x, y, z, 0);
		}
	}
	
	public void onNeighborBlockChange(World world, int x, int y, int z, Block neighbor){
		int metadata = world.getBlockMetadata(x, y, z);
		
		if((metadata & 8) == 0){
			boolean flag = false;
			
			if(world.getBlock(x, y + 1, z) != this){
				world.setBlockToAir(x, y, z);
				flag = true;
			}
			
			if(!World.doesBlockHaveSolidTopSurface(world, x, y - 1, z)){
				world.setBlockToAir(x, y, z);
				flag = true;
				
				if(world.getBlock(x, y + 1, z) == this){
					world.setBlockToAir(x, y + 1, z);
				}
			}
			
			if(flag){
				if(!world.isRemote){
					this.dropBlockAsItem(world, x, y, z, 1, 0);
				}
			} else {
				boolean flag1 = world.isBlockIndirectlyGettingPowered(x, y, z);
				
				if((flag1 || neighbor.canProvidePower()) && neighbor != this){
					this.func_150014_a(world, x, y, z, flag1);
				}
			}
		} else {
			if(world.getBlock(x, y - 1, z) != this){
				world.setBlockToAir(x, y, z);
			}
			
			if(neighbor != this){
				this.onNeighborBlockChange(world, x, y -1, z, neighbor);
			}
		}
	}
	
	public Item getItemDropped(int x, Random rand, int z){
		return (x & 8) != 0 ? null : Registry.ItemWaterInfusedDoor;
	}
	
	public MovingObjectPosition collisionRayTrace(World world, int x, int y, int z, Vec3 startVec, Vec3 endVec){
		this.setBlockBoundsBasedOnState(world, x, y, z);
		return super.collisionRayTrace(world, x, y, z, startVec, endVec);
	}
	
	public boolean canBlockBePlacedAt(World world, int x, int y, int z){
		return y >= world.getHeight() - 1 ? false : World.doesBlockHaveSolidTopSurface(world, x, y - 1, z) && super.canPlaceBlockAt(world, x, y, z) && super.canPlaceBlockAt(world, x, y + 1, z);
	}
	
	public int getMobilityFlag(){
		return 1;
	}
	
	public int getFullMetadata(IBlockAccess access, int x, int y, int z){
		int meta = access.getBlockMetadata(x, y, z);
		boolean flag = (meta & 8) != 0;
		int meta1;
		int meta2;
		
		if(flag){
			meta1 = access.getBlockMetadata(x, y, z);
			meta2 = meta;
		} else {
			meta1 = meta;
			meta2 = access.getBlockMetadata(x, y, z);
		}
		
		boolean flag1 = (meta2 & 1) != 0;
		return meta1 & 7 | (flag ? 8 : 0) | (flag1 ? 16 : 0);
	}
	
	@SideOnly(Side.CLIENT)
	public Item getItem(World world, int x, int y, int z){
		return Registry.ItemWaterInfusedDoor;
	}
	
	public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player){
		if(player.capabilities.isCreativeMode && (meta  & 8) != 0 && world.getBlock(x, y - 1, z) == this){
			world.setBlockToAir(x, y - 1, z);
		}
	}

}
