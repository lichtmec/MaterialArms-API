package ma.api.recipe;

import net.minecraft.item.*;

public interface IRecipeEnchantment
{
	boolean enchantableOnly ();
	
	boolean isMatch (ItemStack target, ItemStack[] inputStack);
	
	Object[] getResources ();
	
	ItemStack getOutput (ItemStack target, ItemStack[] inputStack);
}