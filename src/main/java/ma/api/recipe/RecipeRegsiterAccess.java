package ma.api.recipe;

import net.minecraft.item.ItemStack;
import ma.api.recipe.Technology.UnderlyingTechnology;

/**
 * MaterialArms Recipe Register Accesser
 *
 * @author	licht
 */
public final class RecipeRegsiterAccess
{
	private static IRecipeRegister register;

	/**
	 * Add MA-Crafting Recipe from recipe-instance.
	 */
	public static void addMARecipe (IRecipeMA recipe)
	{
		register.addMARecipe(recipe);
	}

	/**
	 * Add MA-Crafting Recipe from some parameters.
	 */
	public static void addMARecipe (UnderlyingTechnology[] underlying, UnderlyingTechnology[] unlock, ICraftItemGenHandler genHandler, ItemStack output, Object ... input)
	{
		register.addMARecipe(underlying, unlock, genHandler, output, input);
	}

	/**
	 * Add unlockable recipe.
	 */
	public static void registerRechUnlocker (ITechUnlockable unlocker)
	{
		register.registerTechUnlocker(unlocker);
	}

	public interface IRecipeRegister
	{
		void addMARecipe (IRecipeMA recipe);

		void addMARecipe (UnderlyingTechnology[] underlying, UnderlyingTechnology[] unlock, ICraftItemGenHandler genHandler, ItemStack output, Object ... input);

		void registerTechUnlocker (ITechUnlockable unlocker);
	}
}