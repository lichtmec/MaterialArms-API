package ma.api.recipe;

public final class RecipeRegsiterAccess
{
	private static IRecipeRegister register;

	public static void addShapedRecipe (IRecipeMA recipe)
	{
		register.addShapedRecipe(recipe);
	}

	public interface IRecipeRegister
	{
		void addShapedRecipe (IRecipeMA recipe);
	}
}