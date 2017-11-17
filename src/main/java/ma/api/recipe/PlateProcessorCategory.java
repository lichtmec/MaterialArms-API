package ma.api.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public abstract class PlateProcessorCategory
{
	private List<IRecipePlateProcessor> recipes;

	public PlateProcessorCategory ()
	{
		recipes = new ArrayList<>();
	}

	public abstract String getCategoryUniqueName ();

	public boolean isAcceptableRecipe (IRecipePlateProcessor recipe)
	{
		return true;
	}

	public void addRecipe (IRecipePlateProcessor recipe)
	{
		if (recipe != null && isAcceptableRecipe(recipe))
		{
			recipes.add(recipe);
		}
	}

	public IRecipePlateProcessor getViableRecipe (ItemStack input, int machineTier)
	{
		IRecipePlateProcessor ret = null;

		for (IRecipePlateProcessor recipe : this.recipes)
		{
			if (recipe.isMatch(input) && recipe.getRequiredTier() <= machineTier)
			{
				ret = recipe;
				break;
			}
		}

		return ret;
	}

	public List<IRecipePlateProcessor> getRecipeList ()
	{
		return this.recipes;
	}

	public abstract ResourceLocation getGuiLabelLocation ();

	public abstract int getGuiLabelSrcX ();

	public abstract int getGuiLabelSrcY ();
}
