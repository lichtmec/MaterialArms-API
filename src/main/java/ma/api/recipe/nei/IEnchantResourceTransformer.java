package ma.api.recipe.nei;

import ma.api.recipe.IRecipeEnchantment;

public interface IEnchantResourceTransformer
{
	Object[] transform (IRecipeEnchantment recipe);
}