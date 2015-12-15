package ma.api.recipe.nei;

import ma.api.recipe.IRecipeCustomize;

public interface ICustomResourceTransformer
{
	public Object[] transform (IRecipeCustomize recipe);
}