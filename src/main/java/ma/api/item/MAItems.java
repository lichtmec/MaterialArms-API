package ma.api.item;

import net.minecraft.block.*;
import net.minecraft.item.*;

public final class MAItems
{
	private static Class<?> maItems;
	
	/**
	 * Get itemstack from MaterialArms
	 * 
	 * @param itemName	Name of Item or Block
	 * @param metadata	Item metadata
	 * @return			Result stack
	 */
	public static ItemStack getItem (String itemName, int metadata)
	{
		try
		{
			if (maItems != null)
			{
				Object ret = maItems.getField(itemName).get(null);
				if (ret instanceof Item)
				{
					return new ItemStack((Item)ret, 1, metadata);
				}
				else if (ret instanceof Block)
				{
					return new ItemStack((Block)ret, 1, metadata);
				}
			}
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
		
		return null;
	}
	
	public static Class<?> getItemClass ()
	{
		return maItems;
	}
}