package ma.api.recipe;

import net.minecraft.item.ItemStack;

public interface IRecipeCrusher
{
	boolean isMatch (ItemStack stack, int machineTier);

	int getRequiredTier ();

	Object getResources ();

	ItemStack getOutput ();

	int getTimeRequired ();
}