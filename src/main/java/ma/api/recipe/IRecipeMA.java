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
	public boolean matches (InventoryCrafting craftMatrix, World world);
	
	public ItemStack getCraftingResult (InventoryCrafting craftMatrix, ItemStack memory);
	
	public int getRecipeSize ();
	
	public ItemStack getRecipeOutput ();
	
	public Object[] getResources ();
	
	public UnderlyingTechnology[] getUTList ();
	
	public ICraftItemGenHandler getHandler ();
}