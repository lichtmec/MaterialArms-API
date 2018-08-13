package ma.api.recipe;

import net.minecraft.item.ItemStack;

public interface IRecipeCircuitAssembler
{
	boolean isMatch (ItemStack[] input);

	Object[] getResources ();

	int getRSConsumeAmount ();

	ItemStack getResult ();

	int getRequiredTime ();
}