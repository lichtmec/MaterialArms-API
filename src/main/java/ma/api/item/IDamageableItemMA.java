package ma.api.item;

import net.minecraft.item.*;

public interface IDamageableItemMA
{
	long getBaseConsumeDurability (ItemStack stack);
	
	boolean setItemDamage_ma (ItemStack stack, long damage);
	
	long getItemDamage_ma (ItemStack stack);
	
	long getMaxDurability (ItemStack stack);
}