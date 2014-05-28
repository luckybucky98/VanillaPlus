package com.cricket.vanillaplus.Recipes;

import java.util.HashMap;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.ShapedRecipes;

import com.cricket.vanillaplus.api.Registry;

import cpw.mods.fml.common.registry.GameRegistry;

public class Crafting {
	
	public static void loadCraftingRecipes(){
		GameRegistry.addRecipe(ItemStacks.cobbleStack, "xx","xx",'x',ItemStacks.pebbleStack);
		GameRegistry.addRecipe(ItemStacks.rockCrusherStack, "xyx","xzx","xxx",'x',ItemStacks.cobbleStack,'y',ItemStacks.stonePickStack,'z',ItemStacks.redstoneStack);
		GameRegistry.addShapelessRecipe(ItemStacks.lavaInfusedPlanksStack, ItemStacks.lavaInfusedLogStack);
		GameRegistry.addShapelessRecipe(ItemStacks.waterInfusedPlanksStack, ItemStacks.waterInfusedLogStack);
		GameRegistry.addRecipe(ItemStacks.furnaceStack, "xxx","x x","xxx",'x',ItemStacks.cobbleStack);
	}
	
	public static void replaceRecipe(ItemStack newOutput, Object... input)
	{
		List<ShapedRecipes> recipeList = CraftingManager.getInstance().getRecipeList();
		
		for(ShapedRecipes recipe: recipeList)
		{
			if(recipe.recipeItems.equals(getIngredients(input)))
				recipeList.remove(recipe);
		}
		CraftingManager.getInstance().addRecipe(newOutput, input);
	}
	
	private static ItemStack[] getIngredients(Object ... par2ArrayOfObj)
	{
		String s = "";
        int i = 0;
        int j = 0;
        int k = 0;

        if (par2ArrayOfObj[i] instanceof String[])
        {
            String[] astring = (String[])((String[])par2ArrayOfObj[i++]);

            for (int l = 0; l < astring.length; ++l)
            {
                String s1 = astring[l];
                ++k;
                j = s1.length();
                s = s + s1;
            }
        }
        else
        {
            while (par2ArrayOfObj[i] instanceof String)
            {
                String s2 = (String)par2ArrayOfObj[i++];
                ++k;
                j = s2.length();
                s = s + s2;
            }
        }

        HashMap<Character, ItemStack> hashmap;

        for (hashmap = new HashMap<Character, ItemStack>(); i < par2ArrayOfObj.length; i += 2)
        {
            Character character = (Character)par2ArrayOfObj[i];
            ItemStack itemstack1 = null;

            if (par2ArrayOfObj[i + 1] instanceof Item)
            {
                itemstack1 = new ItemStack((Item)par2ArrayOfObj[i + 1]);
            }
            else if (par2ArrayOfObj[i + 1] instanceof Block)
            {
                itemstack1 = new ItemStack((Block)par2ArrayOfObj[i + 1], 1, 32767);
            }
            else if (par2ArrayOfObj[i + 1] instanceof ItemStack)
            {
                itemstack1 = (ItemStack)par2ArrayOfObj[i + 1];
            }

            hashmap.put(character, itemstack1);
        }

        ItemStack[] aitemstack = new ItemStack[j * k];

        for (int i1 = 0; i1 < j * k; ++i1)
        {
            char c0 = s.charAt(i1);

            if (hashmap.containsKey(Character.valueOf(c0)))
            {
                aitemstack[i1] = ((ItemStack)hashmap.get(Character.valueOf(c0))).copy();
            }
            else
            {
                aitemstack[i1] = null;
            }
        }

        return aitemstack;
	}
}
