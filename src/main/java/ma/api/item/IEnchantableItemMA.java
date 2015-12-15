package ma.api.item;

import net.minecraft.item.*;

public interface IEnchantableItemMA
{
	public int getRuneCapacity (ItemStack stack);
	
	public int getManaCapacity (ItemStack stack);
	
	public boolean isProvideConformInfo_Enchantment (ItemStack stack);
	
	public boolean isConform_Enchantment (ItemStack stack, ModConform modInfo, ItemStack[] input);
}