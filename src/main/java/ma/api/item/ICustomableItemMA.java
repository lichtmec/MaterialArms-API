package ma.api.item;

import net.minecraft.item.*;

public interface ICustomableItemMA
{
	boolean isProvideConformInfo_Customize (ItemStack stack);
	
	boolean isConform_Customize (ItemStack stack, ModConform modInfo, ItemStack[] input);
}