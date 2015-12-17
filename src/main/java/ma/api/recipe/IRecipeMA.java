package ma.api.recipe;

import java.util.*;

import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.world.*;

import ma.api.*;
import ma.common.recipe.*;
import ma.common.recipe.Technology.UnderlyingTechnology;

public interface IRecipeMA
{
	boolean matches (InventoryCrafting craftMatrix, World world);
	
	ItemStack getCraftingResult (InventoryCrafting craftMatrix, ItemStack memory);
	
	int getRecipeSize ();

	ItemStack getRecipeOutput ();
	
	Object[] getResources ();
	
	UnderlyingTechnology[] getUTList ();
	
	ICraftItemGenHandler getHandler ();
}