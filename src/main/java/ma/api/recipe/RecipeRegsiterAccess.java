package ma.api.recipe;

import ma.api.smaterial.SMatStack;
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

	public static void addFusemeltRecipe (IRecipeFusemelt recipe)
	{
		register.addFusemeltRecipe(recipe);
	}

	public static void addFusemeltRecipe (SMatStack output, Object[] input, int requiredTemp, int requiredTime)
	{
		register.addFusemeltRecipe(output, input, requiredTemp, requiredTime);
	}

	public static void addPulverizerRecipe (IRecipePulverizer recipe)
	{
		register.addPulverizerRecipe(recipe);
	}

	public static void addPulverizerRecipe (ItemStack input, byte category, int tierRequired, int timeRequired, ItemStack output, ItemStack subOutput, float subOutputChance)
	{
		register.addPulverizerRecipe(input, category, tierRequired, timeRequired, output, subOutput, subOutputChance);
	}

	public static void addCrusherRecipe (IRecipeCrusher recipe)
	{
		register.addCrusherRecipe(recipe);
	}

	public static void addCrusherRecipe (Object input, ItemStack output, int tierRequired, int timeRequired)
	{
		register.addCrusherRecipe(input, output, tierRequired, timeRequired);
	}

	public interface IRecipeRegister
	{
		void addMARecipe (IRecipeMA recipe);

		void addMARecipe (UnderlyingTechnology[] underlying, UnderlyingTechnology[] unlock, ICraftItemGenHandler genHandler, ItemStack output, Object ... input);

		void registerTechUnlocker (ITechUnlockable unlocker);

		void addFusemeltRecipe (IRecipeFusemelt recipe);

		void addFusemeltRecipe (SMatStack output, Object[] input, int requiredTemp, int requiredTime);

		void addPulverizerRecipe (IRecipePulverizer recipe);

		void addPulverizerRecipe (ItemStack input, byte category, int tierRequired, int timeRequired, ItemStack output, ItemStack subOutput, float subOutputChance);

		void addCrusherRecipe (IRecipeCrusher recipe);

		void addCrusherRecipe (Object input, ItemStack output, int tierRequired, int timeRequired);
	}
}