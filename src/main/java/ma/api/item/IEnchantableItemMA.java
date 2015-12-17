package ma.api.item;

import net.minecraft.item.*;

public interface IEnchantableItemMA
{
	int getRuneCapacity (ItemStack stack);
	
	int getManaCapacity (ItemStack stack);
	
	boolean isProvideConformInfo_Enchantment (ItemStack stack);
	
	boolean isConform_Enchantment (ItemStack stack, ModConform modInfo, ItemStack[] input);
}