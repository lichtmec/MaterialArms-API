package ma.api.recipe.dynamic;

import ma.api.recipe.IRecipeCrusher;
import net.minecraft.item.ItemStack;

/**
 * Dynamically generate a crusher recipe.<br>
 * If none of the registered recipes match, Recipe system will be check this.
 * 
 * @author licht
 */
public interface IDynamicRecipeCrusher
{
	/**
	 * Generate recipe from input. ( return null : no matched )
	 */
	IRecipeCrusher generateRecipe (ItemStack stack, int machineTier);
}