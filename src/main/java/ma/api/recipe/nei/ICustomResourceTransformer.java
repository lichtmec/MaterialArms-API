package ma.api.recipe.nei;

import ma.api.recipe.IRecipeCustomize;

public interface ICustomResourceTransformer
{
	Object[] transform (IRecipeCustomize recipe);
}