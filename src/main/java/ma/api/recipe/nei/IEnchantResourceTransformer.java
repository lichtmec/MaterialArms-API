package ma.api.recipe.nei;

import ma.api.recipe.IRecipeEnchantment;

public interface IEnchantResourceTransformer
{
	public Object[] transform (IRecipeEnchantment recipe);
}