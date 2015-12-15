package ma.api.recipe;

import net.minecraft.item.*;

public interface IRecipeCustomize
{
	public boolean isMatch (ItemStack target, ItemStack[] inputStack);
	
	public ItemStack getOutput (ItemStack target, ItemStack[] inputStack);
}
