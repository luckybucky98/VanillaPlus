package com.cricket.vanillaplus.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;

import com.cricket.vanillaplus.tiles.TileEntityRockCrusher;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerRockCrusher extends Container{
	
	private TileEntityRockCrusher rockCrusher;
	
	public int lastBurnTime;
	public int lastItemGrindTime;
	public int lastGrindingTime;
	
	public ContainerRockCrusher(InventoryPlayer inventory, TileEntityRockCrusher tileentity){
		this.rockCrusher=tileentity;
		
		this.addSlotToContainer(new Slot(tileentity, 0,56,17));
		this.addSlotToContainer(new Slot(tileentity, 1,56,53));
		this.addSlotToContainer(new SlotFurnace(inventory.player, tileentity, 2,116,35));
		
		for(int i=0;i<3;i++){
			for(int j=0;j<9;j++){
				this.addSlotToContainer(new Slot(inventory,j+i*9+9,8+j*18,84+i*18));
			}
		}
		for(int i=0;i<9;i++){
			this.addSlotToContainer(new Slot(inventory,i,8+18*i,142));
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer){
		
		return this.rockCrusher.isUseableByPlayer(entityplayer);
	}
	public void addCraftingToCrafters(ICrafting icrafting){
		super.addCraftingToCrafters(icrafting);
		icrafting.sendProgressBarUpdate(this, 0,this.rockCrusher.grindingTime);
		icrafting.sendProgressBarUpdate(this, 1,this.rockCrusher.burnTime);
		icrafting.sendProgressBarUpdate(this, 2,this.rockCrusher.currenttItemGrindingTime);
	}
	public void detectAndSendChanges(){
		super.detectAndSendChanges();
		for(int i=0;i<this.crafters.size();i++){
			ICrafting icrafting = (ICrafting) this.crafters.get(i);
			if(this.lastGrindingTime != this.rockCrusher.grindingTime){
				icrafting.sendProgressBarUpdate(this, 0, this.rockCrusher.grindingTime);
			}
			if(this.lastBurnTime != this.rockCrusher.burnTime){
				icrafting.sendProgressBarUpdate(this, 1, this.rockCrusher.burnTime);
			}
			if(this.lastItemGrindTime != this.rockCrusher.grindingTime){
				icrafting.sendProgressBarUpdate(this, 2, this.rockCrusher.currenttItemGrindingTime);
			}
			this.lastBurnTime=this.rockCrusher.burnTime;
			this.lastGrindingTime=this.rockCrusher.grindingTime;
			this.lastItemGrindTime=this.rockCrusher.currenttItemGrindingTime;
		}
	}
	@SideOnly(Side.CLIENT)
	public void upgradeProgressBar(int slot, int par2){
		if(slot==0)this.rockCrusher.grindingTime=par2;
		if(slot==1)this.rockCrusher.burnTime=par2;
		if(slot==2)this.rockCrusher.currenttItemGrindingTime=par2;
	}
	public ItemStack transferStackInSlot(EntityPlayer player){
		return null;
	}

}
