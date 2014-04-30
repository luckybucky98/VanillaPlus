package com.cricket.vanillaplus.tiles;

import com.cricket.vanillaplus.blocks.BlockRockCrusher;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityRockCrusher extends TileEntity implements ISidedInventory{

	private String localizedName;
	private ItemStack[] slots = new ItemStack[3];
	private static final int[] slots_top = new int[]{0};
	private static final int[] slots_sides = new int[]{1};
	private static final int[] slots_bottom = new int[]{2,1};
	public int crusherSpeed = 200;
	public int burnTime;
	public int currenttItemGrindingTime;
	public int grindingTime;
	
	public int getSizeInventory(){
		return this.slots.length;
	}
	
	public boolean isInvNameLocalized(){		
		return this.localizedName!=null && this.localizedName.length()>0;
	}
	
	public String getInvName(){
		return this.isInvNameLocalized() ? this.localizedName: "container.rockCrusher" ;
	}
	
	
	
	public void setGuiDisplayName(String displayName) {
		this.localizedName=displayName;
		
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return this.slots[i];
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		if(this.slots[i]!=null){
			ItemStack itemstack;
			if(this.slots[i].stackSize<=j){
				itemstack=this.slots[i];
				this.slots[i]=null;
				return itemstack;
			}else{
				itemstack=this.slots[i].splitStack(j);
				if(this.slots[i].stackSize==0){
					this.slots[i]=null;
				}
				return itemstack;
			}
		}
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		if(this.slots[i]!=null){
			ItemStack itemstack=this.slots[i];
			this.slots[i]=null;
			return itemstack;
		}
		return null;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		this.slots[i]=itemstack;
		if(itemstack!=null && itemstack.stackSize>this.getInventoryStackLimit()){
			itemstack.stackSize=this.getInventoryStackLimit();
		}
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord)!=this ? false : entityplayer.getDistanceSq((double)this.xCoord+0.5D, (double)this.yCoord+0.5D, (double)this.zCoord+0.5D)<=64.0D;
	}

	@Override
	public void openChest() {
		
	}

	@Override
	public void closeChest() {
		
	}
	
	public boolean isGrinding(){
		return this.burnTime>0;
	}
	
	private boolean canGrind(){
		if(this.slots[0] == null){
			return false;
		}else{
			ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.slots[0]);
			
			if(itemstack == null) return false;
			if(this.slots[2] == null) return true;
			if(!this.slots[2].isItemEqual(itemstack)) return false;
			
			int result = this.slots[2].stackSize+itemstack.stackSize;
			
			return (result<=getInventoryStackLimit()&&result<=itemstack.getMaxStackSize());
		}
	}
	private void grindItem(){
		if(this.canGrind()){
			ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.slots[0]);
			if(this.slots[2]==null){
				this.slots[2]=itemstack.copy();
			}else if(this.slots[2].isItemEqual(itemstack)){
				this.slots[2].stackSize+=itemstack.stackSize;
			}
			this.slots[0].stackSize--;
			
			if(this.slots[0].stackSize<=0){
				this.slots[0]=null;
			}
		}
	}
	public void updateEntity(){
		boolean flag = this.burnTime >0;
		boolean flag1 = false;
		
		if(this.burnTime>0){
			this.burnTime--;
		}
		
		if(!this.worldObj.isRemote){
			if(this.burnTime==0 && this.canGrind()){
				this.currenttItemGrindingTime = this.burnTime = getItemGrindTime(this.slots[1]);
				if(this.burnTime>0){
					flag1=true;
					if(this.slots[1] !=null){
						this.slots[1].stackSize--;
						if(this.slots[1].stackSize == 0){
							this.slots[1] = this.slots[1].getItem().getContainerItemStack(this.slots[1]);
						}
					}
				}
			}
			
			if(this.isGrinding()&&canGrind()){
				this.grindingTime++;
				
				if(this.grindingTime == this.crusherSpeed){
					this.grindingTime=0;
					this.grindItem();
					flag1=true;
				}
			}else{
				this.grindingTime=0;
			}
			
			if(flag!=this.burnTime>0){
				flag1=true;
				BlockRockCrusher.updateRockCrusherBlockState(this.burnTime>0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			}
		}
		if(flag1){
			this.onInventoryChanged();
		}
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return i==2 ? false : (i==1 ? isItemFuel(itemstack):true);
	}

	private boolean isItemFuel(ItemStack itemstack) {
		return getItemGrindTime(itemstack)>0;
	}

	private int getItemGrindTime(ItemStack itemstack) {
		if(itemstack==null){
			return 0;
		}else{
			int i=itemstack.itemID;
			Item item = itemstack.getItem();
			
			if(item instanceof ItemBlock  && Block.blocksList[i] !=null){
				Block block = Block.blocksList[i];
				if(block==Block.woodSingleSlab){
					return 150;
				}
				if(block.blockMaterial==Material.wood){
					return 300;
				}
				if(block == block.coalBlock){
					return 16000;
				}
			}
			
			if(item instanceof ItemTool &&((ItemTool)item).getToolMaterialName().equals("WOOD")) return 200;
			if(item instanceof ItemSword &&((ItemSword)item).getToolMaterialName().equals("WOOD"))return 200;
			if(item instanceof ItemHoe && ((ItemHoe)item).getMaterialName().equals("WOOD"))return 200;
			if(i==Item.stick.itemID) return 100;
			if(i==Item.coal.itemID) return 1600;
			if(i==Item.bucketLava.itemID)return 20000;
			if(i==Item.blazeRod.itemID)return 2400;
			if(i==Block.sapling.blockID)return 100;
			
			
			return GameRegistry.getFuelValue(itemstack);
		}
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		return var1==0 ? slots_bottom : (var1==1 ? slots_top : slots_sides);
	}

	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
		return this.isItemValidForSlot(i, itemstack);
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		return j!=0 || i!=1 || itemstack.itemID==Item.bucketEmpty.itemID;
	}

}
