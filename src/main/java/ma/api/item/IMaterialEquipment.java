package ma.api.item;

import net.minecraft.item.ItemStack;

/**
 * Associate Tool and Material.<br>
 * Mainly, It is used to determine the necessary hasMaterial in Tool-Customization.
 *
 * @author	licht
 */
public interface IMaterialEquipment
{
	boolean isMaterialTool (ItemStack stack);

	/**
	 *
	 * @param stack	That stack
	 *
	 * @return		Material name. ex) Iron, Gold, Diamond
	 */
	String getMaterial (ItemStack stack);
}