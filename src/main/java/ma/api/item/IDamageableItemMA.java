package ma.api.item;

import net.minecraft.item.*;

public interface IDamageableItemMA
{
	public long getBaseConsumeDurability (ItemStack stack);
	
	public boolean setItemDamage_ma (ItemStack stack, long damage);
	
	public long getItemDamage_ma (ItemStack stack);
	
	public long getMaxDurability (ItemStack stack);
}