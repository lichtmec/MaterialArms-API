package ma.api.recipe;

import net.minecraft.item.*;

public interface IRecipeEnchantment
{
	public boolean enchantableOnly ();
	
	public boolean isMatch (ItemStack target, ItemStack[] inputStack);
	
	public Object[] getResources ();
	
	public ItemStack getOutput (ItemStack target, ItemStack[] inputStack);
}