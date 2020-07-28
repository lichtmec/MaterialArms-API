package ma.api.recipe.dynamic;

import ma.api.recipe.IRecipePlateProcessor;
import ma.api.recipe.PlateProcessorCategory;
import net.minecraft.item.ItemStack;

/**
 * Dynamically generate a plate processor recipe.<br>
 * If none of the registered recipes match, Recipe system will be check this.
 *
 * @author licht
 */
public interface IDynamicRecipePlateProcessor
{
	/**
	 * Generate recipe from input and category. ( return null : no matched )
	 */
	IRecipePlateProcessor generateRecipe (ItemStack stack, int tier, PlateProcessorCategory selectedProcessorCategory);
}