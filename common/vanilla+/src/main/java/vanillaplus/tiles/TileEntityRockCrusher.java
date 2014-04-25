package com.cricket.vanillaplus.tiles;

import net.minecraft.tileentity.TileEntity;

public class TileEntityRockCrusher extends TileEntity {

	private String localizedName;
	
	public void setGuiDisplayName(String displayName) {
		this.localizedName=displayName;
		
	}

}
