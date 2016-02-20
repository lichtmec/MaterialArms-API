package ma.api.recipe;

public final class RecipeRegsiterAccess
{
	private static IRecipeRegister register;

	public static void addMARecipe (IRecipeMA recipe)
	{
		register.addMARecipe(recipe);
	}

	public static void registerRechUnlocker (ITechUnlockable unlocker)
	{
		register.registerTechUnlocker(unlocker);
	}

	public interface IRecipeRegister
	{
		void addMARecipe (IRecipeMA recipe);

		void registerTechUnlocker (ITechUnlockable unlocker);
	}
}