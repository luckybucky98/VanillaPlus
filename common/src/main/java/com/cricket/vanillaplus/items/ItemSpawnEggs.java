package com.cricket.vanillaplus.items;

import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.Facing;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import com.cricket.vanillaplus.creativetab.CreativeTab;

public class ItemSpawnEggs extends Item{

	private Icon iconIndex;
	
	public ItemSpawnEggs(int id) {
		super(id);
		this.setMaxStackSize(64);
		this.setHasSubtypes(true);
		this.setCreativeTab(CreativeTab.VANILLAPLUS_TAB);
	}
	public String getItemDisplayName(ItemStack stack){
		String displayName1 = ("" + StatCollector.translateToLocal(this.getUnlocalizedName() + ".name")).trim();
		String displayName2 = EntityList.getStringFromID(stack.getItemDamage());
		
		if(displayName2 != null){
			displayName1 = displayName1 + " " + StatCollector.translateToLocal("entity." + displayName2 + ".name");
		}
		return displayName1;
	}
	
	public int getColorFromItemStack(ItemStack stack, int color){
		EntityEggInfo displayName2 = (EntityEggInfo)EntityList.entityEggs.get(Integer.valueOf(stack.getItemDamage()));
		return displayName2 != null ? (color == 0 ? displayName2.primaryColor : displayName2.secondaryColor) : 16777215;
	}
	public boolean requiresMultipleRenderPasses(){
		return true;
	}
	
	public Icon getIconFromDamageForRenderPass(int par1, int par2){
		return par2 > 0 ? this.iconIndex : super.getIconFromDamageForRenderPass(par1, par2);
	}
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10){
		if(world.isRemote){
			return true;
		} else {
			int var11 = world.getBlockId(x,y,z);
			x += Facing.offsetsXForSide[par7];
			y += Facing.offsetsYForSide[par7];
			z += Facing.offsetsZForSide[par7];
			double var12 = 0.0D;
			if(par7 == 1 && Block.blocksList[var11] != null && Block.blocksList[var11].getRenderType()== 11){
				var12 = 0.5D;
			}
		}
		return false;
	}
	
	public ItemStack onRightClick(ItemStack stack, World world, EntityPlayer player){
		if(world.isRemote){
			return stack;
		} else {
			MovingObjectPosition var1 = this.getMovingObjectPositionFromPlayer(world, player, true);
			
			if(var1 == null){
				return stack;
			} else {
				if(var1.typeOfHit == EnumMovingObjectType.TILE){
					int var2 = var1.blockX;
					int var3 = var1.blockY;
					int var4 = var1.blockZ;
					
					if(!world.canMineBlock(player, var2, var3, var4)){
						return stack;
					}
					
					if(world.getBlockMaterial(var2, var3, var4) == Material.water){
						Entity var5 = spawnCreature(world, stack.getItemDamage(), (double)var2, (double)var3, (double)var3);
						
						if(var5 != null){
							if(var5 instanceof EntityLivingBase && stack.hasDisplayName()){
								((EntityLiving)var5).setCustomNameTag(stack.getDisplayName());
							}
							
							if(!player.capabilities.isCreativeMode){
								--stack.stackSize;
							}
						}
					}
				}
				return stack;
			}
		}
	}
	
	public static Entity spawnCreature(World world, int par1, double x, double y, double z){
		if(!EntityList.entityEggs.containsKey(Integer.valueOf(par1))){
			return null;
		} else {
			Entity entity = null;
			for(int c=0;c<1;++c){
				entity = EntityList.createEntityByID(par1, world);
				if(entity != null && entity instanceof EntityLivingBase){
					EntityLiving entityLiving = (EntityLiving)entity;
					entity.setLocationAndAngles(x, y, z, MathHelper.wrapAngleTo180_float(world.rand.nextFloat()*360.F), 0.0F);
					entityLiving.rotationYawHead = entityLiving.rotationYaw;
					entityLiving.renderYawOffset = entityLiving.rotationYaw;
					entityLiving.onSpawnWithEgg((EntityLivingData)null);
					world.spawnEntityInWorld(entity);
					entityLiving.playLivingSound();
				}
			}
			return entity;
		}
	}
	public void getSubItems(int par1, CreativeTabs tab, List list){
		Iterator var4 = EntityList.entityEggs.values().iterator();
		
		while(var4.hasNext()){
			EntityEggInfo var5 = (EntityEggInfo)var4.next();
			list.add(new ItemStack(par1, 1, var5.spawnedID));
		}
	}
	public void registerIcons (IconRegister reg){
		super.registerIcons(reg);
		this.iconIndex = reg.registerIcon(this.getIconString()+"_overlay");
	}
}
