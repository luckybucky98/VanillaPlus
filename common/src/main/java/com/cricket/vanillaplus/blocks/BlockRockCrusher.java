package com.cricket.vanillaplus.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.cricket.vanillaplus.Registry;
import com.cricket.vanillaplus.VanillaPlus;
import com.cricket.vanillaplus.reference.GuiReference;
import com.cricket.vanillaplus.tiles.TileEntityRockCrusher;

public class BlockRockCrusher extends BlockContainer {
	
	private final Random rand = new Random();
    private final boolean isActive;
    private static boolean field_149934_M;
    private IIcon frontIcon;

    public BlockRockCrusher(Material material, boolean isActive)
    {
        super(Material.rock);
        this.isActive = isActive;
    }

    public Item getItemDropped(int par1, Random rand, int par2)
    {
        return Item.getItemFromBlock(Registry.BlockRockCrusherIdle);
    }
    
    public void onBlockAdded(World world, int x, int y, int z)
    {
        super.onBlockAdded(world, x, y, z);
        this.setDefaultDirection(world, x, y, z);
    }

    private void setDefaultDirection(World world, int x, int y, int z)
    {
        if (!world.isRemote)
        {
            Block var5 = world.getBlock(x, y, z - 1);
            Block var6 = world.getBlock(x, y, z + 1);
            Block var7 = world.getBlock(x - 1, y, z);
            Block var8 = world.getBlock(x + 1, y, z);
            byte var9 = 3;

            if (var5.func_149730_j() && !var6.func_149730_j())
            {
                var9 = 3;
            }

            if (var6.func_149730_j() && !var5.func_149730_j())
            {
                var9 = 2;
            }

            if (var7.func_149730_j() && !var8.func_149730_j())
            {
                var9 = 5;
            }

            if (var8.func_149730_j() && !var7.func_149730_j())
            {
                var9 = 4;
            }

            world.setBlockMetadataWithNotify(x, y, z, var9, 2);
        }
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    public IIcon getIcon(int side, int meta)
    {
        return side == 1 ? this.blockIcon : (side == 0 ? this.blockIcon : (side != meta ? this.blockIcon : this.frontIcon));
    }

    public void registerBlockIcons(IIconRegister register)
    {
        this.blockIcon = register.registerIcon("vanillaplus:BlockRockCrusherSide");
        this.frontIcon = register.registerIcon(this.isActive ? "vanillaplus:BlockRockCrusherFrontActive" : "vanillaplus:BlockRockCrusherFrontIdle");
    }

    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    public void randomDisplayTick(World world, int x, int y, int z, Random rand)
    {
        if (this.isActive)
        {
            int var6 = world.getBlockMetadata(x, y, z);
            float var7 = (float)x + 0.5F;
            float var8 = (float)y + 0.0F + rand.nextFloat() * 6.0F / 16.0F;
            float var9 = (float)z + 0.5F;
            float var10 = 0.52F;
            float var11 = rand.nextFloat() * 0.6F - 0.3F;

            if (var6 == 4)
            {
                world.spawnParticle("smoke", (double)(var7 - var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("flame", (double)(var7 - var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
            }
            else if (var6 == 5)
            {
                world.spawnParticle("smoke", (double)(var7 + var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("flame", (double)(var7 + var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
            }
            else if (var6 == 2)
            {
                world.spawnParticle("smoke", (double)(var7 + var11), (double)var8, (double)(var9 - var10), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("flame", (double)(var7 + var11), (double)var8, (double)(var9 - var10), 0.0D, 0.0D, 0.0D);
            }
            else if (var6 == 3)
            {
                world.spawnParticle("smoke", (double)(var7 + var11), (double)var8, (double)(var9 + var10), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("flame", (double)(var7 + var11), (double)var8, (double)(var9 + var10), 0.0D, 0.0D, 0.0D);
            }
        }
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par1, float par2, float par3, float par4)
    {
        if (world.isRemote)
        {
            return true;
        }
        else
        {
            TileEntityRockCrusher var10 = (TileEntityRockCrusher) world.getTileEntity(x, y, z);

            if (var10 != null)
            {
            	player.openGui(VanillaPlus.instance, GuiReference.guiIDRockCrusher, world, x, y, z);
            }

            return true;
        }
    }

    public static void func_149931_a(boolean active, World world, int x, int y, int z)
    {
        int var5 = world.getBlockMetadata(x, y, z);
        TileEntity var6 = world.getTileEntity(x, y, z);
        field_149934_M = true;

        if (active)
        {
            world.setBlock(x, y, z, Registry.BlockRockCrusherActive);
        }
        else
        {
           world.setBlock(x, y, z, Registry.BlockRockCrusherIdle);
        }

        field_149934_M = false;
        world.setBlockMetadataWithNotify(x, y, z, var5, 2);

        if (var6 != null)
        {
            var6.validate();
            world.setTileEntity(x, y, z, var6);
        }
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World world_, int par1)
    {
        return new TileEntityRockCrusher();
    }

    /**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack)
    {
        int var7 = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (var7 == 0)
        {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }

        if (var7 == 1)
        {
            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }

        if (var7 == 2)
        {
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }

        if (var7 == 3)
        {
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }

        if (stack.hasDisplayName())
        {
            ((TileEntityRockCrusher)world.getTileEntity(x, y, z)).setInventoryName(stack.getDisplayName());
        }
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int par1)
    {
        if (!field_149934_M)
        {
            TileEntityRockCrusher var7 = (TileEntityRockCrusher)world.getTileEntity(x, y, z);

            if (var7 != null)
            {
                for (int var8 = 0; var8 < var7.getSizeInventory(); ++var8)
                {
                    ItemStack var9 = var7.getStackInSlot(var8);

                    if (var9 != null)
                    {
                        float var10 = this.rand.nextFloat() * 0.8F + 0.1F;
                        float var11 = this.rand.nextFloat() * 0.8F + 0.1F;
                        float var12 = this.rand.nextFloat() * 0.8F + 0.1F;

                        while (var9.stackSize > 0)
                        {
                            int var13 = this.rand.nextInt(21) + 10;

                            if (var13 > var9.stackSize)
                            {
                                var13 = var9.stackSize;
                            }

                            var9.stackSize -= var13;
                            EntityItem var14 = new EntityItem(world, (double)((float)x + var10), (double)((float)y + var11), (double)((float)z + var12), new ItemStack(var9.getItem(), var13, var9.getItemDamage()));

                            if (var9.hasTagCompound())
                            {
                                var14.getEntityItem().setTagCompound((NBTTagCompound)var9.getTagCompound().copy());
                            }

                            float var15 = 0.05F;
                            var14.motionX = (double)((float)this.rand.nextGaussian() * var15);
                            var14.motionY = (double)((float)this.rand.nextGaussian() * var15 + 0.2F);
                            var14.motionZ = (double)((float)this.rand.nextGaussian() * var15);
                            world.spawnEntityInWorld(var14);
                        }
                    }
                }
                	world.func_147453_f(x, y, z, block);
            }
        }

        super.breakBlock(world, x, y, z, block, par1);
    }

    public boolean hasComparatorInputOverride()
    {
        return true;
    }

    public int getComparatorInputOverride(World world, int x, int y, int z, int side)
    {
        return Container.calcRedstoneFromInventory((IInventory)world.getTileEntity(x, y, z));
    }

    /**
     * Gets an item for the block being called on. Args: world, x, y, z
     */
    public Item getItem(World world, int x, int y, int z)
    {
        return Item.getItemFromBlock(Registry.BlockRockCrusherIdle);
    }
}
