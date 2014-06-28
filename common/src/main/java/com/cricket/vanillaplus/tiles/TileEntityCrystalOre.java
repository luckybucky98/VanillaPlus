package com.cricket.vanillaplus.tiles;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCrystalOre extends TileEntity{
	
	public short orientation;
	
	public TileEntityCrystalOre(){
		this.orientation = 1;
	}
	
	public boolean canUpdate(){
		return false;
	}
	
	public void readCustomNBT(NBTTagCompound nbt){
		this.orientation = nbt.getShort("orientation");
	}
	
	public void writeCustomNBT(NBTTagCompound nbt){
		nbt.setShort("orientation", this.orientation);
	}

}
