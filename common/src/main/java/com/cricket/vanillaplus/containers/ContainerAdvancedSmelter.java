package com.cricket.vanillaplus.containers;

import com.cricket.vanillaplus.tiles.TileEntityAdvancedSmelter;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;

public class ContainerAdvancedSmelter extends Container{

private TileEntityAdvancedSmelter AdvancedSmelter;
	
	public int lastBurnTime;
	public int lastItemGrindTime;
	public int lastGrindingTime;
	
	public ContainerAdvancedSmelter(InventoryPlayer inventory, TileEntityAdvancedSmelter tileentity){
		this.AdvancedSmelter=tileentity;
		
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
		
		return this.AdvancedSmelter.isUseableByPlayer(entityplayer);
	}
	public void addCraftingToCrafters(ICrafting icrafting){
		super.addCraftingToCrafters(icrafting);
		icrafting.sendProgressBarUpdate(this, 0,this.AdvancedSmelter.smeltingTime);
		icrafting.sendProgressBarUpdate(this, 1,this.AdvancedSmelter.burnTime);
		icrafting.sendProgressBarUpdate(this, 2,this.AdvancedSmelter.currentItemSmeltingTime);
	}
	public void detectAndSendChanges(){
		super.detectAndSendChanges();
		for(int i=0;i<this.crafters.size();i++){
			ICrafting icrafting = (ICrafting) this.crafters.get(i);
			if(this.lastGrindingTime != this.AdvancedSmelter.smeltingTime){
				icrafting.sendProgressBarUpdate(this, 0, this.AdvancedSmelter.smeltingTime);
			}
			if(this.lastBurnTime != this.AdvancedSmelter.burnTime){
				icrafting.sendProgressBarUpdate(this, 1, this.AdvancedSmelter.burnTime);
			}
			if(this.lastItemGrindTime != this.AdvancedSmelter.smeltingTime){
				icrafting.sendProgressBarUpdate(this, 2, this.AdvancedSmelter.currentItemSmeltingTime);
			}
			this.lastBurnTime=this.AdvancedSmelter.burnTime;
			this.lastGrindingTime=this.AdvancedSmelter.smeltingTime;
			this.lastItemGrindTime=this.AdvancedSmelter.currentItemSmeltingTime;
		}
	}
	@SideOnly(Side.CLIENT)
	public void upgradeProgressBar(int slot, int par2){
		if(slot==0)this.AdvancedSmelter.smeltingTime=par2;
		if(slot==1)this.AdvancedSmelter.burnTime=par2;
		if(slot==2)this.AdvancedSmelter.currentItemSmeltingTime=par2;
	}
	public ItemStack transferStackInSlot(EntityPlayer player){
		return null;
	}

}
