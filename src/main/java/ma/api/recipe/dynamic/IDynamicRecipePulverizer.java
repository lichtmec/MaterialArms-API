package ma.api.recipe.dynamic;

import ma.api.recipe.IRecipePulverizer;
import net.minecraft.item.ItemStack;

/**
 * Dynamically generate a pulverizer recipe.<br>
 * If none of the registered recipes match, Recipe system will be check this.
 *
 * @author licht
 */
public interface IDynamicRecipePulverizer
{
	/**
	 * Generate recipe from input. ( return null : no matched )
	 */
	IRecipePulverizer generateRecipe (ItemStack input, int tier, int pulverizer);
}