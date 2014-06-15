package com.cricket.vanillaplus.tiles;

import com.cricket.vanillaplus.blocks.BlockRockCrusher;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityRockCrusher extends TileEntity implements ISidedInventory{

	
	private static final int[] slotsTop = new int[] {0};
    private static final int[] slotsBottom = new int[] {2, 1};
    private static final int[] slotsSides = new int[] {1};
    private ItemStack[] itemStack = new ItemStack[3];
    public int furnaceBurnTime;
    public int currentBurnTime;
    public int furnaceCookTime;
    private String stringName;

    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory()
    {
        return this.itemStack.length;
    }

    /**
     * Returns the  in slot i
     */
    @Override
    public ItemStack getStackInSlot(int slot)
    {
        return this.itemStack[slot];
    }

    /**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new .
     */
    @Override
    public ItemStack decrStackSize(int slot, int size)
    {
        if (this.itemStack[slot] != null)
        {
            ItemStack var3;

            if (this.itemStack[slot].stackSize <= size)
            {
                var3 = this.itemStack[slot];
                this.itemStack[slot] = null;
                return var3;
            }
            else
            {
                var3 = this.itemStack[slot].splitStack(size);

                if (this.itemStack[slot].stackSize == 0)
                {
                    this.itemStack[slot] = null;
                }

                return var3;
            }
        }
        else
        {
            return null;
        }
    }

    /**
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     */
    @Override
    public ItemStack getStackInSlotOnClosing(int slot)
    {
        if (this.itemStack[slot] != null)
        {
            ItemStack var2 = this.itemStack[slot];
            this.itemStack[slot] = null;
            return var2;
        }
        else
        {
            return null;
        }
    }

    /**
     * Sets the given item  to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setInventorySlotContents(int slot, ItemStack stack)
    {
        this.itemStack[slot] = stack;

        if (stack != null && stack.stackSize > this.getInventoryStackLimit())
        {
            stack.stackSize = this.getInventoryStackLimit();
        }
    }

    /**
     * Returns the name of the inventory
     */
    @Override
    public String getInventoryName()
    {
        return this.isInventoryNameLocalized() ? this.stringName : "container.rockCrusher";
    }

    /**
     * Returns if the inventory name is localized
     */
    public boolean isInventoryNameLocalized()
    {
        return this.stringName != null && this.stringName.length() > 0;
    }

    public void setInventoryName(String name)
    {
        this.stringName = name;
    }

    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        NBTTagList var2 = nbt.getTagList("Items", 10);
        this.itemStack = new ItemStack[this.getSizeInventory()];

        for (int var3 = 0; var3 < var2.tagCount(); ++var3)
        {
            NBTTagCompound var4 = var2.getCompoundTagAt(var3);
            byte var5 = var4.getByte("Slot");

            if (var5 >= 0 && var5 < this.itemStack.length)
            {
                this.itemStack[var5] = ItemStack.loadItemStackFromNBT(var4);
            }
        }

        this.furnaceBurnTime = nbt.getShort("BurnTime");
        this.furnaceCookTime = nbt.getShort("CookTime");
        this.currentBurnTime = isItemFuel(this.itemStack[1]);

        if (nbt.hasKey("Rock Crusher", 8))
        {
            this.stringName = nbt.getString("Rock Crusher");
        }
    }

    public void writeToNBT(NBTTagCompound p_145841_1_)
    {
        super.writeToNBT(p_145841_1_);
        p_145841_1_.setShort("BurnTime", (short)this.furnaceBurnTime);
        p_145841_1_.setShort("CookTime", (short)this.furnaceCookTime);
        NBTTagList var2 = new NBTTagList();

        for (int var3 = 0; var3 < this.itemStack.length; ++var3)
        {
            if (this.itemStack[var3] != null)
            {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte)var3);
                this.itemStack[var3].writeToNBT(var4);
                var2.appendTag(var4);
            }
        }

        p_145841_1_.setTag("Items", var2);

        if (this.isInventoryNameLocalized())
        {
            p_145841_1_.setString("CustomName", this.stringName);
        }
    }

    /**
     * Returns the maximum  size for a inventory slot.
     */
    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }
    
    @SideOnly(Side.CLIENT)
    public int getCookProgressScaled(int par1)
    {
        return this.furnaceCookTime * par1 / 200;
    }
    
    @SideOnly(Side.CLIENT)
    public int getBurnTimeRemainingScaled(int par1)
    {
        if (this.currentBurnTime == 0)
        {
            this.currentBurnTime = 200;
        }

        return this.furnaceBurnTime * par1 / this.currentBurnTime;
    }

    public boolean isBurning()
    {
        return this.furnaceBurnTime > 0;
    }

    public void updateEntity()
    {
        boolean var1 = this.furnaceBurnTime > 0;
        boolean var2 = false;

        if (this.furnaceBurnTime > 0)
        {
            --this.furnaceBurnTime;
        }

        if (!this.worldObj.isRemote)
        {
            if (this.furnaceBurnTime == 0 && this.canSmelt())
            {
                this.currentBurnTime = this.furnaceBurnTime = isItemFuel(this.itemStack[1]);

                if (this.furnaceBurnTime > 0)
                {
                    var2 = true;

                    if (this.itemStack[1] != null)
                    {
                        --this.itemStack[1].stackSize;

                        if (this.itemStack[1].stackSize == 0)
                        {
                            Item var3 = this.itemStack[1].getItem().getContainerItem();
                            this.itemStack[1] = var3 != null ? new ItemStack(var3) : null;
                        }
                    }
                }
            }

            if (this.isBurning() && this.canSmelt())
            {
                ++this.furnaceCookTime;

                if (this.furnaceCookTime == 200)
                {
                    this.furnaceCookTime = 0;
                    this.smeltItem();
                    var2 = true;
                }
            }
            else
            {
                this.furnaceCookTime = 0;
            }

            if (var1 != this.furnaceBurnTime > 0)
            {
                var2 = true;
                BlockRockCrusher.func_149931_a(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }

        if (var2)
        {
            //this.onInventoryChanged();
        }
    }

    private boolean canSmelt()
    {
        if (this.itemStack[0] == null)
        {
            return false;
        }
        else
        {
            ItemStack var1 = FurnaceRecipes.smelting().getSmeltingResult(this.itemStack[0]);
            return var1 == null ? false : (this.itemStack[2] == null ? true : (!this.itemStack[2].isItemEqual(var1) ? false : (this.itemStack[2].stackSize < this.getInventoryStackLimit() && this.itemStack[2].stackSize < this.itemStack[2].getMaxStackSize() ? true : this.itemStack[2].stackSize < var1.getMaxStackSize())));
        }
    }

    public void smeltItem()
    {
        if (this.canSmelt())
        {
            ItemStack var1 = FurnaceRecipes.smelting().getSmeltingResult(this.itemStack[0]);

            if (this.itemStack[2] == null)
            {
                this.itemStack[2] = var1.copy();
            }
            else if (this.itemStack[2].getItem() == var1.getItem())
            {
                ++this.itemStack[2].stackSize;
            }

            --this.itemStack[0].stackSize;

            if (this.itemStack[0].stackSize <= 0)
            {
                this.itemStack[0] = null;
            }
        }
    }

    public static int isItemFuel(ItemStack stack)
    {
        if (stack == null)
        {
            return 0;
        }
        else
        {
            Item var1 = stack.getItem();

            if (var1 instanceof ItemBlock && Block.getBlockFromItem(var1) != Blocks.air)
            {
                Block var2 = Block.getBlockFromItem(var1);

                if (var2 == Blocks.wooden_slab)
                {
                    return 150;
                }

                if (var2.getMaterial() == Material.wood)
                {
                    return 300;
                }

                if (var2 == Blocks.coal_block)
                {
                    return 16000;
                }
            }

            return var1 instanceof ItemTool && ((ItemTool)var1).getToolMaterialName().equals("WOOD") ? 200 : (var1 instanceof ItemSword && ((ItemSword)var1).getToolMaterialName().equals("WOOD") ? 200 : (var1 instanceof ItemHoe && ((ItemHoe)var1).getToolMaterialName().equals("WOOD") ? 200 : (var1 == Items.stick ? 100 : (var1 == Items.coal ? 1600 : (var1 == Items.lava_bucket ? 20000 : (var1 == Item.getItemFromBlock(Blocks.sapling) ? 100 : (var1 == Items.blaze_rod ? 2400 : 0)))))));
        }
    }

    public static boolean isBurning(ItemStack stack)
    {
        return isItemFuel(stack) > 0;
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer player)
    {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    public void openInventory() {}

    public void closeInventory() {}

    /**
     * Returns true if automation is allowed to insert the given  (ignoring  size) into the given slot.
     */
    public boolean isItemValidForSlot(int slot, ItemStack stack)
    {
        return slot == 2 ? false : (slot == 1 ? isBurning(stack) : true);
    }

    /**
     * Returns an array containing the indices of the slots that can be accessed by automation on the given side of this
     * block.
     */
    public int[] getAccessibleSlotsFromSide(int side)
    {
        return side == 0 ? slotsBottom : (side == 1 ? slotsTop : slotsSides);
    }

    /**
     * Returns true if automation can insert the given item in the given slot from the given side. Args: Slot, item,
     * side
     */
    public boolean canInsertItem(int slot, ItemStack stack, int side)
    {
        return this.isItemValidForSlot(slot, stack);
    }

    /**
     * Returns true if automation can extract the given item in the given slot from the given side. Args: Slot, item,
     * side
     */
    public boolean canExtractItem(int slot, ItemStack item, int side)
    {
        return side != 0 || slot != 1 || item.getItem() == Items.bucket;
    }
	@Override
	public boolean hasCustomInventoryName() {
		return true;
	}
}
