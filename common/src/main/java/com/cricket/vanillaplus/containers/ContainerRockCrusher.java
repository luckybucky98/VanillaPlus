package com.cricket.vanillaplus.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

import com.cricket.vanillaplus.tiles.TileEntityRockCrusher;

public class ContainerRockCrusher extends Container{
	
	private TileEntityRockCrusher rockCrusher;
	private int lastCookTime;
	private int lastBurnTime;
	private int lastItemBurnTime;

	public ContainerRockCrusher(InventoryPlayer inv, TileEntityRockCrusher crusher){
		this.rockCrusher = crusher;
		this.addSlotToContainer(new Slot(crusher, 0, 56, 17));
		this.addSlotToContainer(new Slot(crusher, 1, 56, 53));
		this.addSlotToContainer(new SlotFurnace(inv.player, crusher, 2, 116, 35));
		int column;
		
		for(column = 0; column < 3 ; ++column){
			for(int row = 0; row < 9; ++row){
				this.addSlotToContainer(new Slot(inv, row + column * 9 + 9, 8 + row * 18, 84 + column * 18));
			}
		}
		
		for(column = 0; column < 9; ++column){
			this.addSlotToContainer(new Slot(inv, column, 8 + column * 18, 142));
		}
	}
	
	@Override
	public void addCraftingToCrafters(ICrafting crafting){
		super.addCraftingToCrafters(crafting);
		crafting.sendProgressBarUpdate(this, 0, this.rockCrusher.furnaceCookTime);
		crafting.sendProgressBarUpdate(this, 1, this.rockCrusher.furnaceBurnTime);
		crafting.sendProgressBarUpdate(this, 2, this.rockCrusher.currentBurnTime);
	}
	
	/**
	 * Looks for changes made in the container and sends them to listeners
	 */
	@Override
	public void detectAndSendChanges(){
		super.detectAndSendChanges();
		
		for(int c = 0; c < this.crafters.size(); ++c){
			ICrafting crafting = (ICrafting)this.crafters.get(c);
			
			if(this.lastCookTime != this.rockCrusher.furnaceCookTime){
				crafting.sendProgressBarUpdate(this, 0, this.rockCrusher.furnaceCookTime);
			}
			
			if(this.lastBurnTime != this.rockCrusher.furnaceBurnTime){
				crafting.sendProgressBarUpdate(this, 1, this.rockCrusher.furnaceBurnTime);
			}
			
			if(this.lastItemBurnTime != this.rockCrusher.currentBurnTime){
				crafting.sendProgressBarUpdate(this, 2, this.rockCrusher.currentBurnTime);
			}
		}
		
		this.lastCookTime = this.rockCrusher.furnaceCookTime;
		this.lastBurnTime = this.rockCrusher.furnaceBurnTime;
		this.lastItemBurnTime = this.rockCrusher.currentBurnTime;
	}
	
	@Override
	public void updateProgressBar(int slot, int par2){
		if(slot == 0){
			this.rockCrusher.furnaceCookTime = par2;
		}
		
		if(slot == 1){
			this.rockCrusher.furnaceBurnTime = par2;
		}
		
		if(slot == 2){
			this.rockCrusher.currentBurnTime = par2;
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return rockCrusher.isUseableByPlayer(player);
	}
	
	/**
	 * Called when a player shift clicks on a slot. This must be overrided.
	 */
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int inSlot){
		ItemStack stack = null;
		Slot slot = (Slot)this.inventorySlots.get(inSlot);
		
		if(slot != null && slot.getHasStack()){
			ItemStack stack2 = slot.getStack();
			stack = stack2.copy();
			
			if(inSlot == 2){
				if(!this.mergeItemStack(stack2, 3, 39, true)){
					return null;
				}
				
				slot.onSlotChange(stack2, stack);
			} else if(inSlot != 1 && inSlot != 0){
				if(FurnaceRecipes.smelting().getSmeltingResult(stack2) != null){
					if(!this.mergeItemStack(stack2, 0, 1, false)){
						return null;
					}
				} else if(TileEntityRockCrusher.isBurning(stack2)){
					if(!this.mergeItemStack(stack2, 1, 2, false)){
						return null;
					}
				} else if(inSlot >= 3 && inSlot <= 30){
					if(!this.mergeItemStack(stack2, 30, 39, false)){
						return null;
					}
				} else if(inSlot >= 30 && inSlot < 39 && !this.mergeItemStack(stack2, 3, 30, false)){
					return null;
				}
			} else if(!this.mergeItemStack(stack2, 3, 39, false)){
				return null;
			}
			
			if(stack2.stackSize == 0){
				slot.putStack((ItemStack)null);
			} else {
				slot.onSlotChanged();
			}
			
			if(stack2.stackSize == stack.stackSize){
				return null;
			}
			
			slot.onPickupFromSlot(player, stack2);
		}
		return stack;
	}
}
