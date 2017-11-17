package ma.api.recipe;

import net.minecraft.item.ItemStack;

public interface IRecipePlateProcessor
{
	boolean isMatch (ItemStack stack);

	int getRequiredTier ();

	Object getResources ();

	ItemStack getOutput ();

	int getTimeRequired ();
}