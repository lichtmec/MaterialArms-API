package ma.api.item;

import net.minecraft.item.*;

public interface IElectricItemMA
{
	boolean isElectricItemMA (ItemStack stack);
	
	long getMaxChargeMAEU (ItemStack stack);
	
	boolean isAcceptCharge (ItemStack stack);
	
	boolean useCustomTag (ItemStack stack);
	
	String getTagCharge (ItemStack stack);
}