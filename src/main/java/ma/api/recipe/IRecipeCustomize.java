package ma.api.recipe;

import net.minecraft.item.*;

public interface IRecipeCustomize
{
	boolean isMatch (ItemStack target, ItemStack[] inputStack);
	
	ItemStack getOutput (ItemStack target, ItemStack[] inputStack);
}
