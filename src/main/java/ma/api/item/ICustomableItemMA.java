package ma.api.item;

import net.minecraft.item.*;

public interface ICustomableItemMA
{
	public boolean isProvideConformInfo_Customize (ItemStack stack);
	
	public boolean isConform_Customize (ItemStack stack, ModConform modInfo, ItemStack[] input);
}