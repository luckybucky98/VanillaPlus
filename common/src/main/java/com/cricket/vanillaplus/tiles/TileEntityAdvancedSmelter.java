package com.cricket.vanillaplus.tiles;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;

import com.cricket.vanillaplus.blocks.BlockAdvancedSmelter;

public class TileEntityAdvancedSmelter extends TileEntityFurnace implements ISidedInventory{

	/*private static final int[] k = new int[] {0};
	private static final int[] l = new int[] {2, 1};
	private static final int[] m = new int[] {1};
	private ItemStack[] slots = new ItemStack[3];
	public int a;
	public int i;
	public int j;
	private String o;
	
	public int getSizeInventory(){
		return this.slots.length;
	}
	
	public ItemStack getStackInSlot(int slot){
		return this.slots[slot];
	}
	
	public ItemStack decrStackSize(int slot, int ammount){
		if(this.slots[slot] != null){
			ItemStack stack;
			
			if(this.slots[slot].stackSize <= ammount){
				stack = this.slots[slot];
				this.slots[slot] = null;
				return stack;
			} else {
				stack = this.slots[slot].splitStack(ammount);
				
				if(this.slots[slot].stackSize == 0){
					this.slots[slot] = null;
				}
				
				return stack;
			}
		} else {
			return null;
		}
	}
	
	public ItemStack getStackInSlotOnClosing(int slot){
		if(this.slots[slot] != null){
			ItemStack stack = this.slots[slot];
			this.slots[slot] = null;
			return stack;
		} else {
			return null;
		}
	}
	
	public void setInventorySlotContents(int slot, ItemStack stack){
		this.slots[slot] = stack;
		
		if(stack != null && stack.stackSize > this.getInventoryStackLimit()){
			stack.stackSize = this.getInventoryStackLimit();
		}
	}
	
	public String getInventoryName(){
		return this.isInventoryNameLocalized() ? this.o : "container.furnace";
	}
	
	public boolean isInventoryNameLocalized(){
		return this.o != null && this.o.length() > 0;
	}
	
	public void getLocalizedName(String name){
		this.o = name;
	}
	
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		NBTTagList tagList = compound.getTagList("Items", 10);
		this.slots = new ItemStack[this.getSizeInventory()];
		
		for(int c = 0; c < tagList.tagCount(); ++c){
			NBTTagCompound nbt = tagList.getCompoundTagAt(c);
			byte slotID = nbt.getByte("Slot");
			
			if(slotID >= 0 && slotID < this.slots.length){
				this.slots[slotID] = ItemStack.loadItemStackFromNBT(nbt);
			}
		}
		
		this.a = compound.getShort("BurnTime");
		this.j = compound.getShort("CookTime");
		this.i = func_14592_a(this.slots[1]);
		
		if(compound.hasKey("AdvancedSmelter", 8)){
			this.o = compound.getString("AdvancedSmelter");
		}
	}
	
	public void writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		compound.setShort("BurnTime", (short)this.a);
		compound.setShort("CookTime", (short)this.j);
		NBTTagList tagList = new NBTTagList();
		
		for(int c = 0; c < this.slots.length; ++c){
			if(this.slots[c] != null){
				NBTTagCompound nbt = new NBTTagCompound();
				nbt.setByte("Slot", (byte) c);
				this.slots[c].writeToNBT(nbt);
				tagList.appendTag(nbt);
			}
		}
		
		compound.setTag("Items", tagList);
		
		if(this.isInventoryNameLocalized()){
			compound.setString("AdvancedSmelter", this.o);
		}
	}
	
	public int getInventoryStackLimit(){
		return 64;
	}
	
	public int func_145953_d(int par1){
		return this.j * par1 / 200;
	}
	
	public int func_145955_e(int par1){
		if(this.i == 0){
			this.i = 200;
		}
		
		return this.a * par1 / this.i;
	}
	
	public boolean func_145950_i(){
		return this.a > 0;
	}
	
	public void updateEntity(){
		boolean var1 = this.a > 0;
		boolean var2 = false;
		
		if(this.a > 0){
			--this.a;
		}
		
		if(this.worldObj.isRemote){
			if(this.a == 0 && this.func_145956_k()){
				this.i = this.a = func_145952_a(this.slots[1]);
				
				if(this.a > 0){
					var2 = true;
					
					if(this.slots[1] != null){
						--this.slots[1].stackSize;
						
						if(this.slots[1].stackSize == 0){
							Item item = this.slots[1].getItem().getContainerItem();
							this.slots[1] = item != null ? new ItemStack(item) : null;
						}
					}
				}
			}
			
			if(this.func_145950_i() && this.func_145948_k()){
				++this.j;
				
				if(this.j == 200){
					this.j = 0;
					this.func_145949_j();
					var2 = true;
				}
			} else {
				this.j = 0;
			}
			
			if(var1 != this.a > 0){
				var2 = true;
				BlockAdvancedSmelter.changeBlock(this.a>0, this.worldObj, xCoord, yCoord, zCoord);
			}
		}
		
		if(var2){
			this.onInventoryChanged();
		}
	}
	
	private boolean func_145948_k(){
		if(this.slots[0] == null){
			return false;
		} else {
			ItemStack stack = FurnaceRecipes.smelting().getSmeltingResult(this.slots[0]);
			return stack == null ? false : (this.slots[2] == null ? true : (!this.slots[2].isItemEqual(stack) ? false : (this.slots[2].stackSize < this.getInventoryStackLimit() && this.slots[2].stackSize < this.slots[2].getMaxStackSize() ? true : this.slots[2].stackSize < stack.getMaxStackSize())));
		}
	}
	
	public void func_145949_j(){
		if(this.func_145948_k()){
			ItemStack stack = FurnaceRecipes.smelting().getSmeltingResult(this.slots[0]);
			
			if(this.slots[2] == null){
				this.slots[2] = stack.copy();
			} else if(this.slots[2].getItem() == stack.getItem()){
				++this.slots[2].stackSize;
			}
			
			--this.slots[0].stackSize;
			
			if(this.slots[0].stackSize <= 0){
				this.slots[0] = null;
			}
		}
	}

	private static int func_145952_a(ItemStack itemStack) {
		if(itemStack == null){
			return 0;
		} else {
			Item item = itemStack.getItem();
			
			if(item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air){
				Block block = Block.getBlockFromItem(item);
				
				if(block == Blocks.wooden_slab){
					return 150;
				}
				
				if(block.getMaterial() == Material.wood){
					return 300;
				}
				
				if(block == Blocks.coal_block){
					return 16000;
				}
			}
			
			return item instanceof ItemTool && ((ItemTool)item).getToolMaterialName().equals("WOOD") ? 200 : (item instanceof ItemSword && ((ItemSword) item).getToolMaterialName().equals("WOOD") ? 200 : (item instanceof ItemHoe && ((ItemHoe)item).getToolMaterialName().equals("WOOD") ? 200 : (item == Items.stick ? 100 : (item == Items.coal ? 1600 : (item == Items.lava_bucket ? 20000 : (item == Item.getItemFromBlock(Blocks.sapling) ? 100 : (item == Items.blaze_rod ? 2400 : 0)))))));
		}
	}
	
	public static boolean func_145954_b(ItemStack stack){
		return func_145952_a(stack) > 0;
	}
	
	public boolean isUseableByPlayer(EntityPlayer player){
		return this.worldObj.getTileEntity(xCoord, yCoord, zCoord) != this ? false : player.getDistanceSq((double)xCoord + 0.5D,  (double)yCoord + 0.5D,  (double)zCoord + 0.5D) <= 64.0D;
	}
	
	public void openInventory(){}
	public void closeInventory(){}
	
	public boolean isItemValidForSlot(int slot, ItemStack stack){
		return slot == 2 ? false : (slot == 1 ? func_145954_b(stack) : true);
	}
	
	public int[] getAccessibleSlotsFromSide(int slot){
		return slot == 0 ? l : (slot == 1 ? k : m);
	}
	
	public boolean canInsertItem(int slot, ItemStack stack, int ammount){
		return this.isItemValidForSlot(slot, stack);
	}
	
	public boolean canExtractItem(int slot, ItemStack stack, int ammount){
		return ammount != 0 || slot != 1 || stack.getItem() == Items.bucket;
	}

	@Override
	public boolean hasCustomInventoryName() {
		// TODO Auto-generated method stub
		return false;
	}*/
}
